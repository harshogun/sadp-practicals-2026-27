
package com.harsh.sadp.loan;

public class Manager extends LoanApprover {

    @Override
    public void approveLoan(double amount) {
        if (amount <= 1000) {
            System.out.println(
                    "Manager approved loan of Rs. " + amount
            );
        } else {
            forwardRequest(amount);
        }
    }
}
