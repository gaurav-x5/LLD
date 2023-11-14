package org.example.observer;

import org.example.subject.Post;

public class Employee implements EmployeeObserver {
    private String name;
    private String designation;
    private boolean receiveNotifications = true;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    @Override
    public void update(Post post) {
        if (receiveNotifications) {
            System.out.println("Received notification: " + post.getContent());
        } else {
            System.out.println("Opted out of notifications during sabbatical.");
        }
    }

    public void optOutNotifications() {
        receiveNotifications = false;
    }

    public void optInNotifications() {
        receiveNotifications = true;
    }

    public String getDesignation() {
        return designation;
    }

    // Other methods for the employee...
}