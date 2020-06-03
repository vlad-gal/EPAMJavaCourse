package by.halatsevich.practice1.service;

import by.halatsevich.practice1.entity.Point;

/**
 * Geometric service for working with geometric entities
 * and characteristics
 *
 * @author vlad
 */

public class GeometricService {

    /**
     * Calculate inscribed square area and ratio
     * between specified and inscribed area square
     *
     * @param squareArea specified square area
     * @return array where 0 index - inscribed square area, 1 index - ratio
     */
    public double[] calculateAreaAndRatio(double squareArea) {
        double[] values = new double[2];
        double squareSide = Math.sqrt(squareArea);
        double radius = squareSide / 2;
        double inscribedSquareArea = 2 * Math.pow(radius, 2);
        double ratio = squareArea / inscribedSquareArea;
        values[0] = inscribedSquareArea;
        values[1] = ratio;
        return values;

    }

    /**
     * Calculate nearest point to plot origin
     *
     * @param pointA first point
     * @param pointB second point
     * @return nearest point to plot origin
     */
    public Point nearestPoint(Point pointA, Point pointB) {
        if (Math.hypot(pointA.getX(), pointA.getY())
                > Math.hypot(pointB.getX(), pointB.getY())) {
            return pointB;
        } else if ((Math.hypot(pointA.getX(), pointA.getY())
                < Math.hypot(pointB.getX(), pointB.getY()))) {
            return pointA;
        } else {
            return new Point(pointA.getName() + pointB.getName(), pointA.getX(), pointA.getY());
        }
    }

    /**
     * Calculate circle square
     *
     * @param radius of circle
     * @return circle square
     */
    public double calculateCircleSquare(double radius) {
        return (Math.PI * Math.pow(radius, 2));
    }

    /**
     * Calculate circle circumference
     *
     * @param radius of circle
     * @return circle circumference
     */
    public double calculateCircumference(double radius) {
        return (2 * Math.PI * radius);
    }


}
