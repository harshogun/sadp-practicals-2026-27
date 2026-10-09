
package com.harsh.sadp.composite;

public class Main {

    public static void main(String[] args) {

        Developer dev1 = new Developer(
                "Amit", "Java Developer", 45000
        );

        Developer dev2 = new Developer(
                "Priya", "Frontend Developer", 42000
        );

        Developer dev3 = new Developer(
                "Rahul", "Backend Developer", 48000
        );

        Manager techLead = new Manager(
                "Sneha", "Technical Lead"
        );

        techLead.addEmployee(dev1);
        techLead.addEmployee(dev2);

        Manager engineeringManager = new Manager(
                "Rajesh", "Engineering Manager"
        );

        engineeringManager.addEmployee(techLead);
        engineeringManager.addEmployee(dev3);

        engineeringManager.showDetails();
    }
}
