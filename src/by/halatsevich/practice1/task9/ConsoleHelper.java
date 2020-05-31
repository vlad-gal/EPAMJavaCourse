package by.halatsevich.practice1.task9;

import java.util.Scanner;

/**
 * Simple console helper
 *
 * @author Vladislav Halatsevich
 */

public class ConsoleHelper {
    /**
     * Read x from console
     */
    public void readConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius: ");
        if (scanner.hasNextDouble()) {
            double radius = scanner.nextDouble();
            if (radius > 0) {
                Circle circle = new Circle(radius);
                System.out.printf("Circle square = %.2f\nCircumference = %.2f",
                        circle.getSquare(), circle.getCircumference());
            } else {
                scanner.close();
                throw new NumberFormatException("Negative number is not allow");
            }
        } else {
            scanner.close();
            throw new NumberFormatException("Not a number");
        }

    }
}
