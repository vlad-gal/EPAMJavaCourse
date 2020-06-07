package by.halatsevich.practice1.validator;

import by.halatsevich.practice1.entity.Point;

/**
 * Validator for arithmetic data validation checks
 *
 * @author Vladislav Halatsevich
 */
public class ArithmeticValidator {
    private static final int COUNT_OF_NUMBER = 4;
    private static final int MIN_VALUE = -400;
    private static final int MAX_VALUE = 400;
    private static final int MIN_RANGE = -360;
    private static final int MAX_RANGE = 360;

    public static boolean isValidNumber(double number) {
        return (number >= MIN_VALUE && number <= MAX_VALUE);
    }

    public static boolean isRightCountOfNumber(int... numbers) {
        return (numbers.length == COUNT_OF_NUMBER);
    }

    public static boolean checkCorrectBorders(double startBorder, double finishBorder) {
        return (finishBorder > startBorder);
    }

    public static boolean checkCorrectRange(double startBorder, double finishBorder) {
        return (startBorder >= MIN_RANGE && finishBorder <= MAX_RANGE);
    }

    public static boolean isValidPoint(Point point) {
        return ((point.getX() >= MIN_RANGE && point.getX() <= MAX_RANGE)
                && (point.getY() >= MIN_RANGE && point.getY() <= MAX_RANGE));
    }

}
