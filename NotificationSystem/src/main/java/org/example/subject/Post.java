package org.example.subject;

import org.example.notificationStartegy.AllEmployeesStrategy;
import org.example.notificationStartegy.NotificationStrategy;
import org.example.observer.Employee;
import org.example.observer.EmployeeObserver;

import java.util.ArrayList;
import java.util.List;

public class Post implements PostSubject {
    private List<Employee> observers = new ArrayList<>();
    private String content;
    private Employee author;

    private NotificationStrategy notificationStrategy;

    public Post(String content, Employee author) {
        this.content = content;
        this.author = author;
        notificationStrategy = new AllEmployeesStrategy();
    }

    @Override
    public void addObserver(Employee observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Employee observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Post post) {
        List<Employee> recipients = notificationStrategy.getRecipients(author, observers);
        for (EmployeeObserver observer : recipients) {
            observer.update(post);
        }
    }

    public String getContent() {
        return content;
    }

    public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    // Other methods for the post...
}
