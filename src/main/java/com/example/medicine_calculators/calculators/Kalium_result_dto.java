package com.example.medicine_calculators.calculators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Kalium_result_dto {
    private String result;
    private double deficite_mol;
    private double deficite_mg;
    private double seven_percent_fluid;
    private double four_percent_fluid;
    private double max_dose_at_day;
}
