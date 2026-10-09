
package com.harsh.sadp.fan;

public class Main {

    public static void main(String[] args) {

        CeilingFan fan = new CeilingFan();

        Command lowSpeed =
                new FanSpeedCommand(fan, CeilingFan.LOW);

        Command highSpeed =
                new FanSpeedCommand(fan, CeilingFan.HIGH);

        Command off = new FanOffCommand(fan);

        System.out.println("Set fan to LOW:");
        lowSpeed.execute();

        System.out.println("\nSet fan to HIGH:");
        highSpeed.execute();

        System.out.println("\nUndo HIGH command:");
        highSpeed.undo();

        System.out.println("\nTurn fan OFF:");
        off.execute();

        System.out.println("\nUndo OFF command:");
        off.undo();
    }
}
