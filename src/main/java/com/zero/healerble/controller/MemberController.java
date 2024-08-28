package com.zero.healerble.controller;

import com.zero.healerble.config.TokenProvider;
import com.zero.healerble.dto.Auth;
import com.zero.healerble.entity.MemberEntity;
import com.zero.healerble.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;
  private final TokenProvider tokenProvider;

  // 회원가입
  @PostMapping("/auth/signup")
  public ResponseEntity<?> signUp(@RequestBody @Valid Auth.SignUp request) {
    MemberEntity memberEntity = memberService.signUp(request);

    return new ResponseEntity<>(memberEntity, HttpStatus.OK);
  }

  // 로그인
  @PostMapping("/auth/singin")
  public ResponseEntity<?> signIn(@RequestBody @Valid Auth.SignIn request) {
    MemberEntity member = memberService.authenticate(request);
    String generateToken = tokenProvider.getGenerateToken(
        member.getEmail(), member.getMemberRole()
    );

    log.info("login user -> " + request.toString());

    return new ResponseEntity<>(generateToken, HttpStatus.OK);
  }
}
