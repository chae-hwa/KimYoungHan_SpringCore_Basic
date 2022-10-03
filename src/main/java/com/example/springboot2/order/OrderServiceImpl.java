package com.example.springboot2.order;

import com.example.springboot2.discount.DiscountPolicy;
import com.example.springboot2.member.Member;
import com.example.springboot2.member.MemberRepository;
import com.example.springboot2.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements  OrderService {

    // final을 붙이면 생성자주입에서 값이 사용되어야 한다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 생성자 주입 (DI 주입) @RequiredArgsConstructor가 자동으로 만들어줌.
    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository; // final을 붙일 때 필수 사용
        this.discountPolicy = discountPolicy; // final을 붙일 때 필수 사용
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
