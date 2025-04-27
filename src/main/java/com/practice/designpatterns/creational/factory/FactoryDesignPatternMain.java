package com.practice.designpatterns.creational.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FactoryDesignPatternMain {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(FactoryDesignPatternMain.class, args);
        test();
    }

    private static void test() throws Exception {
        Logistic sea = LogisticsFactory.getFactory("Sea");
        sea.display();
        Logistic road = LogisticsFactory.getFactory("Road");
        road.display();
    }

}
