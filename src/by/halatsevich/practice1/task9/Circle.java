package by.halatsevich.practice1.task9;

/**
 * Geometric figure with properties
 *
 * @author Vladislav Halatsevich
 */

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getSquare() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public double getCircumference() {
        return 2 * Math.PI * getRadius();
    }
}
