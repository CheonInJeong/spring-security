package com.example.springsecurity.controller;

import com.example.springsecurity.config.JwtUtils;
import com.example.springsecurity.dto.member.MemberLoginRequest;
import com.example.springsecurity.service.member.MemberDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final MemberDetailsService memberDetailsService;
    private final JwtUtils jwtUtils;

    @PostMapping("authenticate")
    public ResponseEntity<String> authenticate(@RequestBody MemberLoginRequest memberLoginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(memberLoginRequest.getMemberId(),
                memberLoginRequest.getPassword()));

        final UserDetails user = memberDetailsService.loadUserByUsername(memberLoginRequest.getMemberId());

        if(user != null) {
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        return ResponseEntity.status(400).body("Some error has occured");
    }
}
