package me.hosick.demospring51;

import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler {

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE)
    //@Async
    public void onApplicationEvent(MyEvent event) {
        System.out.println("이벤트 받았다. 데이타는 " + event.getData());
        System.out.println("--------------------");
    }
}
