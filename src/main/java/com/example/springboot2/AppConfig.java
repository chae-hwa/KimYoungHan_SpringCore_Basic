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

    // @Bean memberService → new MemoryMemberRepository()
    // @Bean OrderService → new MemoryMemberRepository()
    // → 싱글톤이 깨지는 거 아닌가?

    /*예상
    call AppConfig.memberService
    call AppConfig.memberRepository
    call AppConfig.memberRepository
    call AppConfig.orderService
    call AppConfig.memberRepository
    */

    /*실제 출력
    call AppConfig.memberService
    call AppConfig.memberRepository
    call AppConfig.orderService
    */
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
