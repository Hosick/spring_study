package me.hosick.demospring51.aop;

import java.lang.annotation.*;


/*
* 이 어노테이션을 사용하면 성능을 로깅해줍니다.
* */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)   //  애노테이션 정보를 얼마나 유지할 것인가? (기본값이 CLASS임)
public @interface PerfLogging {
}