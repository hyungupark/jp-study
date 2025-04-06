package com.jp.blog.member.controller;

import com.jp.blog.member.domain.Member;
import com.jp.blog.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //created
    @PostMapping("createMember")
    public void createMember (@RequestBody Member member) {

        memberService.createdMember(member.getMemberName(), member.getMemberPwd());
    }

    //update
    @PostMapping("updateMember")
    public void updateMember (@RequestBody Member member) {

        memberService.updateMember(member.getMemberId(), member.getMemberPwd());
    }

    //delete
    @PostMapping("deleteMember")
    public void deleteMember (@RequestBody Member member) {

        memberService.deletedMember (member.getMemberId());
    }

    //select
    @PostMapping("readMember")
    public void readMember (@RequestBody Member member) {

        memberService.readMember (member.getMemberName(), member.getMemberPwd());
    }

}
