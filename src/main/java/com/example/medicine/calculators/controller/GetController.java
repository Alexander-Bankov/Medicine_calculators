package com.example.medicine.calculators.controller;

import com.example.medicine.calculators.calculators.Info;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public Info getDefaultResponse() {
        return new Info("""
                Калькулятор 1 - Расчет содержания вещества в растворе (пересчет процентов в миллиграммы).
                "Калькулятор 2 - Расчет дефицита калия. 
                "Калькулятор 3 - Расчет скорости внутривенного капельного введения препарата""");
    }
    @Tag(name = "Информация об отдельном калькуляторе")
    @Operation(summary = "Возвращает информацию об отдельном калькуляторе в формате json",
            description = "Возвращает информацию об отдельном калькуляторе и о его приблизительной схеме работы")
    @GetMapping("/{calculatorName}/info")
    public Info getCalculatorInfo(@PathVariable("Название кулькулятора") String calculatorName) {
        Info info = new Info();
        switch (calculatorName.toLowerCase()) {
            case "fluids_calculator":
                try {
                    info.setInfo("""
                            Этот калькулятор позволяет пересчитать процентное содержание вещества в заданном объеме раствора в миллиграммы.
                            Расчеты исходят из того факта, что 1% любого вещества в среднем соответствует 10 мг вещества в растворе.
                            Также известно, что 1 мг (миллиграмм) = 1000 мкг (микрограмм), а 1 г (грамм) = 1000 мг (миллиграмм)
                            """);
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
            case "kalium_calculator":
                try {
                    info.setInfo("""
                            Расчет дефицита калия в плазме крови и объема его возмещения.
                            Дефицит калия (ммоль/л) = (5 - калий плазмы пациента в ммоль/л) * 0.2 * массу тела пациента
                            1 ммоль калия = 39.1 мг калия.
                            1 грамм калия хлорида (KCL) = 13.4 ммоль калия
                            """);
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
            case "speed_calculator":
                try {
                    info.setInfo("""
                            Расчет скорости внутривенного капельного введения препарата
                            Расчеты исходят из того факта, что 1% любого вещества в среднем соответствует 10 мг вещества в растворе.
                            Также известно, что 1 мг (миллиграмм) = 1000 мкг (микрограмм), а 1 г (грамм) = 1000 мг (миллиграмм)Расчет производится по следующей формуле:
                            количество капель в минуту = V*20/t,
                            где V - объем раствора в милилитрах, t - время в минутах, 20 - среднее количество капель в милилитре, v - скорость введения в каплях в минуту
                            """);
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
            default:
                return new Info(String.format("Калькулятора с названием %s нет ", calculatorName));
        }
    }
}