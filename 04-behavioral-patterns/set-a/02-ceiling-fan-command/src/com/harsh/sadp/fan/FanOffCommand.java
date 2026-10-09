
package com.harsh.sadp.fan;

public class FanOffCommand implements Command {

    private final CeilingFan fan;
    private int previousSpeed;

    public FanOffCommand(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        previousSpeed = fan.getSpeed();
        fan.off();
    }

    @Override
    public void undo() {
        fan.setSpeed(previousSpeed);
    }
}
