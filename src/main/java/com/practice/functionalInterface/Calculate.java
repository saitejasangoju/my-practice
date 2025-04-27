package com.practice.functionalInterface;

public class Calculate {
    
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        int addition = add.calculate(2, 3);
        System.out.println(addition);
        
        Calculator multiplication = (a, b) -> a * b;
        int multiply = multiplication.calculate(2, 20);
        System.out.println(multiply);
    }

}
