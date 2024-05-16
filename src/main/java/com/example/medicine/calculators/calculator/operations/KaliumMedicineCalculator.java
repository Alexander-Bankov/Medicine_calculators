package com.example.medicine.calculators.calculator.operations;

import com.example.medicine.calculators.calculators.KaliumMedicineDto;
import com.example.medicine.calculators.calculators.ResultDto;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Service
public class KaliumMedicineCalculator implements MedicalCalculatorService<KaliumMedicineDto>{

    @Override
    public BigDecimal[] calculate(KaliumMedicineDto dto) {
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
        return new BigDecimal[]{deficiteMoll,deficiteMilligram,fluidSevenPercent,fluidFourPercent,maximumDoza};
    }

    @Override
    public ResultDto calculateResult(KaliumMedicineDto dto) {
        BigDecimal[] kaliumResult;
        kaliumResult = calculate(dto);
        return result(kaliumResult);
    }

    @Override
    public ResultDto result(BigDecimal[] result) {
        if (result[0] != BigDecimal.ZERO){
            return  new ResultDto(String.format("""
                    Дефицит калия %s ммоль или %s миллиграмм.
                    Для возмещения необходимо %s 7.5%% раствора или %s 4%% раствора.
                    Максимальная доза в день %s ммоль""",
                    result[0],result[1],result[2],result[3],result[4]),true);
        }
        else {
            return new ResultDto("Дефицита калия нет",true);
        }
    }


}