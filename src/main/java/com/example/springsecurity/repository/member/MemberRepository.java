package com.example.springsecurity.repository.member;

import com.example.springsecurity.domain.common.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByMemberIdAndPassword(String memberId, String password);
}

