package model.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class PointTest {
    @ParameterizedTest
    @DisplayName("길이가 1이거나 공백을 포함하는 문자열로 객체를 생성하면 예외를 발생시킨다.")
    @ValueSource(strings = {"", " ", "1 , 2"})
    void create_ExceptionByBlank(String wrongCoordinate) {
        assertThatIllegalArgumentException().isThrownBy(() -> Point.create(wrongCoordinate))
                .withMessage("좌표에 대한 입력에 공백이 있거나 좌표에 대한 정보이 없습니다.");
    }

    @Test
    @DisplayName("x와 y를 구분하는 구분자가 없는 문자열로 객체를 생성하면 예외를 발생시킨다.")
    void create_ExceptionByNonHavingDelimiter() {
        assertThatIllegalArgumentException().isThrownBy(() -> Point.create("12"))
                .withMessage("x, y 값을 구분하는 구분자 입력이 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("x, y 중 하나의 값에 대한 정보로만 객체를 생성하면 예외를 발생시킨다.")
    @ValueSource(strings = {"1,", ",2"})
    void create_ExceptionByOnlyOneValue(String wrongCoordinate) {
        assertThatIllegalArgumentException().isThrownBy(() -> Point.create(wrongCoordinate))
                .withMessage("x, y 값 중 하나만 입력하셨습니다.");
    }
    
    @Test
    @DisplayName("두 점의 x값 차, y값의 차를 반환한다.")
    void getDifference() {
        Point firstPoint = Point.create("3,6");
        Point secondPoint = Point.create("1,2");
        assertAll(
                () -> assertThat(firstPoint.getXDifference(secondPoint)).isEqualTo(2),
                () -> assertThat(firstPoint.getYDifference(secondPoint)).isEqualTo(4)
        );
    }

    @Test
    @DisplayName("좌표 값을 반환한다.")
    void getXAndY() {
        Point point = Point.create("1,2");
        assertAll(
                () -> assertThat(point.getX()).isEqualTo(1),
                () -> assertThat(point.getY()).isEqualTo(2)
        );
    }
}