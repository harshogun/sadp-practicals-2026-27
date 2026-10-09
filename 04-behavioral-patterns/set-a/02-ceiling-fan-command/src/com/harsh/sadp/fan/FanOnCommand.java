
package com.harsh.sadp.fan;

public class FanOnCommand implements Command {

    private final CeilingFan fan;

    public FanOnCommand(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.off();
    }
}
