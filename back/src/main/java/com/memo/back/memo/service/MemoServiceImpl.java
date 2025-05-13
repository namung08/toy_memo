package com.memo.back.memo.service;

import com.memo.back.infrastructure.exception.MemoException;
import com.memo.back.infrastructure.exception.MemoExceptionCode;
import com.memo.back.memo.model.Memo;
import com.memo.back.memo.repository.MemoRepository;
import com.memo.back.web.dto.memo.MemoRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemoServiceImpl implements MemoService {
  private final MemoRepository repository;

  @Override
  public void createMemo(MemoRequestDTO memoRequestDTO) {
    // 저장할 메모 객체 생성
    Memo memo = new Memo(memoRequestDTO);
    // 메모 객체가 정상적으로 생성이 되었는지 확인
    log.info(memo.toString());
    // 메모를 저장
    repository.save(memo);
  }

  @Override
  public void updateMeme(Long id, MemoRequestDTO memoRequestDTO) {
    // 해당 메모가 실제로 존재하는 지 확인
    repository.findById(id).orElseThrow(
        () -> new MemoException(MemoExceptionCode.NOT_FOUND_MEMO)
    );
    // 존재가 확인 되면 해당 메모를 업데이트
    int result = repository.updateTitleAndContentById(memoRequestDTO.title(), memoRequestDTO.content(), id);
    // 정상 적으로 업데이터가 되었다면 result 는 1이 됨
    log.info("Update title and content: {}", result);
  }

  @Override
  public void deleteMeme(Long id) {
    // 해당 메모가 실제로 존재하는 지 확인
    repository.findById(id).orElseThrow(
        () -> new MemoException(MemoExceptionCode.NOT_FOUND_MEMO)
    );
    // 존재가 확인 되면 해당 메모 삭제
    repository.deleteById(id);
    log.info("Delete memo: {}", id);
  }

  @Override
  public List<Memo> getMemo() {
    // 해당 프로젝트는 하나의 사용자만 사용하므로 모든 메모를 반환
    return repository.findAll();
  }

  @Override
  public Memo getMemo(Long id) {
    // 해당 메모가 실제로 존재하는 지 확인 후 메모의 상세 정보 반환
    return repository.findById(id).orElseThrow(
            () -> new MemoException(MemoExceptionCode.NOT_FOUND_MEMO)
        );
  }
}
