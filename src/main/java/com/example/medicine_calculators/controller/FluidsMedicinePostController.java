package com.example.medicine_calculators.controller;

import com.example.medicine_calculators.exeptions.*;
import com.example.medicine_calculators.calculator_operations.FluidsMedicineCalculator;
import com.example.medicine_calculators.calculators.FluidsMedicineDto;
import com.example.medicine_calculators.calculators.ResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@Tag(name = "Расчет медицинских калькуляторов", description = "Возвращает результаты расчетов в формате json")
@RequestMapping("/calculator")
public class FluidsMedicinePostController {
    private final FluidsMedicineCalculator fluidsMedicineCalculator;
    @Autowired
    protected FluidsMedicinePostController(FluidsMedicineCalculator fluids){this.fluidsMedicineCalculator = fluids;}

    @Qualifier("FluidsMedicineCalculator")
    @Operation(summary = "Калькулятор Расчет содержания вещества в растворе",
            description = "Этот калькулятор позволяет пересчитать процентное содержание вещества в заданном объеме раствора в миллиграммы")
    @PostMapping("/Fluids_medicine/result")
    public ResultDto result(@Valid @NotNull @RequestBody FluidsMedicineDto dto) /*throws Exception - для 1 try catch*/ {
        ResultDto resultDto = new ResultDto();
        resultDto = fluidsMedicineCalculator.calculateResult(dto);
        //  блок try catch был одним из вариантов(но в нем будет постоянно создаваться новый объект),
//  но я не стал ставить его, так как класс GlobalExceptionHandler будет обрабатывать все исключения контроллеров
        // 1 вариант блока try catch
//        try{resultDto = fluidsMedicineCalculator.calculateResult(dto);
//        }
//        catch (NullPointerException ex) {
//            throw new NullPointerException("ссылка на null");
//        }
//        catch (ArithmeticException ex) {
//            throw new ArithmeticException("арифметическая ошибка");
//        }
//        catch (IllegalArgumentException ex) {
//            throw new IllegalArgumentException("недопустимое значение");
//        }
//        catch (Exception ex) {
//            throw new Exception("ошибка иного типа");
//        }
//         2 варинат блока try catch
//        try{resultDto = fluidsMedicineCalculator.calculateResult(dto);
//        }catch (Exception ex) {
//            return new ResultDto(false,
//                    ex.getMessage(),
//                    LocalDateTime.now(),
//                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                    ExceptionUtils.getRootCauseMessage(ex),
//                    ExceptionUtils.getStackTrace(ex));
//        }
        return resultDto;
    }
}
