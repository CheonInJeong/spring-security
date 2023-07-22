package com.example.springsecurity.service.member;

import com.example.springsecurity.domain.common.Member;
import com.example.springsecurity.repository.member.MemberRepository;
import com.example.springsecurity.vo.member.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberDetailsService memberDetailsService;
    private final PasswordEncoder passwordEncoder;

    public String registerMember(MemberVO memberVO) {


        String encodedPassword = passwordEncoder.encode(memberVO.getPassword());

        Member member = Member.builder()
                .memberId(memberVO.getMemberId())
                .memberAuth(memberVO.getMemberAuth())
                .password(encodedPassword)
                .registDate(LocalDateTime.now())
                .build();
        memberRepository.save(member);

        return member.getMemberId();
    }
    private MemberVO login(MemberVO memberVO) {
        return memberDetailsService.loadUserByUsername(memberVO.getMemberId());
    }
}
