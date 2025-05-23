package com.jp.blog.blog.repository;

import com.jp.blog.blog.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BlogRepository extends JpaRepository<Blog, UUID> {
    ///  Create

    ///  Read
    List<Blog> findByAuthorIdOrderByCreatedAtDesc(UUID authorId);

    ///  Update

    ///  Delete
}
