package com.practice.designpatterns.creational.abstractfactory;

public class AbstractFactoryDesignPatternMain {

    public static void main(String[] args) {
        String sendVia = "SocialMedia";
        NotificationFactory notificationFactory = null;
        if("Mail".equals(sendVia)) {
            notificationFactory = new MailNotificationFactory();
        } else if("SocialMedia".equals(sendVia)) {
            notificationFactory = new SocialMediaNotificationFactory();
        }
        Application abstractFactory = new Application(notificationFactory);
        abstractFactory.sendMail();
    }

}
