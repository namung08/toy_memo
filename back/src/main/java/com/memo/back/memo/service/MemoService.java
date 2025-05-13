package com.memo.back.memo.service;

import com.memo.back.memo.model.Memo;
import com.memo.back.web.dto.memo.MemoRequestDTO;

import java.util.List;

/**
 * 메모에 대한 비즈니스 로직을 처리하는 서비스 인터페이스입니다.
 * <p>
 * 메모 생성, 수정, 삭제, 조회 등의 기능을 정의합니다.
 * </p>
 *
 * @author 이상준
 * @since 2025-05-13
 * @version 1.0
 */
public interface MemoService {
  /**
   * 새로운 메모를 생성합니다.
   *
   * @param memoRequestDTO 생성할 메모의 제목과 내용 정보가 담긴 DTO
   */
  void createMemo(MemoRequestDTO memoRequestDTO);

  /**
   * 특정 ID를 가진 메모를 수정합니다.
   *
   * @param id 수정할 메모의 ID
   * @param memoRequestDTO 수정할 메모의 제목과 내용 정보가 담긴 DTO
   */
  void updateMeme(Long id, MemoRequestDTO memoRequestDTO);

  /**
   * 특정 ID를 가진 메모를 삭제합니다.
   *
   * @param id 삭제할 메모의 ID
   */
  void deleteMeme(Long id);

  /**
   * 모든 메모를 조회합니다.
   *
   * @return 전체 메모 목록
   */
  List<Memo> getMemo();

  /**
   * 특정 ID를 가진 메모를 조회합니다.
   *
   * @param id 조회할 메모의 ID
   * @return 조회된 메모 객체
   */
  Memo getMemo(Long id);
}
