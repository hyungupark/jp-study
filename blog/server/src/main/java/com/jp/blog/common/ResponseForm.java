package com.jp.blog.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseForm<T> {
    private final boolean success;
    private final String message;
    private final T data;
}
