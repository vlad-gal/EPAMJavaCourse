package by.halatsevich.practice1.task10;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Provides calculate function value
 *
 * @author Vladislav Halatsevich
 */

public class Calculate {

    /**
     * Read bounds and step from console
     */
    public void readParameters() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter start bound: ");
        if (scanner.hasNextDouble()) {
            double start = scanner.nextDouble();
            System.out.print("Enter finish bound: ");
            double finish = scanner.nextDouble();
            System.out.print("Enter step: ");
            double step = scanner.nextDouble();
            System.out.println("Result of the calculation");
            System.out.printf("|%-10s||%-10s|", "argument", "value");
            System.out.print("\n========================");
            function(start, finish, step);
        } else {
            scanner.close();
            throw new NumberFormatException("Not a number");
        }
    }

    /**
     * Calculate values tg(x)
     *
     * @param start  starting bound of values
     * @param finish finishing bound of values
     * @param step   of values
     */
    private void function(double start, double finish, double step) {
        int n = 0;
        ArrayList<Double> inf = new ArrayList<>();
        while (finish >= 90 + 180 * n) {
            inf.add((double) (90 + 180 * n));
            n++;
        }
        while (start <= finish) {
            double value = Math.tan(Math.toRadians(start));
            if (!inf.contains(start)) {
                System.out.printf("\n|%-10.1f||%-10.3f|", start, value);
            } else {
                System.out.printf("\n|%-10.1f||%-10s|", start, "INF");
            }
            if (finish > start && finish < start + step) {
                System.out.printf("\n|%-10.1f||%-10.3f|", finish, value);
            }
            start += step;
        }
        System.out.print("\n========================");
    }
}
