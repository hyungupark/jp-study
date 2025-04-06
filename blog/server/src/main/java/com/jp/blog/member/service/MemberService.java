package com.jp.blog.member.service;

import com.jp.blog.member.dto.MemberDTO;
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

        MemberDTO mdto = new MemberDTO();
        mdto.setMemberName(memberName);
        mdto.setMemberPwd(memberPwd);
        mdto.setCreateAt(LocalDateTime.now());
        memberRepository.save(mdto);
    }

    public void deletedMember (
            UUID memberId
    ) {
        MemberDTO mdto = new MemberDTO();
        mdto.setMemberId(memberId);
        memberRepository.delete(mdto);
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
        MemberDTO mdto = new MemberDTO();
        mdto.setMemberId(memberId);
        mdto.setMemberPwd(memberPwd);

        memberRepository.save(mdto);

    }
}
