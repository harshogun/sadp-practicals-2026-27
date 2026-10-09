
package com.harsh.sadp.loan;

public class Director extends LoanApprover {

    @Override
    public void approveLoan(double amount) {
        if (amount <= 100000) {
            System.out.println(
                    "Director approved loan of Rs. " + amount
            );
        } else {
            forwardRequest(amount);
        }
    }
}
