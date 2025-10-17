package calculator.service;

import calculator.domain.CalculatorNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.Collection;

public class CalculatorServiceImpl implements CalculatorService {


    @Override
    public String inputMessage() {
        return Console.readLine();
    }

    @Override
    public Number calculateSum(Collection<?> numbers) {
        return null;
    }
}
