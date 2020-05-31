package by.halatsevich.practice1.task2;

import java.util.Scanner;

/**
 * This class determines a number of days in a month
 * with leap year verification
 *
 * @author Vladislav Halatsevich
 */

public class CountDay {

    /**
     * Number of days per month
     */
    public void daysInMonth() {
        int[] nums = readConsole();
        if (nums[1] <= 0 || nums[1] > 12) {
            throw new NumberFormatException("Number of month is less or equal 0 or more than 12");
        }
        boolean isLeap = isLeapYear(nums[0]);
        StringBuilder sb = new StringBuilder("Number of days per month: ");
        switch (nums[1]) {
            case 1:
                sb.append(Month.JANUARY.getDays());
                break;
            case 2:
                if (isLeap) {
                    sb.append(Month.FEBRUARYLeap.getDays());
                } else {
                    sb.append(Month.FEBRUARY.getDays());
                }
                break;
            case 3:
                sb.append(Month.MARCH.getDays());
                break;
            case 4:
                sb.append(Month.APRIL.getDays());
                break;
            case 5:
                sb.append(Month.MAY.getDays());
                break;
            case 6:
                sb.append(Month.JUNE.getDays());
                break;
            case 7:
                sb.append(Month.JULY.getDays());
                break;
            case 8:
                sb.append(Month.AUGUST.getDays());
                break;
            case 9:
                sb.append(Month.SEPTEMBER.getDays());
                break;
            case 10:
                sb.append(Month.OCTOBER.getDays());
                break;
            case 11:
                sb.append(Month.NOVEMBER.getDays());
                break;
            case 12:
                sb.append(Month.DECEMBER.getDays());
                break;
        }
        System.out.println(sb);
    }

    /**
     * Leap year check
     *
     * @param year the tested year
     * @return is leap year or not
     */
    private boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Read from console
     *
     * @return array with year and number of month
     */
    private int[] readConsole() {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[2];
        System.out.print("Enter year: ");
        if (scanner.hasNextInt()) {
            nums[0] = scanner.nextInt();
            System.out.print("Enter month number: ");
            nums[1] = scanner.nextInt();
            scanner.close();
        } else {
            scanner.close();
            throw new NumberFormatException("Not a number or not an integer");
        }
        return nums;
    }
}
