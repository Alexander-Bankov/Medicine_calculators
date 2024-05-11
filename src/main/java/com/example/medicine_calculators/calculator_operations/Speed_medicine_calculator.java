package com.example.medicine_calculators.calculator_operations;

public class Speed_medicine_calculator {
    public double[] drop_in_times(String time_name, double size, double time){
        double minute;
        double seconds;

        switch(time_name){
            case "minute":
                minute = size*20/time;
                seconds = size*20/time/60;
                break;
            case "hours":
                minute = (size*20)/(time*60);
                seconds = (size*20)/(time*60*60);
                break;
            default:
                minute = 2;
                seconds = 1;
        }

        return new double[]{minute, seconds};
    }
}
