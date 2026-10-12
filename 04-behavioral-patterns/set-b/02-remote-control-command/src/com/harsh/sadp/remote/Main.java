
package com.harsh.sadp.remote;

public class Main {

    public static void main(String[] args) {

        Light livingRoomLight = new Light();

        Command lightOn =
                new LightOnCommand(livingRoomLight);

        Command lightOff =
                new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        System.out.println("Press ON button:");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println("\nPress OFF button:");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
