package com.example.medicine.calculators.controller;

import com.example.medicine.calculators.calculator.operations.FluidsMedicineCalculator;
import com.example.medicine.calculators.calculators.ResultDto;
import com.example.medicine.calculators.calculators.FluidsMedicineDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
    public ResultDto result(@Valid @RequestBody FluidsMedicineDto dto) /*throws Exception - для 1 try catch*/ {
        ResultDto resultDto = new ResultDto();
        resultDto = fluidsMedicineCalculator.calculateResult(dto);
        return resultDto;
    }
}
