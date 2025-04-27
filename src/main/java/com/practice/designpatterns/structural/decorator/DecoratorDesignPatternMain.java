package com.practice.designpatterns.structural.decorator;

public class DecoratorDesignPatternMain {

    public static void main(String[] args) {
        Car baseCar = new BaseCar();
        System.out.println("Base car onroad: " + baseCar.onroad());

        Car carWithDoubleSpeakersAndRearAC = new RearAc(new DoubleSpeakers(baseCar));
        System.out.println("Base car with Double Speakers onroad: " + carWithDoubleSpeakersAndRearAC.onroad());
    }

}
