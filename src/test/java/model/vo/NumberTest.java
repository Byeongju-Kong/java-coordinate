package model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {
    @ParameterizedTest
    @DisplayName("0~24 범위 밖의 숫자로 Number 객체를 생성하면 예외를 발생시킨다.")
    @ValueSource(ints = {-1, 25})
    void create_ExceptionByWrongNumber(int wrongNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> Number.generate(wrongNumber))
                .withMessage("점은 0~24 사이의 값만 가질 수 있습니다.");
    }

    @Test
    @DisplayName("좌표 값을 반환한다.")
    void getValue() {
        Number number = Number.generate(10);
        int actual = number.getValue();
        int expect = 10;
        assertThat(actual).isEqualTo(expect);
    }
}