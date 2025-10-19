package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.CalculatorNumber;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import calculator.service.NumberParser;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorView view = new CalculatorView();
        NumberParser numberParser = new NumberParser();
        CalculatorService service = new CalculatorServiceImpl(numberParser);
        CalculatorNumber number = new CalculatorNumber();
        CalculatorController controller = new CalculatorController(view, service, numberParser, number);

        controller.run();
    }
}
