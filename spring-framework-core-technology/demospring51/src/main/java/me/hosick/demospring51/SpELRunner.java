package me.hosick.demospring51;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpELRunner implements ApplicationRunner {

    @Value("#{1 + 1}")
    int value;

    @Value("#{'hello' + 'world'}")
    String greeting;

    @Value("#{1 eq 1}")
    boolean trueOrFalse;

    @Value("#{'hello'}")
    String hello;

    @Value("${my.value}") // 프로퍼티
    int myValue;

    @Value("#{${my.value} eq 100}") // 표현식 안에 프로퍼티를 넣을 수 있음
    boolean isMyValue100;

    @Value("#{ELSample.data}")
    int sampleData;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(value);
        System.out.println(greeting);
        System.out.println(trueOrFalse);
        System.out.println(hello);
        System.out.println(myValue);
        System.out.println(isMyValue100);
        System.out.println(sampleData);
        System.out.println("--------------------");
    }
}
