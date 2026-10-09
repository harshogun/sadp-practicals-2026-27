package com.harsh.sadp.loan;

public abstract class LoanApprover {

    protected LoanApprover nextApprover;

    public void setNextApprover(LoanApprover approver) {
        this.nextApprover = approver;
    }

    public abstract void approveLoan(double amount);

    protected void forwardRequest(double amount) {
        if (nextApprover != null) {
            nextApprover.approveLoan(amount);
        } else {
            System.out.println(
                    "Loan amount Rs. " + amount
                            + " exceeds approval limits. Loan rejected."
            );
        }
    }
}
