package com.memo.back.infrastructure.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@Getter
public class MemoException extends RuntimeException {
  private final HttpStatus status;
  private final String code;
  private final String message;

  public MemoException(MemoExceptionCode e) {
    this.code = e.getCode();
    this.message = e.getMessage();
    this.status = e.getStatus();
  }
}
