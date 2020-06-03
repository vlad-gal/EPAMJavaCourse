package by.halatsevich.practice1.service;

import by.halatsevich.practice1.entity.Month;

/**
 * Calendar service for working with date
 *
 * @author vlad
 */

public class CalendarService {

    /**
     * Count days in month
     *
     * @param year  check year
     * @param month check month in year
     * @return number of days in month
     */

    public int countDaysInMonth(int year, int month) {
        if (isLeapYear(year)) {
            if (month == (Month.FEBRUARY.ordinal() + 1)) {
                return (Month.values()[month - 1].getDays() + 1);
            } else {
                return (Month.values()[month - 1].getDays());
            }
        } else {
            return (Month.values()[month - 1].getDays());
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
    public int[] countFullTime(int seconds) {
        int[] fullTime = new int[3];
        int hour = (int) Math.floor(seconds / 3600);
        int minute = (int) Math.floor((seconds % 3600) / 60);
        int second = (int) Math.floor((seconds % 3600) % 60);
        fullTime[0] = hour;
        fullTime[1] = minute;
        fullTime[2] = second;
        return fullTime;
    }
}
