package by.halatsevich.practice1.task6;

import java.util.Scanner;

/**
 * This class determines how many full hours, minutes and seconds
 * have passed to this moment
 *
 * @author Vladislav Halatsevich
 */
public class Time {

    /**
     * Read seconds from console
     */
    public void readTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a seconds:");
        if (scanner.hasNextInt()) {
            int seconds = scanner.nextInt();
            if (seconds >= 0 && seconds <= 86400) {
                int[] time = fullTime(seconds);
                System.out.printf("%d hours, %d minutes and %d seconds passed since the beginning of the day",
                        time[0], time[1], time[2]);
            } else {
                scanner.close();
                throw new NumberFormatException("Entered seconds is less 0 or more that 86400");
            }
        } else {
            scanner.close();
            throw new NumberFormatException("Entered seconds is not an integer");
        }
    }

    /**
     * Count full hours, minutes and seconds
     * have passed to this moment
     *
     * @param seconds current second
     * @return array where 0 index - hour, 1 index - minute, 2 index - seconds
     */
    private int[] fullTime(int seconds) {
        int[] time = new int[3];
        time[0] = (int) Math.floor(seconds / 3600);
        time[1] = (int) Math.floor((seconds % 3600) / 60);
        time[2] = (int) Math.floor((seconds % 3600) % 60);
        return time;
    }
}
