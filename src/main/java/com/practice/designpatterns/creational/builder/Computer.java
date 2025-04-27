package com.practice.designpatterns.creational.builder;

public class Computer {

    private String brand;
    private String hdd;
    private String ram;
    private String processor;

    public Computer(ComputerBuilder builder) {
        this.brand = builder.getBrand();
        this.hdd = builder.getHdd();
        this.ram = builder.getRam();
        this.processor = builder.getProcessor();
    }

    public void display() {
        System.out.println("{\n\t\"brand\" : \"" + brand + "\",\n\t\"processor\" : \"" + processor + "\",\n\t\"hdd\" : \"" + hdd
            + "\",\n\t\"ram\" : \"" + ram + "\"\n}");
    }

}
