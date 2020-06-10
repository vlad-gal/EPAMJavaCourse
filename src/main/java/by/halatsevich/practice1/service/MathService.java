package by.halatsevich.practice1.service;

import by.halatsevich.practice1.exception.ValidatorException;
import by.halatsevich.practice1.validator.ArithmeticValidator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Mathematics service for working with
 * mathematical calculations
 *
 * @author Vladislav Halatsevich
 */
public class MathService {

    /**
     * Determine the last digit of its square
     * from the last digit of a number.
     *
     * @param number for finding last square digit
     * @return last digit squared number
     */
    public int lastSquareDigit(int number) throws ValidatorException {
        if (!ArithmeticValidator.isValidNumber(number)) {
            throw new ValidatorException("The number is not in the range [-400;400]");
        }
        return (int) (Math.pow(number % 10, 2) % 10);
    }

    /**
     * Check if even numbers more or equal 2
     *
     * @param numbers array of numbers
     * @return true if there are 2 or more even numbers,
     * false if there are less
     */
    public boolean areTwoEvenNumbers(int... numbers) throws ValidatorException {
        if (!ArithmeticValidator.isRightCountOfNumber(numbers)) {
            throw new ValidatorException("The number of values differs from 4");
        }
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                count++;
            }
        }
        return (count >= 2);
    }

    /**
     * Check perfect number
     *
     * @param number for checking
     * @return true if entered number is perfect, false if not
     */
    public boolean isPerfectNumber(int number) throws ValidatorException {
        if (number <= 0) {
            throw new ValidatorException("The number is less than 0");
        }
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return (sum == number);
    }

    /**
     * Calculate function
     *
     * @param x value
     * @return calculation result
     */
    public double calculateFx(double x) throws ValidatorException {
        if (!ArithmeticValidator.isValidNumber(x)) {
            throw new ValidatorException("X is not in the range [-400;400]");
        }
        return (x >= 3) ? (-Math.pow(x, 2) + 3 * x + 9) : (1 / (Math.pow(x, 3) - 6));
    }

    /**
     * Calculate values tg(x)
     *
     * @param startBorder  start border for values
     * @param finishBorder finish border for values
     * @param step         values
     * @return Map where key - argument, value - value of function
     */
    public Map<Double, Double> calculateTgx(double startBorder, double finishBorder, double step) throws ValidatorException {
        if (!ArithmeticValidator.checkCorrectBorders(startBorder, finishBorder)) {
            throw new ValidatorException("Finish border <= start border");
        }
        if (!ArithmeticValidator.checkCorrectRange(startBorder, finishBorder)) {
            throw new ValidatorException("Borders are not in the range [-360;360]");
        }
        List<Double> infinities = countInfOnSegment(startBorder, finishBorder);
        LinkedHashMap<Double, Double> result = new LinkedHashMap<>();
        double argument = startBorder;
        double value;
        while (argument <= finishBorder) {
            value = Math.tan(Math.toRadians(argument));
            if (!infinities.contains(argument)) {
                result.put(argument, value);
            } else {
                result.put(argument, Double.POSITIVE_INFINITY);
            }
            if (finishBorder > argument && finishBorder < argument + step) {
                value = Math.tan(Math.toRadians(finishBorder));
                result.put(finishBorder, value);
            }
            argument += step;
        }
        return result;
    }

    /**
     * Calculate infinities on section
     *
     * @param startBorder  start border for values
     * @param finishBorder finish border for values
     * @return list of infinities
     */
    private List<Double> countInfOnSegment(double startBorder, double finishBorder) {
        List<Double> infinities = new ArrayList<>();
        int count = 0;
        while (finishBorder >= 90 + 180 * count) {
            infinities.add((double) (90 + 180 * count));
            count++;
        }
        count = 0;
        while (startBorder <= -90 - 180 * count) {
            infinities.add((double) (-90 - 180 * count));
            count++;
        }
        return infinities;
    }
}
