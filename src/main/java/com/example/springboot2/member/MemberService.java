package com.example.springboot2.member;

public interface MemberService {

    void join(Member member);

    void findMember(Long memberId);
}
