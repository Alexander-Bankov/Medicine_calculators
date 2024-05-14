package com.example.medicine_calculators.calculators;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Schema(description = "Данный DTO класс предназначен для получения данных, чтобы вычислить дефицит калия")
@Getter
@Setter
@AllArgsConstructor
public class KaliumMedicineDto extends BaseMedicineDto {
    @Schema(description = "Калий сыворотки ", format = "BigDecimal")
    @NotNull
    @Positive
    private BigDecimal kalium;

    @Schema(description = "Вес пациента", format = "BigDecimal")
    @NotNull
    @Positive
    private BigDecimal weight;

}
