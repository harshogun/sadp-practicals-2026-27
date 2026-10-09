
package com.harsh.sadp.fan;

public class CeilingFan {

    public static final int OFF = 0;
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int HIGH = 3;

    private int speed = OFF;

    public void on() {
        System.out.println("Ceiling fan is ON.");
    }

    public void off() {
        speed = OFF;
        System.out.println("Ceiling fan is OFF.");
    }

    public void setSpeed(int speed) {
        this.speed = speed;

        String[] speeds = {"OFF", "LOW", "MEDIUM", "HIGH"};

        System.out.println("Fan speed: " + speeds[speed]);
    }

    public int getSpeed() {
        return speed;
    }
}
