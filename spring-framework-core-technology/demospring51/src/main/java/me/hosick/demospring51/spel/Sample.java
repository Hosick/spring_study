package me.hosick.demospring51.spel;

import org.springframework.stereotype.Component;

@Component
public class Sample {

    private int data = 200;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}