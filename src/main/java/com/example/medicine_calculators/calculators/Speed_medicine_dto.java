package com.example.medicine_calculators.calculators;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Speed_medicine_dto {
    @NotNull
    private String time_name;
    @NotNull
    @Positive
    private double size;
    @NotNull
    @Positive
    private double time;
}
