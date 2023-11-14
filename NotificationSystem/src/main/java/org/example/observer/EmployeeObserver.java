package org.example.observer;

import org.example.subject.PostSubject;
import org.example.subject.Post;

public interface EmployeeObserver {
    void update(Post post);
}
