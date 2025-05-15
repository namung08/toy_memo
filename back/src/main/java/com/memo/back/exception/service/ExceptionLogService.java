package com.memo.back.exception.service;

import com.memo.back.exception.model.ExceptionLog;

public interface ExceptionLogService {
  void saveLog(ExceptionLog log);
}
