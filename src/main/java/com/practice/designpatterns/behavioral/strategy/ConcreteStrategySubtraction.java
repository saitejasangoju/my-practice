package com.practice.designpatterns.behavioral.strategy;

public class ConcreteStrategySubtraction implements Strategy {

    @Override
    public double execute(double a, double b) {
        return a - b;
    }

}
