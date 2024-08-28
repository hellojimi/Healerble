package com.zero.healerble.service;

import com.zero.healerble.dto.Auth;
import com.zero.healerble.entity.MemberEntity;

public interface MemberService {

  MemberEntity signUp(Auth.SignUp signUp);

  MemberEntity authenticate(Auth.SignIn signIn);

}
