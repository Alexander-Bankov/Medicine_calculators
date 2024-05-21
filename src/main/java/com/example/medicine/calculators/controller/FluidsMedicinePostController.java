package com.example.medicine.calculators.controller;

import com.example.medicine.calculators.service.type.calculator.FluidsMedicineCalculator;
import com.example.medicine.calculators.dto.ResultDto;
import com.example.medicine.calculators.dto.FluidsMedicineDto;
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

    @Qualifier("fluids-medicine-calculator")
    @Operation(summary = "Калькулятор Расчет содержания вещества в растворе",
            description = "Этот калькулятор позволяет пересчитать процентное содержание вещества в заданном объеме раствора в миллиграммы")
    @PostMapping("/fluids-medicine/result")
    public ResultDto result(@Valid @RequestBody FluidsMedicineDto dto)  {
        return fluidsMedicineCalculator.calculateResult(dto);
    }
}
