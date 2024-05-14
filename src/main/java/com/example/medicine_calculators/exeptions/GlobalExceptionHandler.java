package com.example.medicine_calculators.exeptions;

import com.example.medicine_calculators.calculators.ResultDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.BindException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Schema(description = "Обработчик ошибок")
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultDto handleException(Exception ex) {
        return new ResultDto(false,
                ex.getMessage(),
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ExceptionUtils.getRootCauseMessage(ex),
                ExceptionUtils.getStackTrace(ex));
    }
    @ExceptionHandler(ArithmeticException.class)
    public ResultDto handleArithmeticException(Exception ex) {
        return new ResultDto(false,
                ex.getMessage(),
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ExceptionUtils.getRootCauseMessage(ex),
                ExceptionUtils.getStackTrace(ex));
    }
    @ExceptionHandler(NullPointerException.class)
    public ResultDto handleNullPointerException(NullPointerException ex) {
        return new ResultDto(false,
                ex.getMessage(),
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ExceptionUtils.getRootCauseMessage(ex),
                ExceptionUtils.getStackTrace(ex));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResultDto handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResultDto(false,
                ex.getMessage(),
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ExceptionUtils.getRootCauseMessage(ex),
                ExceptionUtils.getStackTrace(ex));
    }


}
