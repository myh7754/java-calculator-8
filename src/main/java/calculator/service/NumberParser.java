package calculator.service;

import calculator.domain.CalculatorNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberParser {

    private static final String DEFAULT_DELIMITER = ",|:"; // 기본 정규식
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\\n(.*)"); // 커스텀 정규식
    private static final String REGEX = "^[0-9]+$"; // 숫자만 (시작~끝까지)

    public Collection<?> parse(String message) {
        if (message == null || message.isEmpty()) {
            return new CalculatorNumber().getNumbers();
        }
        String delimiter = "";
        String numbers = "";

        Matcher matcher = CUSTOM_DELIMITER.matcher(message);
        // 커스텀 구분자가 존재한다면
        if (matcher.matches()) {
            delimiter = matcher.group(1); // 커스텀 구분 문자
            numbers = matcher.group(2);
        }

        String[] tokens = numbers.split(delimiter + "|"+ DEFAULT_DELIMITER);
        List<Double> result = new ArrayList<>();

        for (String token : tokens) {
            double number = Double.parseDouble(token);
            result.add(number);
        }
        return result;
    }
}
