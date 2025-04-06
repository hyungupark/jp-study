package com.jp.blog.member.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="member_id")
    private UUID memberId;

    @Column(nullable = false, name="member_name", length=255)
    private String memberName;

    @Column(nullable = false, name="member_pwd", length=255)
    private String memberPwd;

    @Column(nullable = false, name="created_at", length=255)
    private LocalDateTime createdAt;

}