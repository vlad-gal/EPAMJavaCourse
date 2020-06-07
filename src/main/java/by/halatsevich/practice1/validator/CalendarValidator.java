package by.halatsevich.practice1.validator;

/**
 * Validator for calendar data validation checks
 *
 * @author Vladislav Halatsevich
 */
public class CalendarValidator {
    private static final int FIRST_MONTH = 1;
    private static final int LAST_MONTH = 12;
    private static final int MIN_YEAR = 0;
    private static final int MAX_YEAR = 4800;
    private static final int MIN_SECONDS_IN_DAY = 0;
    private static final int MAX_SECONDS_IN_DAY = 86400;

    public static boolean isValidMonth(int month) {
        return (month >= FIRST_MONTH && month <= LAST_MONTH);
    }

    public static boolean isValidYear(int year) {
        return (year >= MIN_YEAR && year <= MAX_YEAR);
    }

    public static boolean isValidSeconds(int seconds) {
        return (seconds >= MIN_SECONDS_IN_DAY && seconds <= MAX_SECONDS_IN_DAY);
    }
}
