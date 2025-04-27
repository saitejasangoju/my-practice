package com.practice.interfaces;

public class VehicleTest { // can extend utmost one class because multiple inheritance doesn't support java

    public static void main(String[] args) {
        Vehicle bus = new Bus();
        bus.drive();

        Vehicle car = new Car();
        car.drive();

        // Creating instance of Vehicle using an anonymous class
        Vehicle vehicle = new Vehicle() {
            public void drive() {
                System.out.println("Driving Vehicle");
            }
        };
        vehicle.drive();
    }

}
