package calculator.view;

public class CalculatorView {
    public static final String INTRO_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    public static final String RESULT_MESSAGE = "결과 : ";

    public void display() {
        System.out.println(INTRO_MESSAGE);
    }

    public void printMessage(Number result) {
        System.out.println(RESULT_MESSAGE + result);
    }


}
