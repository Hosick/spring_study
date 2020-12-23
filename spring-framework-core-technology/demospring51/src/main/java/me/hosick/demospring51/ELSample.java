package me.hosick.demospring51;

import org.springframework.stereotype.Component;

@Component
public class ELSample {
    private int data = 200;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
