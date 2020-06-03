package by.halatsevich.practice1.console;

import by.halatsevich.practice1.entity.Point;
import by.halatsevich.practice1.exception.ValidatorException;

import java.util.Map;

/**
 * Simple console helper
 *
 * @author vlad
 */

public class ConsoleHelper {

    public void showLastDigit(int digit) {
        System.out.printf("The last digit of the square of this number: %d%n", digit);
    }

    public void showDaysInMonth(int days) {
        System.out.printf("Number of days per month: %d%n", days);
    }

    public void showAreaAndRatio(double... values) {
        System.out.printf("Area of the inscribed square is %.2f. " +
                "%nArea ratio between specified and inscribed square is %.2f.%n", values[0], values[1]);
    }

    public void showTwoEven(boolean flag) {
        System.out.printf("Are there two even number? %s%n", flag);
    }

    public void showPerfectNumber(boolean flag) {
        System.out.printf("Is perfect number? %s%n", flag);
    }

    public void showFullTime(int... time) {
        System.out.printf("%d hours, %d minutes and %d seconds passed since the beginning of the day.%n",
                time[0], time[1], time[2]);
    }

    public void showNearestPoint(Point nearestPoint, Point a, Point b) {
        if (!nearestPoint.getName().equals(a.getName() + b.getName())) {
            System.out.printf("%s is nearest point to plot origin%n", nearestPoint.getName());
        } else {
            System.out.println("Points in the same coordinates");
        }
    }

    public void showFx(double fx) {
        System.out.printf("Function value F(x) = %.2f%n", fx);
    }

    public void showSquareAndCircum(double square, double circumference) {
        System.out.printf("Circle square = %.2f.%nCircumference = %.2f.%n",
                square, circumference);
    }

    public void showTgx(Map<Double, Double> result) {
        System.out.printf("Result of the calculation%n" +
                "========================%n" +
                "|%-10s||%-10s|%n" +
                "========================%n", "argument", "value");
        for (Map.Entry res : result.entrySet()) {
            System.out.printf("|%-10.1f||%-10.3f|%n", res.getKey(), res.getValue());
        }
        System.out.println("========================");
    }

    public void showValidation(boolean validation) throws ValidatorException {
        if (validation) {
            System.out.println("Validation successful");
        } else {
            throw new ValidatorException("Validation failed");
        }
    }
}
