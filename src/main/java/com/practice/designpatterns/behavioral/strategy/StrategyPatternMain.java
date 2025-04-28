package com.practice.designpatterns.behavioral.strategy;

public class StrategyPatternMain {
    
    // Strategy Design Pattern suggests that one strategy can be executed in multiple ways
    // Like a Class does something specific in a lot of ways.
    // Here we have a Strategy which performs operation on a, b.
    // We can have any number of ways to perform this operation like Addition, Subtraction, Multiplication, etc,.
    
    
    public static void main(String[] args) {
        double a = 10;
        double b = 8;    
        Strategy concreteStrategyAddition = new ConcreteStrategyAddition();
        StrategyExecutor additionExecutor = new StrategyExecutor(concreteStrategyAddition);
        System.out.println("After adding " + a + ", " + b + " = " + additionExecutor.executeStrategy(a, b));
        
        Strategy concreteStrategyMultiplication = new ConcreteStrategyMultiplication();
        StrategyExecutor multiplicationExecutor = new StrategyExecutor(concreteStrategyMultiplication);
        System.out.println("After multiplying " + a + ", " + b + " = " + multiplicationExecutor.executeStrategy(a, b));
        
        Strategy concreteStrategySubtraction = new ConcreteStrategySubtraction();
        StrategyExecutor subtractionExecutor = new StrategyExecutor(concreteStrategySubtraction);
        System.out.println("After subtracting " + a + ", " + b + " = " + subtractionExecutor.executeStrategy(a, b));
    }

}
