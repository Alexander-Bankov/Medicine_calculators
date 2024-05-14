package com.example.medicine_calculators.calculators;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @NotNull
    private String time_name;

    @Schema(description = "Объем раствора", format = "BigDecimal")
    @NotNull
    @Positive
    private BigDecimal size;

    @Schema(description = "Желаемое время введения", format = "BigDecimal")
    @NotNull
    @Positive
    private BigDecimal time;
}
