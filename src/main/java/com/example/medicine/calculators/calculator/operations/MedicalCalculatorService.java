package com.example.medicine.calculators.calculator.operations;

import com.example.medicine.calculators.calculators.BaseMedicineDto;
import com.example.medicine.calculators.calculators.ResultDto;

import java.math.BigDecimal;

public interface MedicalCalculatorService<T extends BaseMedicineDto> {
    public BigDecimal[] calculate(T dto);
    public ResultDto result(BigDecimal[] result);
    public ResultDto calculateResult(T dto);
}
