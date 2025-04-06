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

    public Optional<Member> createdMember (
            String memberName,
            String memberPwd) {

        Member member = new Member();
        member.setMemberName(memberName);
        member.setMemberPwd(memberPwd);
        member.setCreatedAt(LocalDateTime.now());
        Member toMember = memberRepository.save(member);

        return Optional.of(toMember);
    }

    public Optional<Member>  deletedMember (
            UUID memberId
    ) {
        Member member = new Member();
        member.setMemberId(memberId);
        memberRepository.delete(member);

        return Optional.of(member);
    }

    public Optional<Member> readMember (
            String memberName,
            String memberPwd
    ) {
        return memberRepository.findByMemberNameAndMemberPwd(memberName, memberPwd);
    }

    public Optional<Member> updateMember (
            UUID memberId,
            String memberName,
            String memberPwd
    ) {
        Member member = new Member();
        member.setMemberId(memberId);
        member.setMemberName(memberName);
        member.setMemberPwd(memberPwd);

        memberRepository.save(member);

        return Optional.of(member);
    }
}
