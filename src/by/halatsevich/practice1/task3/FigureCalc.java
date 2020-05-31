package by.halatsevich.practice1.task3;

import java.util.Scanner;

/**
 * It determines an inscribed square area and
 * ratio between specified and inscribed area square
 *
 * @author Vladislav Halatsevich
 */

public class FigureCalc {

    /**
     * Calculate inscribed square area and ratio
     * between specified and inscribed area square
     */
    public void calculate() {
        double square = readConsole();
        double side = Math.sqrt(square);
        double radius = side / 2;
        double insSquare = 2 * Math.pow(radius, 2);
        double ratio = square / insSquare;
        System.out.printf("Area of the inscribed square is %.2f. " +
                "\nArea ratio between specified and inscribed square is %.2f.", insSquare, ratio);
    }

    /**
     * Read from console
     *
     * @return specified square area
     */
    private double readConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the square area: ");
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            scanner.close();
            throw new NumberFormatException("Not a number or not a double");
        }
    }
}
