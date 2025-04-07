package com.jp.blog.blog.controller;

import com.jp.blog.blog.domain.Blog;
import com.jp.blog.blog.service.BlogService;
import com.jp.blog.common.ResponseForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    /// Create
    @PostMapping("/{user_id}")
    public ResponseEntity<ResponseForm<Optional<Blog>>> createBlog(@PathVariable(name = "user_id") UUID userId_, @RequestBody Blog blog_) {
        System.out.println(blog_.getTitle());
        System.out.println(blog_.getContent());
        Optional<Blog> blog = blogService.createBlog(userId_, blog_);
        if (blog.isPresent()) {
            return ResponseEntity.ok(new ResponseForm<>(true, "Blog " + blog.get().getTitle() + " created", blog));
        } else {
            return ResponseEntity.ok(new ResponseForm<>(false, "Create blog error", null));
        }
    }

    /// Read
    @GetMapping()
    public ResponseEntity<ResponseForm<List<Blog>>> getBlogs() {
        return ResponseEntity.ok(new ResponseForm<>(true, "", blogService.getBlogs()));
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<ResponseForm<List<Blog>>> getBlogsByUser(@PathVariable(name = "user_id") UUID userId_) {
        return ResponseEntity.ok(new ResponseForm<>(true, "", blogService.getBlogsByUser(userId_)));
    }

    @GetMapping("/{blog_id}")
    public ResponseEntity<ResponseForm<Optional<Blog>>> getBlogById(@PathVariable(name = "blog_id") UUID blogId_) {
        Optional<Blog> blog = blogService.getBlogById(blogId_);
        if (blog.isPresent()) {
            return ResponseEntity.ok(new ResponseForm<>(true, "", blog));
        } else {
            return ResponseEntity.ok(new ResponseForm<>(false, "Blog not found", null));
        }
    }

    /// Update

    /// Delete
}
