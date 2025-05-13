package com.memo.back.infrastructure.exception;

public record ErrorMessage(
    String errorCode,
    String message
) {
}
