package com.example.springsecurity.controller.member;

import com.example.springsecurity.service.member.MemberDetailsService;
import com.example.springsecurity.service.member.MemberService;
import com.example.springsecurity.vo.MemberVO;
import com.example.springsecurity.vo.member.MemberLoginVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;
    private final MemberDetailsService memberDetailsService;

    @GetMapping(value = "test")
    public String test() {
        return "test";
    }

    @PostMapping(value="register")
    public String memberRegister(@RequestBody MemberVO memberVO) {
        return memberService.registerMember(memberVO);
    }

//    @PostMapping(value = "login")
//    public MemberVO memberLogin(@RequestBody MemberLoginVO loginVO) {
//        return memberDetailsService.loadUserByUsername(loginVO.getMemberId());
//    }
}
