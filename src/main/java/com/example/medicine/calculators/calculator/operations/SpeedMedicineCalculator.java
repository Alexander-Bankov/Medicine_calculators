package com.example.medicine.calculators.calculator.operations;

import com.example.medicine.calculators.calculators.ResultDto;
import com.example.medicine.calculators.calculators.SpeedMedicineDto;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Service
public class SpeedMedicineCalculator implements MedicalCalculatorService<SpeedMedicineDto>{

    @Override
    public BigDecimal[] calculate(SpeedMedicineDto dto) {
        BigDecimal minute = null;
        BigDecimal second = null;
        switch(dto.getTime_name()){
            case "minute":
                minute = dto.getSize().multiply(new BigDecimal("20")).divide(dto.getTime(), RoundingMode.HALF_UP);
                second = dto.getSize().multiply(new BigDecimal("20")).divide(dto.getTime(), RoundingMode.HALF_UP).divide(new BigDecimal("60"), RoundingMode.HALF_UP);
                break;
            case "hours":
                minute = dto.getSize().multiply(new BigDecimal("20")).divide(dto.getTime(), RoundingMode.HALF_UP).divide(new BigDecimal("60"), RoundingMode.HALF_UP);
                second = dto.getSize().multiply(new BigDecimal("20")).divide(dto.getTime(), RoundingMode.HALF_UP).divide(new BigDecimal("3600"), RoundingMode.HALF_UP);
                break;
            default:
                throw new IllegalArgumentException("введен неккоректный указатель времени");
           }
        return new BigDecimal[]{minute, second};
    }

    @Override
    public ResultDto calculateResult(SpeedMedicineDto dto) {
        BigDecimal[] speedResult;
        speedResult = calculate(dto);

        return result(speedResult);
    }

    @Override
    public ResultDto result(BigDecimal[] result) {
        ResultDto resultDto = new ResultDto(String.format("%s Капель в минуту, %s капель в секунду",result[0],result[1]),true);
        return resultDto;
    }


}
