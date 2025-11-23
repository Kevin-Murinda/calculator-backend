package com.calculator_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Calculator {

    private Double firstValue;
    private Double secondValue;
    private String operation;
    private Double result;
}
