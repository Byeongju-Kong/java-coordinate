package model.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LineTest {
    @Test
    @DisplayName("Line을 생성하고 길이를 반환한다.")
    void getLength() {
        Line line = Line.generate(new String[]{"1,1", "2,2"});
        double actual = line.getLength();
        double expect = 1.414;
        assertThat(actual).isEqualTo(expect, offset(0.00099));
    }
}