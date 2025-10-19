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
    private static final Pattern VALID_NUMBER_PATTERN = Pattern.compile("^[0-9]+$");// 숫자만 (시작~끝까지)

    public Collection<Double> parse(String message) {
        if (message == null || message.isEmpty()) {
            return new CalculatorNumber().getNumbers();
        }
        String delimiter = DEFAULT_DELIMITER;
        String numbers = message;
        if (message.startsWith("//")) {
            Matcher matcher = CUSTOM_DELIMITER.matcher(message);
            // 커스텀 구분자가 존재하지 않는다면 혹은 2개이상의 구분자가 들어온다면
            if (!matcher.matches()) {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다: "+ message);
            }
            delimiter = matcher.group(1); // 커스텀 구분 문자
            numbers = matcher.group(2);

            if (numbers.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자 뒤에 값이 없습니다.");
            }
        }

        String allDelimiters = validateDelimiterUsage(numbers, delimiter);

        String[] tokens = numbers.split(allDelimiters);
        List<Double> result = new ArrayList<>();

        for (String token : tokens) {
            validateToken(token);
            result.add(Double.parseDouble(token));
        }
        return result;
    }
    private String validateDelimiterUsage(String numbers, String delimiter) {
        String allDelimiters = Pattern.quote(delimiter) +"|"+ DEFAULT_DELIMITER;
        // 연속된 구분자 검증
        if (numbers.matches(".*(" + allDelimiters + "){2,}.*")) {
            throw new IllegalArgumentException("연속된 구분자가 있습니다: " + numbers);
        }

        // 시작/끝 구분자 검증
        if (numbers.startsWith(",") || numbers.startsWith(":") ||
                numbers.endsWith(",") || numbers.endsWith(":")) {
            throw new IllegalArgumentException("구분자로 시작하거나 끝납니다: " + numbers);
        }

        return allDelimiters;
    }

    private void validateToken(String token) {
        if (!VALID_NUMBER_PATTERN.matcher(token).matches()) {
            throw new IllegalArgumentException("숫자가 아닌 값이 있습니다: " + token);
        }

        double number = Double.parseDouble(token);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다:" + token);
        }

        if (number == 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다: " + token);
        }
    }



}
