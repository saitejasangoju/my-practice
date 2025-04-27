package com.practice.designpatterns.structural.adapter;

public class WeighMachineInKG implements WeighMachineAdapter {

    private WeightMachine weightMachine;
    
    public WeighMachineInKG(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }
    
    @Override
    public double getWeightInKG() {
        double weightInPound = weightMachine.getWeightInPounds();
        double weightInKG = weightInPound * 0.45; 
        return weightInKG;
    }

}
