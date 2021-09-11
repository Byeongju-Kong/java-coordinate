package model.vo;

public class Number {
    private final Integer value;
    private static final Integer MIN_VALUE = 0;
    private static final Integer MIX_VALUE = 24;

    private Number(final Integer value) {
        this.value = value;
    }

    public static Number generate(final Integer value) {
        validateNumber(value);
        return new Number(value);
    }

    private static void validateNumber(final Integer value) {
        if (value < MIN_VALUE || value > MIX_VALUE) {
            throw new IllegalArgumentException("점은 0~24 사이의 값만 가질 수 있습니다.");
        }
    }

    public Integer getValue() {
        return value;
    }
}
