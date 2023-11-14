package org.example.notificationStartegy;

import org.example.observer.Employee;

import java.util.List;

public interface NotificationStrategy {
    List<Employee> getRecipients(Employee author, List<Employee> allEmployees);
}
