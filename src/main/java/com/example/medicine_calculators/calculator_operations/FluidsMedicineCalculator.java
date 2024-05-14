package com.example.medicine_calculators.calculator_operations;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import com.example.medicine_calculators.calculators.FluidsMedicineDto;
import com.example.medicine_calculators.calculators.ResultDto;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Service
public class FluidsMedicineCalculator implements MedicalCalculatorService<FluidsMedicineDto>{

    @Override
    public BigDecimal[] calculate(FluidsMedicineDto dto) {
        BigDecimal miligram = dto.getPercent().multiply(dto.getSize()).multiply(BigDecimal.TEN);
        BigDecimal microgram = dto.getPercent().multiply(dto.getSize()).multiply(new BigDecimal("10000"));
        return new BigDecimal[]{miligram, microgram};
    }

    @Override
    public ResultDto calculateResult(FluidsMedicineDto dto) {
        BigDecimal[] fluidsResult;
        fluidsResult = calculate(dto);
        return result(fluidsResult);
    }



    @Override
    public ResultDto result(BigDecimal[] result) {
        ResultDto resultDto = new ResultDto(String.format("Количество миллиграм %s, количество микрограмм %s",result[0],result[1]),true);
        return resultDto;
    }

}


