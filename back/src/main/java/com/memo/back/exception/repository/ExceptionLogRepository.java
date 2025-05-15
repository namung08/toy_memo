package com.memo.back.exception.repository;

import com.memo.back.exception.model.ExceptionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionLogRepository extends JpaRepository<ExceptionLog, Long> {
  }
