package com.jp.blog.common;

public record ResponseForm<T>(boolean success, String message, T data) {
}
