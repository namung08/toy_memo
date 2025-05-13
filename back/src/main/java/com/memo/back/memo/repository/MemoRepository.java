package com.memo.back.memo.repository;

import com.memo.back.memo.model.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
