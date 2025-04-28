package com.practice.designpatterns.behavioral.observer;

public class ObserverPatternMain {

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.eventManager.subscribe("open", new LogOpenListener("/home/teja/Digitaldots/logs/curl.log"));
        editor.eventManager.subscribe("open", new LogOpenListener("/home/teja/Digitaldots/logs/rough.log"));
        editor.eventManager.subscribe("save", new EmailNotificationListener("saitejasangoju@gmail.com"));
        
        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
