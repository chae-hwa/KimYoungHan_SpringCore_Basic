package com.example.springboot2.order;

import com.example.springboot2.discount.DiscountPolicy;
import com.example.springboot2.member.Member;
import com.example.springboot2.member.MemberRepository;
import com.example.springboot2.member.MemoryMemberRepository;

public class OrderServiceImpl implements  OrderService {

    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    // 생성자 주입 (DI 주입)
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
