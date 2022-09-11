package com.example.springboot2.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatefulService {

//    private int price; // 상태를 유지하는 필드

    public int order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        return price; // 지역 변수로 수정
    }

//    public int getPrice(){
//        return price;
//    }
}
