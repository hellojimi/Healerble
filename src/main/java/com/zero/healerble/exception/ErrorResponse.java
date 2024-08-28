package com.zero.healerble.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
  private int statusCode;
  private String errorMsg;
}
