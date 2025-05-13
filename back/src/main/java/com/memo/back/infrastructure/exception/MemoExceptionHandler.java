package com.memo.back.infrastructure.exception;

import com.memo.back.web.dto.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class MemoExceptionHandler {
  private ErrorMessage buildErrorMessage(String code, String message) {
    return new ErrorMessage(code, message);
  }

  @ExceptionHandler(MemoException.class)
  public ResponseEntity<CommonResponse<ErrorMessage>> handleException(final MemoException e) {
    log.warn("Memo Exception: \n", e);
    return ResponseEntity.status(e.getStatus()).body(
        CommonResponse.fail(buildErrorMessage(e.getCode(), e.getMessage()))
    );
  }
}
