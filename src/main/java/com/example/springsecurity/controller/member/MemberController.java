package com.example.springsecurity.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/login")
    public String memberLogin() {
        return "member/login";
    }

    @GetMapping("/register")
    public String memberRegister() {
        return "member/register";
    }
}
