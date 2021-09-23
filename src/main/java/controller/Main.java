package controller;

import view.LineDisplay;
import view.Display;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Display display = new LineDisplay();
        CoordinateController coordinateController = CoordinateController.generate(scanner, display);
        coordinateController.run();
    }
}
