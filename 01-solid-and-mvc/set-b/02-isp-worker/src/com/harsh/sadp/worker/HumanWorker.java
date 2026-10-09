package com.harsh.sadp.worker;

public class HumanWorker
        implements Workable, Feedable, Restable, Payable {

    @Override
    public void work() {
        System.out.println("Human is working.");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Human is sleeping.");
    }

    @Override
    public void get_paid() {
        System.out.println("Human receives payment.");
    }
}