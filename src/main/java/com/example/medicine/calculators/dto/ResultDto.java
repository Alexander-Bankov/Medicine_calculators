package com.example.medicine.calculators.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Schema(description = "Данный DTO класс предназначен для получения результата вычислений или ошибки")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto extends BaseMedicineDto{

    @Schema(description = "Результат выполнения", format = "String")
    private String result;
    @Schema(description = "Результат выполнения ", format = "Boolean")
    private Boolean success;

    @Schema(description = "Сообщение ошибки", format = "String")
    private String errorMessage;

    @Schema(description = "Время возникновение", format = "LocalDateTime")
    private LocalDateTime errorDateTime;

    @Schema(description = "Статус ошибки", format = "Integer")
    private Integer status;

    @Schema(description = "Причина", format = "String")
    private String cause;

    @Schema(description = "StackTrace", format = "String")
    private String stacktrace;




    public ResultDto(String result, Boolean success) {
        this.result = result;
        this.success = success;
    }
}
