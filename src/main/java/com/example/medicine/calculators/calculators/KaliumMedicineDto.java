package com.example.medicine.calculators.calculators;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
@Schema(description = "Данный DTO класс предназначен для получения данных, чтобы вычислить дефицит калия")
@Getter
@Setter
@AllArgsConstructor
public class KaliumMedicineDto extends BaseMedicineDto {
    @Schema(description = "Калий сыворотки ", format = "BigDecimal")
    @DecimalMax(value = "4.999", message = "'Калий сыворотки' не должен превышать 4.999 ммоль/л")
    @DecimalMin(value = "0.1", message = "'Калий сыворотки' должно быть не меньше 0.1 ммоль/л")
    @NotNull(message = "параметр 'калий сыворотки' является обязательным")
    private BigDecimal kalium;

    @Schema(description = "Вес пациента", format = "BigDecimal")
    @Range(min = 10, max = 800, message = "'Вес' не должен быть меньше 10 кг и не должен превышать 800 кг")
    @NotNull(message = "Параметр 'вес' пациента является обязательным")
    private BigDecimal weight;

}
