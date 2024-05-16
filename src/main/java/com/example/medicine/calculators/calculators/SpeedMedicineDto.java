package com.example.medicine.calculators.calculators;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Schema(description = "Данный DTO класс предназначен для получения данных, чтобы рассчитать скорость введения препарата")
@Getter
@Setter
@AllArgsConstructor
public class SpeedMedicineDto extends BaseMedicineDto {
    @Schema(description = "В какой еднице вводится время(часы или минуты)",format = "String")
    @NotNull(message = "Параметр 'в какой единице вводится время' обязательный для заполнения")
    private String time_name;

    @Schema(description = "Объем раствора", format = "BigDecimal")
    @Positive(message = "Значение 'Объем раствора' строго положительное")
    @Min(value = 1, message = "Минимальное значение 'объема раствора' 1 мл")
    @NotNull(message = "Параметр 'объем раствора' обязательный для заполнения")
    private BigDecimal size;

    @Schema(description = "Желаемое время введения", format = "BigDecimal")
    @Positive(message = "Значение 'Желаемое времени введения препарата' является строго положительным")
    @DecimalMin(value = "0.1", message = "Желаемое время введения препарата' должно быть не меньше 0.1 минуты/часа")
    @NotNull(message = "Параметр 'желаемое время введения препарата' обязательный для заполнения")
    private BigDecimal time;
}
