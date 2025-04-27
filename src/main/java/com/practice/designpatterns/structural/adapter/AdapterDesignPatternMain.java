package com.practice.designpatterns.structural.adapter;

public class AdapterDesignPatternMain {

    // Pattern is used to bridge gap between two interfaces (existing & new)
    // WeighMachine interface is used to get weight in pounds
    // What if client want the weight in KG's ?
    // We create a Adapter that gets weight in pounds from the server and converts it to KG's

    public static void main(String[] args) {
        WeightMachine weightMachineInPounds = new WeightMachineInPounds();
        System.out.println(weightMachineInPounds.getWeightInPounds());

        WeighMachineAdapter weightMachineInKG = new WeighMachineInKG(weightMachineInPounds);
        System.out.println(weightMachineInKG.getWeightInKG());
    }

}
