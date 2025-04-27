package com.practice.designpatterns.creational.factory;

import org.springframework.stereotype.Component;

@Component
public class SeaLogistic implements Logistic {

    public String getType() {
        return "Sea";
    }
    
    public void display() {
        System.out.println("I'm working in SeaLogistics");
    }

}
