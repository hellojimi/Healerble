package com.zero.healerble.service.impl;

import com.zero.healerble.dto.Auth;
import com.zero.healerble.entity.MemberEntity;
import com.zero.healerble.exception.ExceptionResponse;
import com.zero.healerble.exception.code.ErrorCode;
import com.zero.healerble.repository.MemberRepository;
import com.zero.healerble.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public MemberEntity signUp(Auth.SignUp member) {
    // 회원 중복 확인
    boolean exists = memberRepository.existsByEmail(member.getEmail());
    if (exists) {
      throw new ExceptionResponse(ErrorCode.DUPLICATED_USER);
    }

    // 비밀번호 암호화
    member.setPassword(passwordEncoder.encode(member.getPassword()));

    return memberRepository.save(member.toEntity());
  }

  @Override
  public MemberEntity authenticate(Auth.SignIn member) {
    MemberEntity result = memberRepository.findByEmail(member.getEmail())
        .orElseThrow(() -> new ExceptionResponse(ErrorCode.NOT_FOUND_USER));

    if (!passwordEncoder.matches(member.getPassword(), result.getPassword())) {
      throw new ExceptionResponse(ErrorCode.UNMATCHED_PASSWORD);
    }

    return result;
  }
}
