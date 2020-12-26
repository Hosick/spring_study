package me.hosick.demospring51.applicationeventpublisher;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler /*implements ApplicationListener<MyEvent>*/ {

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE - 2)
    //@Async 비동기적으로 실행
    public void handle(MyEvent event) {
        System.out.println("    " + Thread.currentThread().toString());
        System.out.println("    이벤트 받았다. 데이터는 " + event.getData());
    }

    @EventListener
    //@Async
    public void handle(ContextRefreshedEvent event) {
        System.out.println("    " + Thread.currentThread().toString());
        System.out.println("    ContextRefreshedEvent");
    }

    @EventListener
    //@Async
    public void handle(ContextClosedEvent event) {
        System.out.println("    " + Thread.currentThread().toString());
        System.out.println("    ContextClosedEvent");
    }
}
