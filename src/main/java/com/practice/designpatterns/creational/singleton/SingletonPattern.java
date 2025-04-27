package com.practice.designpatterns.creational.singleton;

public class SingletonPattern {

    private static SingletonPattern instance;

    private SingletonPattern() {
    }

    public static SingletonPattern getInstance() {
        if (instance == null) {
            synchronized (SingletonPattern.class) {
                if (instance == null) {
                    instance = new SingletonPattern();
                }
            }
        }
        return instance;
    }
}
