package calculator.view;

public class CalculatorView {
    public static final String introMessage = "덧셈할 문자열을 입력해 주세요.";
    public static final String resultMessage = "결과 : ";

    public void display() {
        System.out.println(introMessage);
    }

    public void printMessage(Long result) {
        System.out.println(resultMessage + result);
    }

    public void printMessage(Double result) {
        System.out.println(resultMessage + result);
    }

}
