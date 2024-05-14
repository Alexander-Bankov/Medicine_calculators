package com.example.medicine_calculators.calculators;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Данный DTO класс предназначен для вывода информации")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Info extends BaseMedicineDto{
    @Schema(description = "Информация",format = "String")
    private String info;
}
