package by.halatsevich.practice1.service;

import by.halatsevich.practice1.entity.Month;
import by.halatsevich.practice1.exception.ValidatorException;
import by.halatsevich.practice1.validator.CalendarValidator;

/**
 * Calendar service for working with date
 *
 * @author Vladislav Halatsevich
 */

public class CalendarService {

    /**
     * Count days in month
     *
     * @param year  check year
     * @param month check month in year
     * @return number of days in month
     */
    public int countDaysInMonth(int year, int month) throws ValidatorException {
        if (CalendarValidator.isValidYear(year)) {
            if (CalendarValidator.isValidMonth(month)) {
                if (isLeapYear(year)) {
                    if (month == (Month.FEBRUARY.ordinal() + 1)) {
                        return (Month.values()[month - 1].getDays() + 1);
                    } else {
                        return (Month.values()[month - 1].getDays());
                    }
                } else {
                    return (Month.values()[month - 1].getDays());
                }
            } else {
                throw new ValidatorException("Month number is not in the range from 1 to 12");
            }
        } else {
            throw new ValidatorException("Year is not in the range from 0 to 4800");
        }
    }

    /**
     * Leap year check
     *
     * @param year check year
     * @return is leap year or not
     */
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

    /**
     * Count full hours, minutes and seconds
     * have passed to this moment
     *
     * @param seconds current second
     * @return array where 0 index - hour, 1 index - minute, 2 index - seconds
     */
    public int[] countFullTime(int seconds) throws ValidatorException {
        if (CalendarValidator.isValidSeconds(seconds)) {
            int[] fullTime = new int[3];
            int hour = (int) Math.floor(seconds / 3600);
            int minute = (int) Math.floor((seconds % 3600) / 60);
            int second = (int) Math.floor((seconds % 3600) % 60);
            fullTime[0] = hour;
            fullTime[1] = minute;
            fullTime[2] = second;
            return fullTime;
        } else {
            throw new ValidatorException("Seconds are not in the range from 0 to 86400");
        }
    }
}
