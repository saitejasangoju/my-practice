package com.practice.designpatterns.creational.builder;

public class BuilderPatternMain {

    public static void main(String[] args) {
        Computer lenovo = ComputerBuilder.builder().brand("lenovo").processor("i3").hdd("512").ram("8gb").build();
        lenovo.display();
        
        Computer dell = ComputerBuilder.builder().brand("dell").processor("i3").ram("8gb").build();
        dell.display();
        
        Computer empty = ComputerBuilder.builder().build();
        empty.display();
    }
}
