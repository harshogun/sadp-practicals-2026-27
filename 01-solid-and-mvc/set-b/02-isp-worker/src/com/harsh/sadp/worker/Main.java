package com.harsh.sadp.worker;

public class Main {

    public static void main(String[] args) {
        HumanWorker human = new HumanWorker();
        RobotWorker robot = new RobotWorker();

        System.out.println("--- Human Worker ---");
        human.work();
        human.eat();
        human.sleep();
        human.get_paid();

        System.out.println("\n--- Robot Worker ---");
        robot.work();
        robot.get_paid();
    }
}