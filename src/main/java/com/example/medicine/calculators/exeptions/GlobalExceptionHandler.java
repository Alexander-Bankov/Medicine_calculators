package com.example.medicine.calculators.exeptions;

import com.example.medicine.calculators.calculators.ResultDto;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Schema(description = "Обработчик ошибок")
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultDto handleException(Exception ex) {
        return new ResultDto("ошибка " + ex.getClass().getSimpleName(),
                false,
                ex.getMessage(),
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ExceptionUtils.getRootCauseMessage(ex),
                ExceptionUtils.getStackTrace(ex));
    }
    @ExceptionHandler(ArithmeticException.class)
    public ResultDto handleArithmeticException(Exception ex) {
        return new ResultDto("арифметическая ошибка",
                false,
                ex.getMessage(),
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ExceptionUtils.getRootCauseMessage(ex),
                ExceptionUtils.getStackTrace(ex));
    }
    @ExceptionHandler(NullPointerException.class)
    public ResultDto handleNullPointerException(NullPointerException ex) {
        return new ResultDto("ошибка  - обращение к null",
                false,
                ex.getMessage(),
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ExceptionUtils.getRootCauseMessage(ex),
                ExceptionUtils.getStackTrace(ex));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResultDto handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResultDto("ошибка - недопустимое значение аргумента",
                false,
                ex.getMessage(),
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ExceptionUtils.getRootCauseMessage(ex),
                ExceptionUtils.getStackTrace(ex));
    }


}
