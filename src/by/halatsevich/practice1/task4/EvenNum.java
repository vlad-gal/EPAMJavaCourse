package by.halatsevich.practice1.task4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Counts the number of even numbers
 *
 * @author Vladislav Halatsevich
 */
public class EvenNum {

    /**
     * Read numbers from console
     */
    public void readNums() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            System.out.printf("Enter %d number: ", i);
            if (scanner.hasNextInt()) {
                nums.add(scanner.nextInt());
            } else {
                scanner.close();
                throw new NumberFormatException("Not a number or not an integer");
            }
        }
        System.out.println(areTwoEven(nums));
    }

    /**
     * Check if even numbers more or equal 2
     *
     * @param ints array of integers
     * @return true if there are 2 or more even numbers, false if there are less
     * 2 even numbers
     */
    private boolean areTwoEven(ArrayList<Integer> ints) {
        int count = 0;
        for (int i : ints) {
            if (i % 2 == 0) {
                count++;
            }
        }
        return count >= 2;
    }
}
