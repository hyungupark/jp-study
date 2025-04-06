package com.jp.blog.member.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="member_id")
    private UUID memberId;

    @Column(name="member_name", nullable = false)
    private String memberName;

    @Column(name="member_pwd", nullable = false)
    private String memberPwd;

    @Column(name="created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}