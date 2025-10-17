package calculator.domain;

import java.util.ArrayList;
import java.util.Collection;

public class CalculatorNumber {
    public Collection<Double> numbers;

    public CalculatorNumber() {
        this.numbers = new ArrayList<>();
    }

    public void addNumber(Double number) {
        numbers.add(number);
    }

    public Collection<?> getNumbers() {
        return numbers;
    }
}
