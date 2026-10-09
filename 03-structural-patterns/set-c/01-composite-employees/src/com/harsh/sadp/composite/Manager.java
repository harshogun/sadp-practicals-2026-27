
package com.harsh.sadp.composite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {

    private final String name;
    private final String role;
    private final List<Employee> team = new ArrayList<>();

    public Manager(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void addEmployee(Employee employee) {
        team.add(employee);
    }

    public void removeEmployee(Employee employee) {
        team.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println(
                "\nManager: " + name + " | Role: " + role
        );

        System.out.println("Team members:");

        for (Employee employee : team) {
            employee.showDetails();
        }
    }
}
