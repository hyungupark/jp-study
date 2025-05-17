package com.jp.blog.blog.mapper;

import com.jp.blog.blog.domain.Blog;
import com.jp.blog.blog.domain.BlogDto;

public class BlogMapper {
    public static BlogDto toDto(Blog blog) {
        return BlogDto.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .content(blog.getContent())
                .createdAt(blog.getCreatedAt())
                .authorId(blog.getAuthor().getId())
                .authorName(blog.getAuthor().getUsername())
                .build();
    }
}
