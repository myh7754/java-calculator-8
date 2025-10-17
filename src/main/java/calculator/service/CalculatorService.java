package calculator.service;

import calculator.domain.CalculatorNumber;

import java.util.Collection;

public interface CalculatorService {
    String inputMessage();
    Number calculateSum(Collection<?> numbers);
}
