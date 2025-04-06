package com.jp.blog.member.controller;

import com.jp.blog.common.ResponseForm;
import com.jp.blog.member.domain.Member;
import com.jp.blog.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //created
    @PostMapping("createMember")
    public ResponseForm<Optional<Member>> createMember (@RequestBody Member member) {

        boolean jpaFlag = false;
        String jpaMessage = "";

        Optional<Member> mem = memberService.createdMember(member.getMemberName(), member.getMemberPwd());

        if(mem.isPresent()) {
            jpaFlag = true;
            jpaMessage = "Success";
        }else {
            jpaMessage = "Fail";
        }

        return new ResponseForm<>(jpaFlag, jpaMessage, mem);
    }

    //update
    @PostMapping("updateMember")
    public ResponseForm<Optional<Member>> updateMember (@RequestBody Member member) {

        boolean jpaFlag = false;
        String jpaMessage = "";

        Optional<Member> mem = memberService.updateMember(member.getMemberId(), member.getMemberName(), member.getMemberPwd());

        if(mem.isPresent()) {
            jpaFlag = true;
            jpaMessage = "Success";
        }else {
            jpaMessage = "Fail";
        }

        return new ResponseForm<>(jpaFlag, jpaMessage, mem);
    }

    //delete
    @PostMapping("deleteMember")
    public ResponseForm<Optional<Member>> deleteMember (@RequestBody Member member) {

        boolean jpaFlag = false;
        String jpaMessage = "";

        Optional<Member> mem = memberService.deletedMember (member.getMemberId());

        if(mem.isPresent()) {
            jpaFlag = true;
            jpaMessage = "Success";
        }else {
            jpaMessage = "Fail";
        }

        return new ResponseForm<> (jpaFlag, jpaMessage, mem);
    }

    //select
    @PostMapping("readMember")
    public ResponseForm<Optional<Member>> readMember (@RequestBody Member member) {

        boolean jpaFlag = false;
        String jpaMessage = "";

        Optional<Member> mem = memberService.readMember (member.getMemberName(), member.getMemberPwd());

        if(mem.isPresent()) {
            jpaFlag = true;
            jpaMessage = "Success";
        }else {
            jpaMessage = "Fail";
        }

       return new ResponseForm<> (jpaFlag, jpaMessage, mem);
    }
}
