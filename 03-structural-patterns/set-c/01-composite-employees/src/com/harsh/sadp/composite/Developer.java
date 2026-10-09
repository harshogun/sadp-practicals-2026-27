
package com.harsh.sadp.composite;

public class Developer implements Employee {

    private final String name;
    private final String role;
    private final double salary;

    public Developer(String name, String role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    @Override
    public void showDetails() {
        System.out.println(
                "Employee: " + name
                        + " | Role: " + role
                        + " | Salary: Rs. " + salary
        );
    }
}
