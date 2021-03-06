package model.vo;

public class Number {
    private final Integer value;
    private static final Integer MIN_VALUE = 0;
    private static final Integer MIX_VALUE = 24;
    private static final String NUMBER_REGEX = "^[0-9]*$";

    private Number(final String value) {
        this.value = Integer.parseInt(value);
    }

    public static Number generate(final String value) throws IllegalArgumentException {
        validateNumber(value);
        return new Number(value);
    }

    private static void validateNumber(final String value) throws IllegalArgumentException {
        if (!value.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("좌표 값에 숫자가 아닌 입력 혹은 음수 입력이 있습니다.");
        }
        int number = Integer.parseInt(value);
        if (number < MIN_VALUE || number > MIX_VALUE) {
            throw new IllegalArgumentException("점은 0~24 사이의 값만 가질 수 있습니다.");
        }
    }

    public Integer getDifference(final Number another) {
        return value - another.value;
    }

    public Integer getValue() {
        return value;
    }
}
