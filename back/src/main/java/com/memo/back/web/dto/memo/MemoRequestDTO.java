package com.memo.back.web.dto.memo;

import jakarta.validation.constraints.NotBlank;

/**
 * 메모의 생성 및 수정을 위해 사용할 request dto
 * @param title 메모의 제목
 * @param content 메모의 내용
 */
public record MemoRequestDTO(
    String title,
    @NotBlank(message = "메모의 내용을 필수 사항입니다.")
    String content
) {
}
