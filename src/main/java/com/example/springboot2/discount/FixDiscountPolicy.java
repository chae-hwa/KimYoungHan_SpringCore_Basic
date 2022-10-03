package com.example.springboot2.discount;

import com.example.springboot2.member.Grade;
import com.example.springboot2.member.Member;
import org.springframework.stereotype.Component;

@Component // 스프링빈에 등록되어서 RateDiscountPolicy와 충돌
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인

   @Override
    public int discount(Member member, int price) {
       if(member.getGrade() == (Grade.VIP)){
           return discountFixAmount;
       } else {
           return 0;
       }
    }
}
