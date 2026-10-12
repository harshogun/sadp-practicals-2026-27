
package com.harsh.sadp.remote;

public class RemoteControl {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command == null) {
            System.out.println("No command assigned.");
            return;
        }

        command.execute();
    }
}
