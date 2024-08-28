package com.zero.healerble.dto;

import com.zero.healerble.common.type.Role;
import com.zero.healerble.entity.MemberEntity;
import java.time.LocalDateTime;
import lombok.Data;

public class Auth {

  @Data
  public static class SignUp {
    private String email;
    private String nickname;
    private String password;

    public MemberEntity toEntity() {
      return MemberEntity.builder()
          .email(email)
          .nickname(nickname)
          .password(password)
          .memberRole(Role.USER)
          .registerAt(LocalDateTime.now())
          .build();
    }
  }

  @Data
  public static class SignIn {
    private String email;
    private String password;
  }
}
