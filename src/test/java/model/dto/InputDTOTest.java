package model.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputDTOTest {
    @Test
    @DisplayName("입력에 두 점을 구분하는 구분자(-)가 없으면 예외를 발생시킨다.")
    void splitTwoPoints_ExceptionByNonHavingDelimiter() {
        InputDTO inputDTO = new InputDTO();
        String wrongInput = "(1,0)(2,8)";
        assertThatIllegalArgumentException().isThrownBy(() -> inputDTO.splitTwoPoints(wrongInput))
                .withMessage("두 점을 구분자( - )로 구분해야합니다.");
    }

    @ParameterizedTest
    @DisplayName("두 점을 담는 괄호가 잘못되었으면 예외를 발생시킨다.")
    @ValueSource(strings = {")1,2)-(3,4)", "(1,2(-(3,4)", "(1,2)-)3,4)", "(1,2)-(3,4("})
    void splitTwoPoints_ExceptionByWrongBracket(String wrongInput) {
        InputDTO inputDTO = new InputDTO();
        assertThatIllegalArgumentException().isThrownBy(() -> inputDTO.splitTwoPoints(wrongInput))
                .withMessage("점들을 담는 괄호가 잘못되었습니다.");
    }
}