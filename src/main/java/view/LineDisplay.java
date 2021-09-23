package view;

import model.shape.Point;

import java.util.List;

public class LineDisplay implements Display {
    private static final String DOUBLE_SPACE = "  ";
    private static final int COORDINATE_BOUNDARY = 24;

    public void printCoordinate(List<Point> points) {
        String xAxis = "ㅡ";
        int lengthForXAxis = 60;
        for (int index = COORDINATE_BOUNDARY; index > 0; index--) {
            printYAxisAndPoints(index, points);
        }
        System.out.println(DOUBLE_SPACE + "+  " + xAxis.repeat(lengthForXAxis));
        System.out.println(printXAxis());
    }

    private void printYAxisAndPoints(int yIndex, List<Point> points) {
        StringBuilder result = new StringBuilder();
        result.append(generateYAxis(yIndex));
        result.append(drawPoint(yIndex, points));
        System.out.println(result);
    }

    private String drawPoint(int yIndex, List<Point> points) {
        String tripleSpace = "   ";
        String nothing = " ";
        if (yIndex == points.get(0).getY().getValue()) {
            return tripleSpace.repeat(points.get(0).getX().getValue()) + "*";
        }
        if (yIndex == points.get(1).getY().getValue()) {
            return tripleSpace.repeat(points.get(1).getX().getValue()) + "*";
        }
        return nothing;
    }

    private String generateYAxis(int yIndex) {
        String yAxis = "ㅣ";
        StringBuilder result = new StringBuilder();
        if (yIndex % 2 == 1) {
            return DOUBLE_SPACE + yAxis;
        }
        if (yIndex < 10) {
            result.append(" ");
        }
        return result.append(yIndex).append(yAxis).toString();
    }

    private String printXAxis() {
        StringBuilder xAxis = new StringBuilder("   ");
        for(int i = 0; i <= COORDINATE_BOUNDARY; i += 2) {
            xAxis.append(i).append("     ");
        }
        return xAxis.toString();
    }

    public void printLength(double length) {
        System.out.println("두 점 사이 거리는  " + length);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message + "다시 입력하세요.");
    }
}

//ㅡ ㅡ
//