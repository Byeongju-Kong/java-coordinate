package controller;

import model.shape.Line;
import model.dto.InputDTO;
import view.Display;

import java.util.Scanner;

public class CoordinateController {
    private final Line line;
    private final Display display;
    private final Scanner scanner;
    private final InputDTO inputDTO;
    private boolean wrongInput = true;

    private CoordinateController(Scanner scanner, Display display) {
        this.scanner = scanner;
        this.display = display;
        inputDTO = new InputDTO();
        line = Line.generate(inputLine());
    }

    public static CoordinateController generate(Scanner scanner, Display display) {
        return new CoordinateController(scanner, display);
    }

    private String[] inputLine() {
        String[] points = new String[2];
        while (wrongInput) {
            points = inputPoints();
        }
        return points;
    }

    private String[] inputPoints() {
        String[] points = new String[2];
        try {
            points = inputDTO.splitTwoPoints(scanner.nextLine());
            wrongInput = false;
        } catch (IllegalArgumentException exception) {
            display.printExceptionMessage(exception.getMessage());
        }
        return points;
    }

    public void run() {
        display.printCoordinate(line.getPoints());
        display.printLength(line.getLength());
    }
}
