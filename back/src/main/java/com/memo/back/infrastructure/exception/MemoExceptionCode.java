package com.memo.back.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemoExceptionCode {
  SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,
      "MEMO_000",
      "internal server error"),;
  private final HttpStatus status;
  private final String code;
  private final String message;
}
