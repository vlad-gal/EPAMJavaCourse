package by.halatsevich.practice1.task1;

import java.util.Scanner;

/**
 * This class allows to determine the last digit
 * of its square from the last digit of a number.
 *
 * @author Vladislav Halatsevich
 */


public class Num {

    /**
     * Determine the last digit of its square
     * from the last digit of a number.
     */
    public void lastNumber() {
        int num = readConsole() % 10;
        StringBuilder sb = new StringBuilder("The last digit of the square of this number: ");
        switch (num) {
            case 2:
                sb.append("4");
                break;
            case 3:
                sb.append("9");
                break;
            case 4:
                sb.append("6");
                break;
            case 7:
                sb.append("9");
                break;
            case 8:
                sb.append("4");
                break;
            case 9:
                sb.append("1");
                break;
            default:
                sb.append(num);
                break;
        }
        System.out.println(sb);
    }

    /**
     * Read from console
     *
     * @return number
     */
    private int readConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            scanner.close();
            throw new NumberFormatException("Not a number or not an integer");
        }
    }
}
