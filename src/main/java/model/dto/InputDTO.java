package model.dto;

public class InputDTO {
    private static final String DELIMITER = "-";
    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';

    public String[] splitTwoPoints(final String input) {
        validateInputForm(input);
        return removeBracket(input).split(DELIMITER);
    }

    private void validateInputForm(final String input) {
        if (!input.contains("-")) {
            throw new IllegalArgumentException("두 점을 구분자( - )로 구분해야합니다.");
        }
        if (hasWrongBracketPosition(input)) {
            throw new IllegalArgumentException("점들을 담는 괄호가 잘못되었습니다.");
        }
    }

    private String removeBracket(String input) {
        for (int index = 0; index < 2; index++) {
            input = input.replace("(", "");
            input = input.replace(")", "");
        }
        return input;
    }

    private boolean hasWrongBracketPosition(final String input) {
        int delimiterIndex = input.indexOf(DELIMITER);
        return input.charAt(0) != LEFT_BRACKET || input.charAt(delimiterIndex - 1) != RIGHT_BRACKET
                || input.charAt(delimiterIndex + 1) != LEFT_BRACKET || input.charAt(input.length() - 1) != RIGHT_BRACKET;
    }
}
