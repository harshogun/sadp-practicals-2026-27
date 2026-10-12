
package com.harsh.sadp.gumball;

public class GumballMachine {

    private int gumballs;
    private boolean quarterInserted;

    public GumballMachine(int gumballs) {
        if (gumballs < 0) {
            throw new IllegalArgumentException(
                    "Gumball count cannot be negative."
            );
        }

        this.gumballs = gumballs;
        this.quarterInserted = false;
    }

    public void insertQuarter() {
        if (quarterInserted) {
            System.out.println("A quarter is already inserted.");
            return;
        }

        quarterInserted = true;
        System.out.println("Quarter inserted.");
    }

    public void removeQuarter() {
        if (!quarterInserted) {
            System.out.println("No quarter to remove.");
            return;
        }

        quarterInserted = false;
        System.out.println("Quarter returned.");
    }

    public void turnCrank() {
        if (!quarterInserted) {
            System.out.println("Insert a quarter first.");
            return;
        }

        if (gumballs == 0) {
            quarterInserted = false;
            System.out.println("Machine is empty. Quarter returned.");
            return;
        }

        quarterInserted = false;
        gumballs--;

        System.out.println("Crank turned.");
        dispenseGumball();
    }

    private void dispenseGumball() {
        System.out.println("Gumball dispensed!");
    }

    public void display() {
        System.out.println("Gumballs remaining: " + gumballs);
        System.out.println(
                "Quarter inserted: " + quarterInserted
        );
    }

    public MachineMemento saveState() {
        return new MachineMemento(gumballs, quarterInserted);
    }

    public void restoreState(MachineMemento memento) {
        if (memento == null) {
            throw new IllegalArgumentException(
                    "Memento cannot be null."
            );
        }

        gumballs = memento.getGumballs();
        quarterInserted = memento.hasQuarter();

        System.out.println("Machine state restored.");
    }
}
