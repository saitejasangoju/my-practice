package com.practice.designpatterns.behavioral.strategy;

public class StrategyExecutor {

    private Strategy strategy;
    
    public StrategyExecutor(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public double executeStrategy(double a, double b) {
        return strategy.execute(a, b);
    }

}
