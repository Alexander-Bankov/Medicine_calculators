package com.example.medicine_calculators.calculator_operations;

import com.example.medicine_calculators.calculators.KaliumMedicineDto;
import com.example.medicine_calculators.calculators.ResultDto;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
        if (dto.getKalium().compareTo(new BigDecimal("5")) < 0){
            deficiteMoll = dto.getWeight().multiply(new BigDecimal("5").subtract(dto.getKalium())).multiply(new BigDecimal("0.2"));
            deficiteMilligram = deficiteMoll.multiply(new BigDecimal("1000")).divide(new BigDecimal("13.4"));
            fluidSevenPercent = deficiteMoll;
            fluidFourPercent = deficiteMilligram.divide(new BigDecimal("40"));
            maximumDoza = dto.getWeight().multiply(new BigDecimal("3"));
            return new BigDecimal[]{deficiteMoll,deficiteMilligram,fluidSevenPercent,fluidFourPercent,maximumDoza};
        }
        else return new BigDecimal[]{BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO};
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