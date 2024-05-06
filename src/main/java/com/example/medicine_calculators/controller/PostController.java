package com.example.medicine_calculators.controller;

import com.example.medicine_calculators.calculator_operations.Fluids_medicine_calculator;
import com.example.medicine_calculators.calculator_operations.Kalium_medicine_calculator;
import com.example.medicine_calculators.calculator_operations.Speed_medicine_calculator;
import com.example.medicine_calculators.calculators.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class PostController {
    @PostMapping("/Fluids_medicine/result")
    public ResponseEntity<Fluids_result_dto> fluids_medicine(@Valid @RequestBody Fluids_medicine_dto dto) {
        Fluids_medicine_calculator calculator = new Fluids_medicine_calculator();

        double miligram = calculator.miligram(dto.getPercent(), dto.getSize());
        double microgram = calculator.microgram(dto.getPercent(), dto.getSize());
        Fluids_result_dto speedResult = new Fluids_result_dto(miligram, microgram);
        return ResponseEntity.ok(speedResult);
    }
    @PostMapping("/Speed_medicine/result")
    public ResponseEntity<Speed_result_dto> speed_medicine(@Valid @RequestBody Speed_medicine_dto dto) {
        Speed_medicine_calculator calculator = new Speed_medicine_calculator();
        double[] times = calculator.drop_in_times(dto.getTime_name(),dto.getSize(),dto.getTime());
        Speed_result_dto speedResult = new Speed_result_dto(times[0],times[1]);
        return ResponseEntity.ok(speedResult);
    }
    @PostMapping("/Kalium_medicine/result")
    public ResponseEntity<Kalium_result_dto> speed_medicine(@Valid @RequestBody Kalium_medicine_dto dto) {
        Kalium_medicine_calculator calculator = new Kalium_medicine_calculator();
        Kalium_result_dto kaliumresult;

        if (dto.getKalium() < 5) {
            double[] result = calculator.calculate(dto.getKalium(), dto.getWeight());
            kaliumresult = new Kalium_result_dto("Deficite", result[0], result[1], result[2], result[3], result[4]);
        } else {
            kaliumresult = new Kalium_result_dto("NotDeficite", 0, 0, 0, 0, 0);
        }

        return ResponseEntity.ok(kaliumresult);
    }

}
