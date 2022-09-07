package com.example.springboot2.discount;

import com.example.springboot2.member.Member;

public interface DiscountPolicy {

    // 할인 대상 금액
    int discount(Member member, int price);
}
