
package com.harsh.sadp.gumball;

public final class MachineMemento {

    private final int gumballs;
    private final boolean quarterInserted;

    MachineMemento(int gumballs, boolean quarterInserted) {
        this.gumballs = gumballs;
        this.quarterInserted = quarterInserted;
    }

    int getGumballs() {
        return gumballs;
    }

    boolean hasQuarter() {
        return quarterInserted;
    }
}
