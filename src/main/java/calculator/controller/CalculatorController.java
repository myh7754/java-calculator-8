package calculator.controller;

import calculator.domain.CalculatorNumber;
import calculator.service.CalculatorService;
import calculator.service.NumberParser;
import calculator.view.CalculatorView;

import java.util.Collection;

public class CalculatorController {
    private final CalculatorView calculatorView;
    private final CalculatorService calculatorService;
    private final NumberParser numberParser;
    private final CalculatorNumber calculatorNumber;

    public CalculatorController(CalculatorView view, CalculatorService service, NumberParser numberParser, CalculatorNumber  calculatorNumber) {
        this.calculatorView = view;
        this.calculatorService = service;
        this.numberParser = numberParser;
        this.calculatorNumber = calculatorNumber;
    }


    public void run() {
        calculatorView.display();
        String input = calculatorService.inputMessage();

        Collection<Double> parse = numberParser.parse(input);
        for (Double o : parse) {
            calculatorNumber.addNumber(o);
        }

        Number result = calculatorService.calculateSum(calculatorNumber);
        calculatorView.printMessage(result);
    }
}
