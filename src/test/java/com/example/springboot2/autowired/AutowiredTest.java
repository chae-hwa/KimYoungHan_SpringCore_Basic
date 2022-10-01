package com.example.springboot2.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.lang.reflect.Member;
import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class); //TestBean 빈 등록
    }

    static class TestBean{

        // 출력 결과 : 호출 자체가 안 됨.
        @Autowired(required = false) // 의존 관계가 없으면 메서드 자체가 호출되지 않는다.
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        // 출력 결과 : noBean2 = null
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){ // 호출은 되되, null로 들어온다.
            System.out.println("noBean2 = " + noBean2);
        }

        // 출력 결과 : noBean3 = Optional.empty
        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
