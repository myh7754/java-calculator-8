package calculator.service;

import java.util.Collection;

public class NumberParser {

    public Collection<?> parse(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("message is null or empty");
        }


        return null;
    }
}
