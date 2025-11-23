package com.calculator_backend.dto;

import com.calculator_backend.model.Calculator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for sending calculation results to
 frontend
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalculationResponseDto {

    private Double firstValue;
    private Double secondValue;
    private String operation;
    private Double result;
    private String message;
}
