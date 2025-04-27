package com.practice.designpatterns.creational.abstractfactory;

public class WhatsAppNotification implements Notification {

    public void sendMail() {
        System.out.println("WhatsApp Notification sent");
    }
}

