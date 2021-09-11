package model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {
    @ParameterizedTest
    @DisplayName("0~24 범위 밖의 숫자 혹은 숫자가 아닌 값으로 Number 객체를 생성하면 예외를 발생시킨다.")
    @CsvSource({"( , 좌표 값에 숫자가 아닌 입력 혹은 음수 입력이 있습니다.", "-1, 좌표 값에 숫자가 아닌 입력 혹은 음수 입력이 있습니다.", "25, 점은 0~24 사이의 값만 가질 수 있습니다."})
    void create_ExceptionByWrongNumber(String wrongNumber, String exceptionMessage) {
        assertThatIllegalArgumentException().isThrownBy(() -> Number.generate(wrongNumber))
                .withMessage(exceptionMessage);
    }

    @Test
    @DisplayName("좌표 값을 반환한다.")
    void getValue() {
        Number firstNumber = Number.generate("10");
        Number secondNumber = Number.generate("8");
        int actual = firstNumber.getDifference(secondNumber);
        int expect = 2;
        assertThat(actual).isEqualTo(expect);
    }
}