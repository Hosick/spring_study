package me.hosick.demospring51;

import org.springframework.stereotype.Service;


@Service
public class SimpleEventService implements EventService {
    @PerfLogging
    @Override
    public void createEvent() {
        // long begin = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Created on event");

        // System.out.println(System.currentTimeMillis() - begin);
    }

    @PerfLogging
    @Override
    public void publishEvent() {
        // long begin = System.currentTimeMillis();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("published on Event");

        // System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void deleteEvent(){
        System.out.println("Deleted on Event");
    }
}
