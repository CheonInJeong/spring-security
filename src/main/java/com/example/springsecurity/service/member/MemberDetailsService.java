package com.example.springsecurity.service.member;

import com.example.springsecurity.domain.common.Member;
import com.example.springsecurity.repository.member.MemberRepository;
import com.example.springsecurity.vo.MemberVO;
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
        Member member = memberRepository.findById(memberId).get();
        return memberRepository.findById(memberId).map(m->
                MemberVO.builder()
                        .memberId(m.getMemberId())
                        .password(m.getPassword())

                        .memberAuth(m.getMemberAuth())
                        .registDate(m.getRegistDate()).build()

        ).get();
    }
}



/*
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new UsernameNotFoundException("User not authorized...");
        }

        UserDetailVO userDto = new UserDetailVO();
        userDto.setUserId(user.getUserId());
        userDto.setUserPw(user.getUserPw());
        userDto.setUserAuth(user.getUserAuth());
        userDto.setUserName(user.getUserName());


        log.info("UserDTO = {}", userDto);
        return userDto;
    }
 */