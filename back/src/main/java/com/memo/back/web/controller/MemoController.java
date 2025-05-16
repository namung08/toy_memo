package com.memo.back.web.controller;

import com.memo.back.memo.model.Memo;
import com.memo.back.memo.service.MemoService;
import com.memo.back.web.dto.common.CommonResponse;
import com.memo.back.web.dto.memo.MemoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memo")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // Vite 기본 포트
public class MemoController {
  private final MemoService service;

  @PostMapping("/create")
  public ResponseEntity<CommonResponse<String>> createMemo(@RequestBody MemoRequestDTO dto) {
    service.createMemo(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.success(messageBuilder("생성")));
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<CommonResponse<String>> updateMemo(@PathVariable Long id, @RequestBody MemoRequestDTO dto) {
    service.updateMeme(id, dto);
    return ResponseEntity.ok(CommonResponse.success(messageBuilder("변경")));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<CommonResponse<String>> deleteMemo(@PathVariable Long id) {
    service.deleteMeme(id);
    return ResponseEntity.ok(CommonResponse.success(messageBuilder("삭제")));
  }

  @GetMapping("/list")
  public ResponseEntity<CommonResponse<List<Memo>>> getMemo() {
    return ResponseEntity.ok(CommonResponse.success(service.getMemo()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<CommonResponse<Memo>> getMemo(@PathVariable Long id) {
    return ResponseEntity.ok(CommonResponse.success(service.getMemo(id)));
  }

  private String messageBuilder(String message) {
    return "메모가 성공적으로 "+message+" 되었습니다.";
  }
}
