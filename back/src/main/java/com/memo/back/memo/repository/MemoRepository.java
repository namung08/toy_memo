package com.memo.back.memo.repository;

import com.memo.back.memo.model.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MemoRepository extends JpaRepository<Memo, Long> {
  @Transactional
  @Modifying
  @Query("update Memo m set m.title = ?1, m.content = ?2 where m.id = ?3")
  int updateTitleAndContentById(String title, String content, Long id);
}
