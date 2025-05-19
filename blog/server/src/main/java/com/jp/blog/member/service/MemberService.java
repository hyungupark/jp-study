package com.jp.blog.member.service;

import com.jp.blog.common.ResponseForm;
import com.jp.blog.member.domain.Member;
import com.jp.blog.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Optional<Member> createdMember(String username, String password) {
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setCreatedAt(LocalDateTime.now());
        Member toMember = memberRepository.save(member);

        return Optional.of(toMember);
    }

    public Optional<Member> deletedMember(UUID id) {
        Member member = new Member();
        member.setId(id);
        memberRepository.delete(member);

        return Optional.of(member);
    }

    public Optional<Member> readMemberById(UUID id) {
        return memberRepository.findById(id);
    }

    public Optional<Member> readMember(String username, String password) {
        return memberRepository.findByUsernameAndPassword(username, password);
    }
    public Optional<Member> findById(UUID id) {
        return memberRepository.findById(id);
    }

    public Optional<Member> updateMember(UUID id, String username, String password) {
        Member member = new Member();
        member.setId(id);
        member.setUsername(username);
        member.setPassword(password);

        memberRepository.save(member);

        return Optional.of(member);
    }
}
