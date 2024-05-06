package com.example.medicine_calculators.calculator_operations;

public class Fluids_medicine_calculator {

    public double miligram(double percent, double size){
        return percent*size*10;
    }
    public double microgram(double percent, double size){
        return percent*size*10000;
    }
}
