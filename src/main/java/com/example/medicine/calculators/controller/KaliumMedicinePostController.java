package com.example.medicine.calculators.controller;

import com.example.medicine.calculators.calculator.operations.KaliumMedicineCalculator;
import com.example.medicine.calculators.calculators.ResultDto;
import com.example.medicine.calculators.calculators.KaliumMedicineDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Расчет медицинских калькуляторов", description = "Возвращает результаты расчетов в формате json")
@RequestMapping("/calculator")
public class KaliumMedicinePostController {
    private final KaliumMedicineCalculator kaliumMedicineCalculator;
    @Autowired
    protected KaliumMedicinePostController(KaliumMedicineCalculator kalium) {this.kaliumMedicineCalculator = kalium;}

    @Qualifier("KaliumMedicineCalculator")
    @Operation(summary = "Калькулятор Расчет дефицита калия",
            description = "Этот калькулятор позволяет расчитать дефицит калия в плазме крови и объем его возмещения")
    @PostMapping("/Kalium_medicine/result")
    public ResultDto result(@Valid @RequestBody KaliumMedicineDto dto)  {
        ResultDto resultDto = new ResultDto();
        resultDto = kaliumMedicineCalculator.calculateResult(dto);
        return resultDto;
    }
}

