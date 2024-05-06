package com.example.medicine_calculators.calculator_operations;

public class Kalium_medicine_calculator {
    public double[] calculate(double kalium,double weight){
        double deficite_mol;
        double deficite_mg;
        double seven_percent_fluid;
        double four_percent_fluid;
        double max_dose_at_day;
        if (kalium<5){
            deficite_mol = weight*(5-kalium)*0.2;
            deficite_mg = deficite_mol/13.4*1000;
            seven_percent_fluid = deficite_mol;
            four_percent_fluid = (deficite_mg/40);
            max_dose_at_day = weight*3;
            return new double[]{deficite_mol,deficite_mg, seven_percent_fluid, four_percent_fluid, max_dose_at_day};
        }
        else return new double[]{0, 0,0,0,0};
    }
}