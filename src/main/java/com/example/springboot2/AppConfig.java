package com.example.springboot2;

import com.example.springboot2.discount.DiscountPolicy;
import com.example.springboot2.discount.RateDiscountPolicy;
import com.example.springboot2.member.MemberRepository;
import com.example.springboot2.member.MemberService;
import com.example.springboot2.member.MemberServiceImpl;
import com.example.springboot2.member.MemoryMemberRepository;
import com.example.springboot2.order.OrderService;
import com.example.springboot2.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
