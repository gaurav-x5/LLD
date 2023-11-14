package org.example.subject;

import org.example.observer.Employee;
import org.example.observer.EmployeeObserver;

public interface PostSubject {
    void addObserver(Employee observer);
    void removeObserver(Employee observer);
    void notifyObservers(Post post);
}
