package by.halatsevich.practice1.task5;

import java.util.Scanner;

/**
 * This class check if the entered number is perfect
 *
 * @author Vladislav Halatsevich
 */

public class PerfectNumber {

    /**
     * Read number from console
     */
    public void readNums() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter a positive integer: ");
        if (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            if (i < 0) {
                scanner.close();
                throw new NumberFormatException("Not a positive integer");
            } else {
                System.out.println(isPerfect(i));
            }
        } else {
            scanner.close();
            throw new NumberFormatException("Not a number or not an integer");
        }

    }

    /**
     * Check if the number is perfect
     *
     * @param num for checking
     * @return true if entered number is perfect, false if not
     */
    private boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }
}
