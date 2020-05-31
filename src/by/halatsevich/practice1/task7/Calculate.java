package by.halatsevich.practice1.task7;

import java.util.Scanner;

/**
 * This class calculate closest point to plot origin
 *
 * @author Vladislav Halatsevich
 */
public class Calculate {

    /**
     * Read coordinates from console
     */
    public void readPoint() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter coordinates of point A(x1,y1):\nx1 = ");
        if (scanner.hasNextDouble()) {
            double x1 = scanner.nextDouble();
            System.out.print("y1 = ");
            double y1 = scanner.nextDouble();
            Point a = new Point("A", x1, y1);
            System.out.print("Enter coordinates of point B(x2,y2):\nx2 = ");
            double x2 = scanner.nextDouble();
            System.out.print("y2 = ");
            double y2 = scanner.nextDouble();
            Point b = new Point("B", x2, y2);
            closestPoint(a, b);
        } else {
            scanner.close();
            throw new NumberFormatException("Entered coordinates are not numbers");
        }
    }

    /**
     * Calculates closest point to plot origin
     *
     * @param a first point
     * @param b second point
     */
    private void closestPoint(Point a, Point b) {
        if ((a.getX() * a.getX() + a.getY() * a.getY())
                > (b.getX() * b.getX() + b.getY() * b.getY())) {
            System.out.printf("%s is closest point", b.getName());
        } else if ((a.getX() * a.getX() + a.getY() * a.getY())
                < (b.getX() * b.getX() + b.getY() * b.getY())) {
            System.out.printf("%s is closest point", a.getName());
        } else {
            System.out.print("Points in the same coordinates");
        }
    }
}
