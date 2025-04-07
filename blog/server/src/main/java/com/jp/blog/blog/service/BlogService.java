package com.jp.blog.blog.service;

import com.jp.blog.blog.domain.Blog;
import com.jp.blog.blog.repository.BlogRepository;
import com.jp.blog.member.domain.Member;
import com.jp.blog.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final MemberService memberService;

    /// Create
    public Optional<Blog> createBlog(UUID userId, Blog blog) {
        try {
            Optional<Member> member = memberService.readMemberById(userId);
            if (member.isPresent()) {
                blog.setAuthor(member.get());
                return Optional.of(blogRepository.save(blog));
            } else {
                throw new Exception("Member not found");
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /// Read
    public List<Blog> getBlogs() {
        System.out.println("blogRepository.findAll");
        return blogRepository.findAll();
    }

    public List<Blog> getBlogsByUser(UUID userId) {
        return blogRepository.findAll();
    }

    public Optional<Blog> getBlogById(UUID blogId) {
        return blogRepository.findById(blogId);
    }

    /// Update

    /// Delete
    public void deleteBlogById(UUID blogId) {
        blogRepository.deleteById(blogId);
    }
}
