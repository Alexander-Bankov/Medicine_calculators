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

    @Schema(description = "Реузльтат выполнения", format = "String")
    private String result;

    public ResultDto(Boolean success, String errorMessage, LocalDateTime errorDateTime, Integer status, String cause, String stacktrace) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.errorDateTime = errorDateTime;
        this.status = status;
        this.cause = cause;
        this.stacktrace = stacktrace;
    }

    public ResultDto(String result, Boolean success) {
        this.result = result;
        this.success = success;
    }
}
