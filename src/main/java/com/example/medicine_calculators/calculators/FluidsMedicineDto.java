package com.example.medicine_calculators.calculators;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Schema(description = "Данный DTO класс предназначен для получения данных, чтобы рассчитать содержание вещества в растворе")
@Getter
@Setter
@AllArgsConstructor
public class FluidsMedicineDto extends BaseMedicineDto{


    @Schema(description = "Процентное содержание вещества", format = "BigDecimal")
    @Positive
    @NotNull
    private BigDecimal percent;


    @Schema(description = "Объем ампулы ", format = "BigDecimal")
    @NotNull
    @Positive
    private BigDecimal size;
}
