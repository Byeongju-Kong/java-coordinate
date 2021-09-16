package model.shape;

import model.vo.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {
    private final Line line = Line.generate(new String[]{"1,1", "2,2"});

    @Test
    @DisplayName("Line을 생성하고 길이를 반환한다.")
    void getLength() {
        double actual = line.getLength();
        double expect = 1.414;
        assertThat(actual).isEqualTo(expect, offset(0.00099));
    }

    @Test
    @DisplayName("같은 위치의 두 점으로 객체를 생성하면 예외를 발생시킨다.")
    void create_ExceptionBySamePoints() {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.generate(new String[]{"1,1", "1,1"}))
                .withMessage("두 점이 같은 위치에 있으면 선을 생성할 수 없습니다.");
    }

    @Test
    @DisplayName("두 점을 반환한다.")
    void getPoints() {
        assertAll(
                () -> assertThat(line.getPoints().get(0).getX()).isEqualTo(Number.generate("1")),
                () -> assertThat(line.getPoints().get(1).getX()).isEqualTo(Number.generate("2")),
                () -> assertThat(line.getPoints().get(0).getY()).isEqualTo(Number.generate("1")),
                () -> assertThat(line.getPoints().get(1).getY()).isEqualTo(Number.generate("2"))
        );
    }
}