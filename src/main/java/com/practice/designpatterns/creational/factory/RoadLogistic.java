package com.practice.designpatterns.creational.factory;

import org.springframework.stereotype.Component;

@Component
public class RoadLogistic implements Logistic {

    
    public String getType() {
        return "Road";
    }
    
    public void display() {
        System.out.println("I'm working in RoadLogistics");
    }

}
