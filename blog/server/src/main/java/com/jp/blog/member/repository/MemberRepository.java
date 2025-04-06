package com.jp.blog.member.repository;

import com.jp.blog.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID>{
    Optional<Member> findByUsernameAndPassword(String username, String password);
}