package com.example.springsecurity.domain.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Member {
    @Id
    @Column(name="MEMBER_ID")
    private String memberId;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "MEMBER_AUTH")
    private String memberAuth;
    @Column(name="REGIST_DATE")
    private LocalDateTime registDate;
}
