package com.example.medicine.calculators.service.type.calculator;

import com.example.medicine.calculators.dto.KaliumMedicineDto;
import com.example.medicine.calculators.dto.ResultDto;
import com.example.medicine.calculators.service.MedicalCalculatorService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Service
public class KaliumMedicineCalculator implements MedicalCalculatorService<KaliumMedicineDto> {

    @Override
    public ResultDto calculateResult(KaliumMedicineDto dto) {
        BigDecimal deficiteMoll;
        BigDecimal deficiteMilligram;
        BigDecimal fluidSevenPercent;
        BigDecimal fluidFourPercent;
        BigDecimal maximumDoza;
        deficiteMoll = dto.getWeight().multiply(new BigDecimal("5").subtract(dto.getKalium())).multiply(new BigDecimal("0.2"));
        deficiteMilligram = deficiteMoll.multiply(new BigDecimal("1000")).divide(new BigDecimal("13.4"), RoundingMode.HALF_UP);
        fluidSevenPercent = deficiteMoll;
        fluidFourPercent = deficiteMilligram.divide(new BigDecimal("40"), RoundingMode.HALF_UP);
        maximumDoza = dto.getWeight().multiply(new BigDecimal("3"));
        return  new ResultDto(String.format("""
                    Дефицит калия %s ммоль или %s миллиграмм.
                    Для возмещения необходимо %s 7.5%% раствора или %s 4%% раствора.
                    Максимальная доза в день %s ммоль""",
                deficiteMoll, deficiteMilligram, fluidSevenPercent, fluidFourPercent, maximumDoza),true);
    }


}