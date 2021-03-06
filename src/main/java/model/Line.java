package model;

import model.point.Point;

import java.util.Arrays;
import java.util.List;

public class Line {
    private final Point firstPoint;
    private final Point secondPoint;

    private Line(String[] points) {
        firstPoint = Point.create(points[0]);
        secondPoint = Point.create(points[1]);
    }

    public static Line generate(String[] points) {
        return new Line(points);
    }

    public double getLength() {
        return Math.sqrt(Math.pow(firstPoint.getXDifference(secondPoint), 2)
                + Math.pow(firstPoint.getYDifference(secondPoint), 2));
    }

    public List<Point> getPoints() {
        return Arrays.asList(firstPoint, secondPoint);
    }
}
