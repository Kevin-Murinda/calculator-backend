package com.calculator_backend.service.impl;

import com.calculator_backend.dto.CalculationRequestDto;
import com.calculator_backend.dto.CalculationResponseDto;
import com.calculator_backend.exception.CalculationException;
import com.calculator_backend.model.Calculator;
import com.calculator_backend.service.CalculationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service layer containing business logic for calculations
 */

@Service
@Slf4j
public class CalculationServiceImpl implements CalculationService {

    /**
     * Process calculation request and return result
     * @param requestDto the calculation request from
    frontend
     * @return calculation response with result
     */
    public CalculationResponseDto calculate(CalculationRequestDto requestDto) {

        log.info("Processing Calculation: {} {} {}",
                requestDto.getFirstValue(),
                requestDto.getSecondValue(),
                requestDto.getOperation());

        try{

            // Map DTO to Model
            Calculator calculator = mapToModel(requestDto);

            // Perform calculation (business logic)
            Calculator result = calculate(calculator);

            log.info("Calculation result: {}", result.getResult());

            return mapToResponse(calculator);
        }
        catch (ArithmeticException | IllegalArgumentException ex){
            log.error("Calculation error: {}", ex.getMessage());
            throw ex;
        }
        catch (Exception ex){
            log.error("Unexpected error during calculation", ex);
            throw new CalculationException("Failed to perform calculation", ex);
        }

    }

    public Calculator calculate(Calculator calculator) {

        if (calculator.getFirstValue() == null ||
                calculator.getSecondValue() == null ||
                calculator.getOperation() == null) {
            throw new IllegalArgumentException("All fields must be provided");
        }

        Double a = calculator.getFirstValue();
        Double b = calculator.getSecondValue();
        Double result = switch (calculator.getOperation()) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                yield a / b;
            }
            case "%" -> {
                if (b == 0) {
                    throw new ArithmeticException("Cannot modulo by zero");
                }
                yield a % b;
            }
            case "^" -> Math.pow(a, b);
            default -> throw new IllegalArgumentException("Invalid operation: " + calculator.getOperation());
        };

        calculator.setResult(result);
        return calculator;
    }


    /**
     * Manual mapping: DTO to model
     */
    private Calculator mapToModel(CalculationRequestDto dto){
        return Calculator.builder()
                .firstValue(dto.getFirstValue())
                .secondValue(dto.getSecondValue())
                .operation(dto.getOperation())
                .build();
    }

    /**
     * Manual mapping: Model to Response DTO
     */
    private CalculationResponseDto mapToResponse(Calculator calculator){
        return CalculationResponseDto.builder()
                .firstValue(calculator.getFirstValue())
                .secondValue(calculator.getSecondValue())
                .operation(calculator.getOperation())
                .result(calculator.getResult())
                .message("Calculation completed successfully")
                .build();
    }
}
