package com.practice.designpatterns.creational.builder;

public class ComputerBuilder {
    
    private String brand;
    private String hdd;
    private String ram;
    private String processor;
    
    public String getBrand() {
        return brand;
    }

    public String getHdd() {
        return hdd;
    }

    public String getRam() {
        return ram;
    }

    public String getProcessor() {
        return processor;
    }

    public ComputerBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }
    
    public ComputerBuilder hdd(String hdd) {
        this.hdd = hdd;
        return this;
    }
    
    public ComputerBuilder ram(String ram) {
        this.ram = ram;
        return this;
    }
    
    public ComputerBuilder processor(String processor) {
        this.processor = processor;
        return this;
    }
    
    public static ComputerBuilder builder() {
        return new ComputerBuilder();
    }
    
    public Computer build() {
        return new Computer(this);
    }

}
