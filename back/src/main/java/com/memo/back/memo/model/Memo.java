package com.memo.back.memo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "memo")
@Getter
public class Memo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(nullable = true)
  private String title;

  @Setter
  @Column(nullable = false)
  private String content;

  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private LocalDateTime updatedAt;

  // 엔티티가 처음 저장되기 전에 호출됩니다.
  @PrePersist
  public void prePersist() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  // 엔티티가 업데이트 되기 전에 호출
  @PreUpdate
  public void preUpdate() {
    this.updatedAt = LocalDateTime.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Memo memo)) return false;
    return Objects.equals(getId(), memo.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId());
  }
}
