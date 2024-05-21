package com.example.medicine.calculators.service.type.calculator;

import com.example.medicine.calculators.dto.ResultDto;
import com.example.medicine.calculators.dto.SpeedMedicineDto;
import com.example.medicine.calculators.service.MedicalCalculatorService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Service
public class SpeedMedicineCalculator implements MedicalCalculatorService<SpeedMedicineDto> {

    @Override
    public ResultDto calculateResult(SpeedMedicineDto dto) {
        BigDecimal minut = null;
        BigDecimal second = null;
        switch(dto.getTime_name()){
            case "minute":
                minut = dto.getSize().multiply(new BigDecimal("20")).divide(dto.getTime(), RoundingMode.HALF_UP);
                second = dto.getSize().multiply(new BigDecimal("20")).divide(dto.getTime(), RoundingMode.HALF_UP).divide(new BigDecimal("60"), RoundingMode.HALF_UP);
                break;
            case "hours":
                minut = dto.getSize().multiply(new BigDecimal("20")).divide(dto.getTime(), RoundingMode.HALF_UP).divide(new BigDecimal("60"), RoundingMode.HALF_UP);
                second = dto.getSize().multiply(new BigDecimal("20")).divide(dto.getTime(), RoundingMode.HALF_UP).divide(new BigDecimal("3600"), RoundingMode.HALF_UP);
                break;
            default:
                throw new IllegalArgumentException("введен некорректный указатель времени");
        }
        return new ResultDto(String.format("%s Капель в минуту, %s капель в секунду",minut,second),true);
    }


}
