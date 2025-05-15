package com.memo.back.exception.service;

import com.memo.back.exception.model.ExceptionLog;
import com.memo.back.exception.repository.ExceptionLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExceptionLogServiceImpl implements ExceptionLogService {
  private final ExceptionLogRepository repository;

  @Override
  public void saveLog(ExceptionLog log) {
    repository.save(log);
  }
}
