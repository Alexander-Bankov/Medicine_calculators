package com.example.medicine_calculators.controller;

import com.example.medicine_calculators.calculator_operations.KaliumMedicineCalculator;
import com.example.medicine_calculators.calculator_operations.SpeedMedicineCalculator;
import com.example.medicine_calculators.calculators.KaliumMedicineDto;
import com.example.medicine_calculators.calculators.ResultDto;
import com.example.medicine_calculators.calculators.SpeedMedicineDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Tag(name = "Расчет медицинских калькуляторов", description = "Возвращает результаты расчетов в формате json")
@RequestMapping("/calculator")
public class SpeedMedicinePostController {
    private final SpeedMedicineCalculator speedMedicineCalculator;
    @Autowired
    protected SpeedMedicinePostController(SpeedMedicineCalculator speed){this.speedMedicineCalculator = speed;}

    @Operation(summary = "Калькулятор Расчет скорости внутривенного капельного введения препарата",
            description = "Этот калькулятор позволяет рассчитать скорость ведения внутривенного капельного препарата")
    @PostMapping("/Speed_medicine/result")
    public ResultDto result(@Valid  @NotNull  @RequestBody SpeedMedicineDto dto){
        ResultDto resultDto = new ResultDto();
        resultDto = speedMedicineCalculator.calculateResult(dto);

//  блок try catch был одним из вариантов(но в нем будет постоянно создаваться новый объект),
//  но я не стал ставить его, так как класс GlobalExceptionHandler будет обрабатывать все исключения контроллеров
//        try{resultDto = speedMedicineCalculator.calculateResult(dto);
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

