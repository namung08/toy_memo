package com.memo.back.infrastructure.exception;

import com.memo.back.exception.model.ExceptionLog;
import com.memo.back.exception.service.ExceptionLogService;
import com.memo.back.web.dto.common.CommonResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class MemoExceptionHandler {
  private final ExceptionLogService exceptionLogService;
  private ErrorMessage buildErrorMessage(String code, String message) {
    return new ErrorMessage(code, message);
  }

  @ExceptionHandler(MemoException.class)
  public ResponseEntity<CommonResponse<ErrorMessage>> handleException(final MemoException e, final HttpServletRequest request) {
    log.warn("Memo Exception: \n", e);
    StringBuilder sb = new StringBuilder();
    for (StackTraceElement element : e.getStackTrace()) {
      sb.append(element.toString()).append("\n");
    }
    ExceptionLog logInfo = ExceptionLog.builder()
        .code(e.getCode())
        .message(e.getMessage())
        .stacktrace(sb.toString())
        .httpMethod(request.getMethod())
        .requestUri(request.getRequestURI())
        .build();
    exceptionLogService.saveLog(logInfo);

    return ResponseEntity.status(e.getStatus()).body(
        CommonResponse.fail(buildErrorMessage(e.getCode(), e.getMessage()))
    );
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<CommonResponse<String>> handleException(final Exception e, HttpServletRequest request) {
    log.warn("Exception: \n", e);
    StringBuilder sb = new StringBuilder();
    for (StackTraceElement element : e.getStackTrace()) {
      sb.append(element.toString()).append("\n");
    }
    ExceptionLog logInfo = ExceptionLog.builder()
        .code(e.getClass().getName())
        .message(e.getMessage())
        .stacktrace(sb.toString())
        .httpMethod(request.getMethod())
        .requestUri(request.getRequestURI())
        .build();
    exceptionLogService.saveLog(logInfo);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
        CommonResponse.fail(e.getMessage())
    );
  }
}
