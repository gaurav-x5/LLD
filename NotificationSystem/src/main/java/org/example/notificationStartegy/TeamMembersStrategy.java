package org.example.notificationStartegy;

import org.example.observer.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class TeamMembersStrategy implements NotificationStrategy{
    @Override
    public List<Employee> getRecipients(Employee author, List<Employee> allEmployees) {
        String teamDesignation = author.getDesignation();
        return allEmployees.stream()
                .filter(employee -> employee.getDesignation().equals(teamDesignation))
                .collect(Collectors.toList());
    }
}
