package com.practice.designpatterns.creational.abstractfactory;

public class MailNotificationFactory implements NotificationFactory {

    @Override
    public Notification createNotification() {
        return new GmailNotification();
    }

}
