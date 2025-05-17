package com.jp.blog.blog.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class BlogDto {
    private UUID id;
    private String title;
    private String content;
    private UUID authorId;
    private String authorName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
