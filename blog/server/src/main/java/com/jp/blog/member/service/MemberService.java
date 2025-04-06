package com.jp.blog.member.service;

import com.jp.blog.member.domain.Member;
import com.jp.blog.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void createdMember (
            String memberName,
            String memberPwd) {

        Member member = new Member();
        member.setMemberName(memberName);
        member.setMemberPwd(memberPwd);
        member.setCreatedAt(LocalDateTime.now());
        memberRepository.save(member);
    }

    public void deletedMember (
            UUID memberId
    ) {
        Member member = new Member();
        member.setMemberId(memberId);
        memberRepository.delete(member);
    }

    public void readMember (
            String memberName,
            String memberPwd
    ) {
        memberRepository.findByUsernameAndPassword(memberName, memberPwd);
    }

    public void updateMember (
            UUID memberId,
            String memberPwd
    ) {
        Member member = new Member();
        member.setMemberId(memberId);
        member.setMemberPwd(memberPwd);

        memberRepository.save(member);

    }
}
