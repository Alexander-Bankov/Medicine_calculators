package com.example.medicine.calculators.service;

import com.example.medicine.calculators.dto.BaseMedicineDto;
import com.example.medicine.calculators.dto.ResultDto;


public interface MedicalCalculatorService<T extends BaseMedicineDto> {
    public ResultDto calculateResult(T dto);
}
