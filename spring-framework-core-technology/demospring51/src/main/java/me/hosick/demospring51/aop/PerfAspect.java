package me.hosick.demospring51.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    //@Around("execution(* me.hosick..*.EventService.*(..))")   //  execution을 이용
    //@Around("bean(simpleEventService)")   //  bean을 이용
    @Around("@annotation(PerfLogging)")     //  어노테이션을 이용
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {    //  pjp는 조인 포인트이다. (즉 메소드 자체)
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();  //  메소드 감싸기
        System.out.println("    " + (System.currentTimeMillis() - begin));

        return retVal;
    }

    @Before("bean(simpleEventService)")
    public void hello(){
        System.out.println("    Hello");
    }

}