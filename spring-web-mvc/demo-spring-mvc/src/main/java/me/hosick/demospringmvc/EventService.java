package me.hosick.demospringmvc;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents() {
        Event event1 = Event.builder()
                .name("스프링 웹 MVC 스터디 1차")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2020, 12, 25, 0, 0))
                .endDateTime(LocalDateTime.of(2021, 1, 1, 0, 0))
                .build();

        Event event2 = Event.builder()
                .name("스프링 웹 MVC 스터디 2차")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2021, 1, 1, 0, 0))
                .endDateTime(LocalDateTime.of(2021, 1, 7, 0, 0))
                .build();

        return List.of(event1, event2);
    }

}