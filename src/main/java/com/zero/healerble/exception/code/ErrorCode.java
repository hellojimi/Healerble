package com.zero.healerble.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  /**
   * ******************************* Global Error CodeList ******************************
   * HTTP Status Code
   * 400 : Bad Request
   * 401 : Unauthorized
   * 403 : Forbidden
   * 404 : Not Found
   * 500 : Internal Server Error
   * ************************************************************************************
   */

  DUPLICATED_USER(HttpStatus.BAD_REQUEST.value(), "이미 존재하는 회원입니다."),
  NOT_FOUND_USER(HttpStatus.NOT_FOUND.value(), "존재하지 않는 회원입니다."),

  UNMATCHED_PASSWORD(HttpStatus.BAD_REQUEST.value(), "일치하지 않는 비밀번호입니다.")
  ;

  private final int statusCode;
  private final String errorMsg;
}
