package org.example;


import org.example.notificationStartegy.AllEmployeesStrategy;
import org.example.observer.Employee;
import org.example.subject.Post;

public class Main {
    public static void main(String[] args) {
        Employee ceo = new Employee("CEO", "CEO");
        Employee manager = new Employee("Manager", "Manager");
        Employee individualContributor = new Employee("Individual Contributor", "Individual Contributor");

        Post post = new Post("Hello, organization!", ceo);

        post.setNotificationStrategy(new AllEmployeesStrategy());

        post.addObserver(manager);
        post.addObserver(individualContributor);

        post.notifyObservers(post);

        // Employee goes on sabbatical and opts out of notifications
        individualContributor.optOutNotifications();

        // Another post by CEO
        Post anotherPost = new Post("Important announcement!", manager);
        anotherPost.addObserver(manager);
        anotherPost.addObserver(individualContributor);

        anotherPost.notifyObservers(anotherPost);

        // Employee returns from sabbatical and opts back in for notifications
        individualContributor.optInNotifications();

        // Yet another post by CEO
        Post yetAnotherPost = new Post("Exciting news!", ceo);
        yetAnotherPost.addObserver(manager);
        yetAnotherPost.addObserver(individualContributor);

        yetAnotherPost.notifyObservers(yetAnotherPost);
    }
}