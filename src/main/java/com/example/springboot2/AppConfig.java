package com.example.springboot2;

import com.example.springboot2.discount.DiscountPolicy;
import com.example.springboot2.discount.FixDiscountPolicy;
import com.example.springboot2.member.MemberRepository;
import com.example.springboot2.member.MemberService;
import com.example.springboot2.member.MemberServiceImpl;
import com.example.springboot2.member.MemoryMemberRepository;
import com.example.springboot2.order.OrderService;
import com.example.springboot2.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
