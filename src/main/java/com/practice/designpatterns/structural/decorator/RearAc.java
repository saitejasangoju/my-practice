package com.practice.designpatterns.structural.decorator;

public class RearAc implements Car {

    private Car baseCar;
    
    public RearAc(Car baseCar) {
        this.baseCar = baseCar;
    }
    
    @Override
    public double onroad() {
        return baseCar.onroad() + 90000.0;
    }

}
