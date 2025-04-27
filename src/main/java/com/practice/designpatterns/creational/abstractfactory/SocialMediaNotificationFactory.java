package com.practice.designpatterns.creational.abstractfactory;

public class SocialMediaNotificationFactory implements NotificationFactory {

    @Override
    public Notification createNotification() {
        return new WhatsAppNotification();
    }

}
