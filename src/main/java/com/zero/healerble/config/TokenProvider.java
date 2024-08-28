package com.zero.healerble.config;

import com.zero.healerble.common.type.Role;
import com.zero.healerble.repository.MemberRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class TokenProvider {

  private static final String KEY_ROLES = "roles";
  private static final long TOKEN_EXPIRE_TIME = 1000 * 60 * 60;

  private final MemberRepository memberRepository;

  @Value("{spring.jwt.secret}")
  private String secretKey;

  // 토큰 생성
  public String getGenerateToken(String username, Role role) {
    Claims claims = Jwts.claims().setSubject(username);
    claims.put(KEY_ROLES, role);

    Date now = new Date();
    Date expiredDate = new Date(now.getTime() + TOKEN_EXPIRE_TIME);

    return Jwts.builder()
        .setClaims(claims)
        .setIssuedAt(now)
        .setExpiration(expiredDate)
        .signWith(SignatureAlgorithm.ES512, secretKey)
        .compact();
  }

  // 토큰 유효성 검증
  public boolean validateToken(String token) {
    if(!StringUtils.hasText(token)) return false;

    Claims claims = parseClaims(token);
    return !claims.getExpiration().before(new Date());
  }

  public Authentication getAuthentication(String jwt) {
    CustomUserDetails customUserDetails = new CustomUserDetails(memberRepository);
    UserDetails userDetails = customUserDetails.loadUserByUsername(getUsername(jwt));

    return new UsernamePasswordAuthenticationToken(
        userDetails, "", userDetails.getAuthorities()
    );
  }

  public String getUsername(String token) {
    return parseClaims(token).getSubject();
  }

  private Claims parseClaims(String token) {
    try {
      return Jwts.parserBuilder()
          .setSigningKey(secretKey)
          .build()
          .parseClaimsJws(token)
          .getBody();
    } catch (ExpiredJwtException e) {
      return e.getClaims();
    }
  }

}
