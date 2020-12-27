package me.hosick;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getName() {
        return "hosick";
    }
}