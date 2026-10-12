
package com.harsh.sadp.gumball;

public class Main {

    public static void main(String[] args) {

        GumballMachine machine = new GumballMachine(5);

        System.out.println("Initial state:");
        machine.display();

        System.out.println("\nInsert a quarter:");
        machine.insertQuarter();

        System.out.println("\nSave machine state:");
        MachineMemento savedState = machine.saveState();

        System.out.println("\nTurn the crank:");
        machine.turnCrank();
        machine.display();

        System.out.println("\nRestore saved state:");
        machine.restoreState(savedState);
        machine.display();

        System.out.println("\nRemove quarter:");
        machine.removeQuarter();
        machine.display();
    }
}
