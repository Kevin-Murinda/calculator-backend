package com.calculator_backend.controller;

import com.calculator_backend.dto.CalculationRequestDto;
import com.calculator_backend.dto.CalculationResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.calculator_backend.service.CalculationService;

@RestController
@RequestMapping("/api/calculator")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@Slf4j
public class CalculatorController {

    private final CalculationService calculatorService;

    @PostMapping("/calculate")
    public ResponseEntity<CalculationResponseDto> calculate(
            @Valid @RequestBody CalculationRequestDto requestDto) {

        log.info("Received calculation request: {}", requestDto);

        CalculationResponseDto response = calculatorService.calculate(requestDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
