package com.practice.designpatterns.creational.abstractfactory;

public class Application {

    Notification notification;

    public Application(NotificationFactory notificationFactory) {
        notification = notificationFactory.createNotification();
    }

    void sendMail() {
        notification.sendMail();
    }
}
