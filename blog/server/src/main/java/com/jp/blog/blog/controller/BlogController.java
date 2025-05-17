package com.jp.blog.blog.controller;

import com.jp.blog.blog.domain.Blog;
import com.jp.blog.blog.domain.BlogDto;
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
    public ResponseEntity<ResponseForm<Optional<BlogDto>>> createBlog(@PathVariable(name = "user_id") UUID userId, @RequestBody Blog blog) {
        System.out.println(" ++++++++++++ ");
        System.out.println(blog);
        System.out.println(" ------------ ");
        Optional<BlogDto> blogDto = blogService.createBlog(userId, blog);
        if (blogDto.isPresent()) {
            return ResponseEntity.ok(new ResponseForm<>(true, "Blog " + blogDto.get().getTitle() + " created", blogDto));
        } else {
            return ResponseEntity.ok(new ResponseForm<>(false, "Create blog error", null));
        }
    }

    /// Read
    @GetMapping()
    public ResponseEntity<ResponseForm<List<BlogDto>>> getBlogs() {
        return ResponseEntity.ok(new ResponseForm<>(true, "", blogService.getBlogs()));
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<ResponseForm<List<BlogDto>>> getBlogsByUser(@PathVariable(name = "user_id") UUID userId) {
        return ResponseEntity.ok(new ResponseForm<>(true, "", blogService.getBlogsByUser(userId)));
    }

    @GetMapping("/{blog_id}")
    public ResponseEntity<ResponseForm<Optional<BlogDto>>> getBlogById(@PathVariable(name = "blog_id") UUID blogId) {
        return ResponseEntity.ok(new ResponseForm<>(true, "", blogService.getBlogById(blogId)));
    }

    /// Update

    /// Delete
}
