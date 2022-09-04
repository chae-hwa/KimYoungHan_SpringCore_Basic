package com.example.springboot2;

import com.example.springboot2.member.Grade;
import com.example.springboot2.member.Member;
import com.example.springboot2.member.MemberService;
import com.example.springboot2.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
