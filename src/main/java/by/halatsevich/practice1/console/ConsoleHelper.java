package by.halatsevich.practice1.console;

import by.halatsevich.practice1.entity.Point;

import java.util.Map;

/**
 * Simple console helper
 *
 * @author Vladislav Halatsevich
 */

public class ConsoleHelper {

    public String showLastDigit(int digit) {
        return String.format("The last digit of the square of this number: %d", digit);
    }

    public String showDaysInMonth(int days) {
        return String.format("Number of days per month: %d", days);
    }

    public String showAreaAndRatio(double... values) {
        return String.format("Area of the inscribed square is %.2f." +
                "\nArea ratio between specified and inscribed square is %.2f.", values[0], values[1]);
    }

    public String showTwoEven(boolean flag) {
        return String.format("Are there two even number? %s", flag);
    }

    public String showPerfectNumber(boolean flag) {
        return String.format("Is perfect number? %s", flag);
    }

    public String showFullTime(int... time) {
        return String.format("%d hours, %d minutes and %d seconds passed since the beginning of the day.",
                time[0], time[1], time[2]);
    }

    public String showNearestPoint(Point nearestPoint) {
        if (!nearestPoint.getName().equals("SAME")) {
            return String.format("%s is nearest point to plot origin", nearestPoint.getName());
        } else {
            return "Points in the same coordinates";
        }
    }

    public String showFx(double fx) {
        return String.format("Function value F(x) = %.2f", fx);
    }

    public String showSquareAndCircum(double square, double circumference) {
        return String.format("Circle square = %.2f.\nCircumference = %.2f.", square, circumference);
    }

    public String showTgx(Map<Double, Double> result) {
        StringBuilder sb = new StringBuilder();
        String tableCap = String.format("Result of the calculations:\n" +
                "========================\n" +
                "|%-10s||%-10s|\n" +
                "========================\n", "argument", "value");
        sb.append(tableCap);
        for (Map.Entry res : result.entrySet()) {
            String pair = String.format("|%-10.1f||%-10.3f|\n", res.getKey(), res.getValue());
            sb.append(pair);
        }
        sb.append("========================");
        return sb.toString();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
