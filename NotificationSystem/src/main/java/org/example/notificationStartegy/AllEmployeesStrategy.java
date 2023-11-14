package org.example.notificationStartegy;

import org.example.observer.Employee;

import java.util.List;

public class AllEmployeesStrategy implements NotificationStrategy{
    @Override
    public List<Employee> getRecipients(Employee author, List<Employee> allEmployees) {
        return allEmployees;
    }
}
