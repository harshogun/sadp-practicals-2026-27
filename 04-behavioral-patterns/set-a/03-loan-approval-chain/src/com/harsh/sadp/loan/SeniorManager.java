
package com.harsh.sadp.loan;

public class SeniorManager extends LoanApprover {

    @Override
    public void approveLoan(double amount) {
        if (amount <= 10000) {
            System.out.println(
                    "Senior Manager approved loan of Rs. " + amount
            );
        } else {
            forwardRequest(amount);
        }
    }
}
