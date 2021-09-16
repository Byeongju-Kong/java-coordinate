package model.point;

import model.vo.Number;

public class Point {
    private final Number x;
    private final Number y;
    private static final String DELIMITER = ",";

    private Point(final String coordinate) throws IllegalArgumentException {
        String[] values = splitCoordinate(coordinate);
        this.x = Number.generate(values[0]);
        this.y = Number.generate(values[1]);
    }

    public static Point create(final String coordinate) throws IllegalArgumentException {
        return new Point(coordinate);
    }

    private String[] splitCoordinate(final String validatedCoordinate) throws IllegalArgumentException {
        validateCoordinate(validatedCoordinate);
        return validatedCoordinate.split(DELIMITER);
    }

    private void validateCoordinate(final String coordinate) throws IllegalArgumentException {
        if (coordinate.contains(" ") || coordinate.isEmpty()) {
            throw new IllegalArgumentException("좌표에 대한 입력에 공백이 있거나 좌표에 대한 정보이 없습니다.");
        }
        if (!coordinate.contains(DELIMITER)) {
            throw new IllegalArgumentException("x, y 값을 구분하는 구분자 입력이 없습니다.");
        }
        if (String.valueOf(coordinate.charAt(0)).equals(DELIMITER) ||
                String.valueOf(coordinate.charAt(coordinate.length() - 1)).equals(DELIMITER)) {
            throw new IllegalArgumentException("x, y 값 중 하나만 입력하셨습니다.");
        }
    }

    public Integer getXDifference(final Point another) {
        return x.getDifference(another.x);
    }

    public Integer getYDifference(final Point another) {
        return y.getDifference(another.y);
    }

    public Number getX() {
        return x;
    }

    public Number getY() {
        return y;
    }
}
