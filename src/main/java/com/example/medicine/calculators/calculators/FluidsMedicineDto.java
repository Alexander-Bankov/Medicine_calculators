package com.example.medicine.calculators.calculators;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Schema(description = "Данный DTO класс предназначен для получения данных, чтобы рассчитать содержание вещества в растворе")
@Getter
@Setter
@AllArgsConstructor
public class FluidsMedicineDto extends BaseMedicineDto{


    @Schema(description = "Процентное содержание вещества", format = "BigDecimal")
    @Range(min = 1, max = 90, message = "'Процентное содержание вещества' не должен быть меньше 1% и не должен превышать 90%")
    @NotNull(message = "параметр процент является обязательным")
    private BigDecimal percent;


    @Schema(description = "Объем ампулы ", format = "BigDecimal")
    @Range(min = 1, max = 30, message = "'объем ампулы' не должен быть меньше 1 мл и не должен превышать 30мл")
    @NotNull(message = "параметр объем ампулы является обязательным")
    private BigDecimal size;
}
