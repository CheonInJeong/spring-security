package com.example.springsecurity;

import com.example.springsecurity.domain.common.Member;
import com.example.springsecurity.repository.member.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringSecurityApplicationTests {
    @Autowired
    MemberRepository memberRepository;
    @Test
    void exist() {
        List<Member> list = memberRepository.findAll();
        Assertions.assertEquals(7, memberRepository.count());
        Assertions.assertEquals(memberRepository.existsById("1"), false);
    }
}
