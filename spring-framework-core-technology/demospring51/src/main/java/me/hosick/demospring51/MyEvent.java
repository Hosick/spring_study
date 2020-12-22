package me.hosick.demospring51;

public class MyEvent {

    private int data;

    private Object source;

    public MyEvent(Object source, int data) {
        this.source = source;
        this.data = data;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public int getData() {
        return data;
    }
}