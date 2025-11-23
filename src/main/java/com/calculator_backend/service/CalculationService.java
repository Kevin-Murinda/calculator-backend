package com.calculator_backend.service;

import com.calculator_backend.dto.CalculationRequestDto;
import com.calculator_backend.dto.CalculationResponseDto;

public interface CalculationService {

    CalculationResponseDto calculate(CalculationRequestDto calculationRequestDto);
}
