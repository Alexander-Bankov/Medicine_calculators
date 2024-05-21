package com.example.medicine.calculators.service.type.calculator;

import com.example.medicine.calculators.dto.FluidsMedicineDto;
import com.example.medicine.calculators.dto.ResultDto;
import com.example.medicine.calculators.service.MedicalCalculatorService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Data
@Service
public class FluidsMedicineCalculator implements MedicalCalculatorService<FluidsMedicineDto> {

    @Override
    public ResultDto calculateResult(FluidsMedicineDto dto) {
        BigDecimal milligramm = dto.getPercent().multiply(dto.getSize()).multiply(BigDecimal.TEN);
        BigDecimal microgramm = dto.getPercent().multiply(dto.getSize()).multiply(new BigDecimal("10000"));
        return new ResultDto(String.format("Количество миллиграмм %s, количество микрограмм %s", milligramm, microgramm),true);
    }
}


