package controller;

import view.CoordinateDisplay;
import view.Display;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Display display = new CoordinateDisplay();
        CoordinateController coordinateController = CoordinateController.generate(scanner, display);
        coordinateController.run();
    }
}
