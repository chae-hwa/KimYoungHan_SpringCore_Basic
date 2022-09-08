package com.example.springboot2;

import com.example.springboot2.discount.FixDiscountPolicy;
import com.example.springboot2.member.MemberService;
import com.example.springboot2.member.MemberServiceImpl;
import com.example.springboot2.member.MemoryMemberRepository;
import com.example.springboot2.order.OrderService;
import com.example.springboot2.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
