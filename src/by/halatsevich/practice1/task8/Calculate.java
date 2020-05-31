package by.halatsevich.practice1.task8;

import java.util.Scanner;

/**
 * Provides calculate function value
 *
 * @author Vladislav Halatsevich
 */

public class Calculate {

    /**
     * Read x from console
     */
    public void readX() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x: ");
        if (scanner.hasNextDouble()) {
            double x = scanner.nextDouble();
            System.out.print("Function value F(x) = " + function(x));
        } else {
            scanner.close();
            throw new NumberFormatException("Not a number");
        }
    }

    /**
     * Calculate functions
     *
     * @param x value
     * @return calculation result
     */
    private double function(double x) {
        double result;
        if (x >= 3) {
            result = -(x * x) + 3 * x + 9;
        } else {
            result = 1 / (Math.pow(x, 3) - 6);
        }
        return result;
    }
}
