
package com.harsh.sadp.loan;

public class Main {

    public static void main(String[] args) {

        LoanApprover manager = new Manager();
        LoanApprover seniorManager = new SeniorManager();
        LoanApprover director = new Director();

        manager.setNextApprover(seniorManager);
        seniorManager.setNextApprover(director);

        System.out.println("Loan Approval System\n");

        manager.approveLoan(1000);
        manager.approveLoan(10000);
        manager.approveLoan(100000);
        manager.approveLoan(150000);
    }
}
