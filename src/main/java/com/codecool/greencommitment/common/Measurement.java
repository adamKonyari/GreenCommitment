package com.codecool.greencommitment.common;

public class Measurement {

    private int id;
    private int value;
    private String type;
    private long time;

    public Measurement(int id, int value, String type, long time) {
        this.id = id;
        this.value = value;
        this.type = "Celsius";
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public long getTime() {
        return time;
    }
}

