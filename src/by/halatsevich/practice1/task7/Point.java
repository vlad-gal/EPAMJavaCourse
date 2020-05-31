package by.halatsevich.practice1.task7;

/**
 * This class describes a simple point with
 * two coordinates
 *
 * @author Vladislav Halatsevich
 */

public class Point {
    private double x;
    private double y;
    private String name;

    public Point(String name,double x, double y) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }
}
