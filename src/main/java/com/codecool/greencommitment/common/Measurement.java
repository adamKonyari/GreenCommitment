package com.codecool.greencommitment.common;

import java.io.Serializable;

public class Measurement implements Serializable {

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

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", value=" + value +
                ", type='" + type + '\'' +
                ", time=" + time +
                '}';
    }
}

