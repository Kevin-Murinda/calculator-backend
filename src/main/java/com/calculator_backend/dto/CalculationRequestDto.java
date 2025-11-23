package com.calculator_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for incoming calculation requests
 from frontend
 * Contains validation rules for API input
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalculationRequestDto {

    @NotNull(message = "First value is required")
    private Double firstValue;
    @NotNull(message = "Second value is required")
    private Double secondValue;
    @NotBlank(message = "Operation is required")
    @Pattern(regexp = "[+\\-*/%^]", message = "Operation must be one of: +, -, *, /, %, ^")
    private String operation;
}
