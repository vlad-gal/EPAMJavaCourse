package by.halatsevich.practice1.validator;

import by.halatsevich.practice1.entity.Point;

/**
 * Validator for arithmetic data validation checks
 *
 * @author vlad
 */
public class ArithmeticValidator {
    private static final int COUNT_OF_NUMBER = 4;
    private static final int MIN_VALUE = -400;
    private static final int MAX_VALUE = 400;
    private static final int MIN_RANGE = -360;
    private static final int MAX_RANGE = 360;

    public boolean isValidNumber(int number) {
        return (number >= MIN_VALUE && number <= MAX_VALUE);
    }

    public boolean isValidNumber(double number) {
        return (number >= MIN_VALUE && number <= MAX_VALUE);
    }

    public boolean isRightCountOfNumber(int... numbers) {
        return (numbers.length == COUNT_OF_NUMBER);
    }

    public boolean isPositiveIntValue(int value) {
        return (value > 0);
    }

    public boolean isPositiveDoubleValue(double value) {
        return (value > 0);
    }

    public boolean checkCorrectBorders(double startBorder, double finishBorder) {
        return (finishBorder > startBorder);
    }

    public boolean checkCorrectRange(double startBorder, double finishBorder) {
        return (startBorder >= MIN_RANGE && finishBorder <= MAX_RANGE);
    }

    public boolean isValidPoint(Point point) {
        return ((point.getX() >= MIN_RANGE && point.getX() <= MAX_RANGE)
                && (point.getY() >= MIN_RANGE && point.getY() <= MAX_RANGE));
    }

}
