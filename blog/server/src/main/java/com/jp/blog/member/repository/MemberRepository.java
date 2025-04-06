package com.jp.blog.member.repository;

import com.jp.blog.member.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<MemberDTO, UUID>{
    Optional<MemberDTO> findByUsernameAndPassword(String username, String password);
}