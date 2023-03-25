package com.example.springsecurity.vo;

import com.example.springsecurity.domain.common.Member;
import lombok.*;
import net.bytebuddy.asm.Advice;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
public class MemberVO implements UserDetails {
    private String memberId;
    private String password;
    private String memberAuth;
    private LocalDateTime registDate;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection <GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(()-> this.memberAuth);
        return collectors;
    }
    @Override
    public String getUsername() {
        return this.memberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //true 만료안됨
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; //true 계정 잠기지 않음
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //true 비밀번호 만료 안됨
    }

    @Override
    public boolean isEnabled() {
        return true; //계정 활성화 여부
    }
}
