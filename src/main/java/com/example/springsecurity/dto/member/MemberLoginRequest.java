package com.example.springsecurity.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberLoginRequest {
    private String memberId;
    private String password;
}
