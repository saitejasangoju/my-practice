package com.practice.designpatterns.creational.abstractfactory;

public class GmailNotification implements Notification {

    public void sendMail() {
        System.out.println("Gmail Notification sent");
    }
}
