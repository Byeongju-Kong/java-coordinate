package view;

import model.point.Point;

import java.util.List;

public interface Display {
    void printCoordinate(List<Point> points);

    void printLength(double length);

    void printExceptionMessage(String message);
}
