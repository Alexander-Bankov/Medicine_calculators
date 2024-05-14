package com.example.medicine_calculators.calculators;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Данный DTO класс предназначен для получения результата вычислений или ошибки")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto extends BaseMedicineDto{

    @Schema(description = "Реузльтат выполнения", format = "String")
    private String result;
    @Schema(description = "результат выполнения ", format = "Boolean")
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
