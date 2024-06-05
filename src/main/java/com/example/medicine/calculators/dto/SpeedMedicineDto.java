package com.example.medicine.calculators.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Schema(description = "Данный DTO класс предназначен для получения данных, чтобы рассчитать скорость введения препарата")
@Getter
@Setter
@AllArgsConstructor
public class SpeedMedicineDto extends BaseMedicineDto {
    @Schema(description = "В какой единице вводится время(часы или минуты)",format = "String")
    @NotNull(message = "Параметр 'в какой единице вводится время' обязательный для заполнения")
    private String time_name;

    @Schema(description = "Объем раствора", format = "BigDecimal")
    @DecimalMax(value = "100", message = "Максимальное значение 'объема раствора' 1 мл")
    @DecimalMin(value = "1", message = "Минимальное значение 'объема раствора' 1 мл")
    @NotNull(message = "Параметр 'объем раствора' обязательный для заполнения")
    private BigDecimal size;

    @Schema(description = "Желаемое время введения", format = "BigDecimal")
    @Positive(message = "Значение 'Желаемое времени введения препарата' является строго положительным")
    @DecimalMin(value = "0.1", message = "Желаемое время введения препарата' должно быть не меньше 0.1 минуты/часа")
    @NotNull(message = "Параметр 'желаемое время введения препарата' обязательный для заполнения")
    private BigDecimal time;
}
