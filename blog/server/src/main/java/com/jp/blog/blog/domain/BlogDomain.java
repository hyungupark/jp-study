package com.jp.blog.blog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="Blog")
public class BlogDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="blog_id")
    private UUID blogId;

    @Column(nullable = false, name="blog_title", length=255)
    private String blogTitle;
    @Column(nullable = false, name="blog_content", length=255)
    private String blogContent;
    @Column(nullable = false, name="created_at", length=255)
    private Date createdAt;
    @Column(nullable = false, name="user_id", length=255)
    private String userId;
}
