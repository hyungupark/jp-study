package com.jp.blog.member.controller;

import com.jp.blog.common.ResponseForm;
import com.jp.blog.member.domain.Member;
import com.jp.blog.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    /// Create
    @PostMapping()
    public ResponseForm<Optional<Member>> createMember(@RequestBody Member member) {
        boolean jpaFlag = false;
        String jpaMessage = "";

        Optional<Member> mem = memberService.createdMember(member.getUsername(), member.getPassword());

        if (mem.isPresent()) {
            jpaFlag = true;
            jpaMessage = "Success";
        } else {
            jpaMessage = "Fail";
        }

        return new ResponseForm<>(jpaFlag, jpaMessage, mem);
    }

    /// Read
    @PostMapping("/login")
    public ResponseForm<Optional<Member>> login(@RequestBody Member member) {
        boolean jpaFlag = false;
        String jpaMessage = "";

        Optional<Member> mem = memberService.readMember(member.getUsername(), member.getPassword());

        if (mem.isPresent()) {
            jpaFlag = true;
            jpaMessage = "Success";
        } else {
            jpaMessage = "Fail";
        }

        return new ResponseForm<>(jpaFlag, jpaMessage, mem);
    }

    /// Update
    @PutMapping()
    public ResponseForm<Optional<Member>> updateMember(@RequestBody Member member) {
        boolean jpaFlag = false;
        String jpaMessage = "";

        Optional<Member> mem = memberService.updateMember(member.getId(), member.getUsername(), member.getPassword());

        if (mem.isPresent()) {
            jpaFlag = true;
            jpaMessage = "Success";
        } else {
            jpaMessage = "Fail";
        }

        return new ResponseForm<>(jpaFlag, jpaMessage, mem);
    }

    /// Delete
    @DeleteMapping()
    public ResponseForm<Optional<Member>> deleteMember(@RequestBody Member member) {
        boolean jpaFlag = false;
        String jpaMessage = "";

        Optional<Member> mem = memberService.deletedMember(member.getId());

        if (mem.isPresent()) {
            jpaFlag = true;
            jpaMessage = "Success";
        } else {
            jpaMessage = "Fail";
        }

        return new ResponseForm<>(jpaFlag, jpaMessage, mem);
    }
}
