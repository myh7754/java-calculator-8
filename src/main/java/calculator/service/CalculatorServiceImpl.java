package calculator.service;

import calculator.domain.CalculatorNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.Collection;

public class CalculatorServiceImpl implements CalculatorService {

    private final NumberParser numberParser;

    public CalculatorServiceImpl(NumberParser numberParser) {
        this.numberParser = numberParser;
    }

    @Override
    public String inputMessage() {
        return Console.readLine();
    }

    @Override
    public Number calculateSum(CalculatorNumber numbers) {
        double sum = numbers.getNumbers().stream()
                .mapToDouble(Number::doubleValue)
                .sum();
        if (sum % 1 == 0) {
            return Long.valueOf((long) sum);
        } else {
            return Double.valueOf(sum);
        }
    }

    public NumberParser getNumberParser() {
        return numberParser;
    }
}
