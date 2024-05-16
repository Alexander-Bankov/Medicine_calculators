package com.example.medicine.calculators.controller;

import com.example.medicine.calculators.calculator.operations.SpeedMedicineCalculator;
import com.example.medicine.calculators.calculators.ResultDto;
import com.example.medicine.calculators.calculators.SpeedMedicineDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResultDto result(@Valid @RequestBody SpeedMedicineDto dto) /*throws Exception - для 1 try catch*/ {
        ResultDto resultDto = new ResultDto();
        resultDto = speedMedicineCalculator.calculateResult(dto);

        return resultDto;
    }
}

