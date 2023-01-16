package com.everyday_coding.member.controller;

import com.everyday_coding.member.dto.MemberCreation;
import com.everyday_coding.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public MemberCreation.ResponseDto memberJoin(
            @RequestBody MemberCreation.RequestDto requestDto) {
        MemberCreation.ResponseDto responseDto = memberService.createMember(requestDto);
        return responseDto;
    }

}
