
package com.harsh.sadp.fan;

public class FanSpeedCommand implements Command {

    private final CeilingFan fan;
    private final int newSpeed;
    private int previousSpeed;

    public FanSpeedCommand(CeilingFan fan, int newSpeed) {
        this.fan = fan;
        this.newSpeed = newSpeed;
    }

    @Override
    public void execute() {
        previousSpeed = fan.getSpeed();
        fan.setSpeed(newSpeed);
    }

    @Override
    public void undo() {
        fan.setSpeed(previousSpeed);
    }
}
