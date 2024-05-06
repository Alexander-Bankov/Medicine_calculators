package com.example.medicine_calculators.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class GetController {
    @GetMapping("")
    public ResponseEntity<String> getDefaultResponse() {
        return new ResponseEntity<>("{Калькулятор 1 - Расчет содержания вещества в растворе (пересчет процентов в миллиграммы). " +
                "Калькулятор 2 - Расчет дефицита калия. " +
                "Калькулятор 3 - Расчет скорости внутривенного капельного введения препарата}", HttpStatus.OK);
    }

    @GetMapping("/{calculatorName}/info")
    public ResponseEntity<String> getCalculatorInfo(@PathVariable String calculatorName) {
        String info = "";
        switch (calculatorName.toLowerCase()) {
            case "fluids_calculator":
                info = "Этот калькулятор позволяет пересчитать процентное содержание вещества в заданном объеме раствора в миллиграммы." +
                        "Расчеты исходят из того факта, что 1% любого вещества в среднем соответствует 10 мг вещества в растворе. " +
                        "Также известно, что 1 мг (миллиграмм) = 1000 мкг (микрограмм), а 1 г (грамм) = 1000 мг (миллиграмм)";
                return new ResponseEntity<>("{\"info\":\"" + info + "\"}", HttpStatus.OK);
            case "kalium_calculator":
                info = "Расчет дефицита калия в плазме крови и объема его возмещения." +
                        "Дефицит калия (ммоль/л) = (5 - калий плазмы пациента в ммоль/л) * 0.2 * массу тела пациента" +
                        "1 ммоль калия = 39.1 мг калия." +
                        "1 грамм калия хлорида (KCL) = 13.4 ммоль калия";
                return new ResponseEntity<>("{\"info\":\"" + info + "\"}", HttpStatus.OK);
            case "speed_calculator":
                info = "Расчет скорости внутривенного капельного введения препарата" +
                        "Расчеты исходят из того факта, что 1% любого вещества в среднем соответствует 10 мг вещества в растворе. " +
                        "Также известно, что 1 мг (миллиграмм) = 1000 мкг (микрограмм), а 1 г (грамм) = 1000 мг (миллиграмм)Расчет производится по следующей формуле:" +
                        "количество капель в минуту = V*20/t," +
                        "где V - объем раствора в милилитрах, t - время в минутах, 20 - среднее количество капель в милилитре, v - скорость введения в каплях в минуту";
                return new ResponseEntity<>("{\"info\":\"" + info + "\"}", HttpStatus.OK);
            default:
                return new ResponseEntity<>("Калькулятор - " + calculatorName + " - не найден", HttpStatus.NOT_FOUND);
        }
    }
}
