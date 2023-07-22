package com.example.springsecurity.service.member;

import com.example.springsecurity.repository.member.MemberRepository;
import com.example.springsecurity.vo.member.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public MemberVO loadUserByUsername(String memberId) throws UsernameNotFoundException {
        return memberRepository.findById(memberId)
                .map(m->
                    MemberVO.builder()
                        .memberId(m.getMemberId())
                        .password(m.getPassword())
                        .memberAuth(m.getMemberAuth())
                        .registDate(m.getRegistDate()).build()
                 ).orElseThrow(()-> new UsernameNotFoundException("등록되지 않은 회원입니다."));
    }
}