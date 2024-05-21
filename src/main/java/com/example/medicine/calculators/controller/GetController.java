package com.example.medicine.calculators.controller;

import com.example.medicine.calculators.dto.InfoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class GetController {
    @Tag(name = "Виды калькуляторов")
    @Operation(summary = "Возвращает информацию о том, какие калькуляторы есть в формате json",
            description = "Возвращает информацию о том, какие калькулятор есть и о их приблизительной схеме работе")
    @GetMapping("")
    public InfoDto getDefaultResponse() {
        return new InfoDto("""
                Калькулятор 1 - Расчет содержания вещества в растворе (пересчет процентов в миллиграммы).
                "Калькулятор 2 - Расчет дефицита калия.
                "Калькулятор 3 - Расчет скорости внутривенного капельного введения препарата""");
    }
    @SneakyThrows
    @Tag(name = "Информация об отдельном калькуляторе")
    @Operation(summary = "Возвращает информацию об отдельном калькуляторе в формате json",
            description = "Возвращает информацию об отдельном калькуляторе и о его приблизительной схеме работы")
    @GetMapping("/{calculatorName}/info")
    public InfoDto getCalculatorInfo(@PathVariable("calculatorName") @Parameter(description = "Название калькулятора") String calculatorName) {
        try {
            switch (calculatorName.toLowerCase()) {
                case "fluids-calculator":
                    return new InfoDto("""
                    Этот калькулятор позволяет пересчитать процентное содержание вещества в заданном объеме раствора в миллиграммы.
                    Расчеты исходят из того факта, что 1% любого вещества в среднем соответствует 10 мг вещества в растворе.
                    Также известно, что 1 мг (миллиграмм) = 1000 мкг (микрограмм), а 1 г (грамм) = 1000 мг (миллиграмм).
                    """);
                case "kalium-calculator":
                    return new InfoDto("""
                    Расчет дефицита калия в плазме крови и объема его возмещения.
                    Дефицит калия (ммоль/л) = (5 - калий плазмы пациента в ммоль/л) * 0.2 * массу тела пациента
                    1 ммоль калия = 39.1 мг калия.
                    1 грамм калия хлорида (KCL) = 13.4 ммоль калия
                    """);
                case "speed-calculator":
                    return new InfoDto("""
                    Расчет скорости внутривенного капельного введения препарата
                    Расчеты исходят из того факта, что 1% любого вещества в среднем соответствует 10 мг вещества в растворе.
                    Также известно, что 1 мг (миллиграмм) = 1000 мкг (микрограмм), а 1 г (грамм) = 1000 мг (миллиграмм)Расчет производится по следующей формуле:
                    количество капель в минуту = V*20/t,
                    где V - объем раствора в миллилитрах, t - время в минутах, 20 - среднее количество капель в миллилитре, v - скорость введения в каплях в минуту
                    """);
                default:
                    throw new Exception(String.format("Калькулятора с названием %s не существует ", calculatorName));
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}