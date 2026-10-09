package com.harsh.sadp.worker;

public class RobotWorker implements Workable, Payable {

    @Override
    public void work() {
        System.out.println("Robot is working.");
    }

    @Override
    public void get_paid() {
        System.out.println("Robot receives payment.");
    }
}