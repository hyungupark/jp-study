package com.jp.blog.blog.service;

import com.jp.blog.blog.domain.Blog;
import com.jp.blog.blog.domain.BlogDto;
import com.jp.blog.blog.mapper.BlogMapper;
import com.jp.blog.blog.repository.BlogRepository;
import com.jp.blog.member.domain.Member;
import com.jp.blog.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
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
    public Optional<BlogDto> createBlog(UUID userId, Blog blog) {
        try {
            Optional<Member> member = memberService.readMemberById(userId);
            if (member.isPresent()) {
                blog.setAuthor(member.get());
                Blog newBlog = blogRepository.save(blog);
                return Optional.of(BlogMapper.toDto(newBlog));
            } else {
                throw new Exception("Member not found");
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /// Read
    public List<BlogDto> getBlogs() {
        System.out.println("blogRepository.findAll");
        return blogRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt")).stream().map(BlogMapper::toDto).toList();
    }

    public List<BlogDto> getBlogsByUser(UUID userId) {
        return blogRepository.findByAuthorIdOrderByCreatedAtDesc(userId).stream().map(BlogMapper::toDto).toList();
    }

    public Optional<BlogDto> getBlogById(UUID blogId) {
        return blogRepository.findById(blogId).map(BlogMapper::toDto);
    }

    /// Update

    /// Delete
    public void deleteBlogById(UUID blogId) {
        blogRepository.deleteById(blogId);
    }
}
