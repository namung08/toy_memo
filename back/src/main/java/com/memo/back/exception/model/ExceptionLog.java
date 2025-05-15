package com.memo.back.exception.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "exception_log")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionLog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(nullable = false)
  private String code;

  @Setter
  @Column(nullable = false)
  private String message;

  @Setter
  @Column(nullable = false)
  private String stacktrace;

  @Setter
  @Column(nullable = false)
  private String requestUri;

  @Setter
  @Column(nullable = false)
  private String httpMethod;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @PrePersist
  public void prePersist() {
    this.createdAt = LocalDateTime.now();
  }
}
