package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
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
    @DisplayName("두 점을 반환한다.")
    void getPoints() {
        assertAll(
                () -> assertThat(line.getPoints().get(0).getX()).isEqualTo(1),
                () -> assertThat(line.getPoints().get(0).getY()).isEqualTo(1),
                () -> assertThat(line.getPoints().get(1).getX()).isEqualTo(2),
                () -> assertThat(line.getPoints().get(1).getY()).isEqualTo(2)
        );
    }
}