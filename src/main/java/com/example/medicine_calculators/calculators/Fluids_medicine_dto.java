package com.example.medicine_calculators.calculators;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Fluids_medicine_dto {

    @NotNull
    @Positive
    private double percent;

    @NotNull
    @Positive
    private double size;
}
