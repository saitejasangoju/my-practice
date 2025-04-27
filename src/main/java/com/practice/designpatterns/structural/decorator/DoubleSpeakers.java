package com.practice.designpatterns.structural.decorator;

public class DoubleSpeakers implements Car {
    
    private Car baseCar;
    
    public DoubleSpeakers(Car baseCar) {
        this.baseCar = baseCar;
    }

    @Override
    public double onroad() {
        return baseCar.onroad() + 40000.0;
    }

}
