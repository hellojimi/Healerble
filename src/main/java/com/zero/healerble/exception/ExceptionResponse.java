package com.zero.healerble.exception;

import com.zero.healerble.exception.code.ErrorCode;
import lombok.Getter;

@Getter
public final class ExceptionResponse extends RuntimeException {

  private final int statusCode;
  private final String errorMsg;

  public ExceptionResponse(ErrorCode errorCode) {
    this.statusCode = errorCode.getStatusCode();
    this.errorMsg = errorCode.getErrorMsg();
  }
}
