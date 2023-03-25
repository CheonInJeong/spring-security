package com.example.springsecurity.vo.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberLoginVO {
    private String memberId;
    private String password;
}
