package by.halatsevich.practice1.service;

import by.halatsevich.practice1.entity.Point;
import by.halatsevich.practice1.exception.ValidatorException;
import by.halatsevich.practice1.validator.ArithmeticValidator;

/**
 * Geometric service for working with geometric entities
 * and characteristics
 *
 * @author Vladislav Halatsevich
 */

public class GeometricService {

    /**
     * Calculate inscribed square area and ratio
     * between specified and inscribed area square
     *
     * @param squareArea specified square area
     * @return array where 0 index - inscribed square area, 1 index - ratio
     */
    public double[] calculateAreaAndRatio(double squareArea) throws ValidatorException {
        if (squareArea <= 0) {
            throw new ValidatorException("Specified square area is less than 0");
        }
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
    public Point nearestPoint(Point pointA, Point pointB) throws ValidatorException {
        if (!ArithmeticValidator.isValidPoint(pointA)) {
            throw new ValidatorException("First point's coordinates are not in the range [-360;360]");
        }
        if (!ArithmeticValidator.isValidPoint(pointB)) {
            throw new ValidatorException("Second point's coordinates are not in the range [-360;360]");
        }
        if (Math.hypot(pointA.getX(), pointA.getY())
                > Math.hypot(pointB.getX(), pointB.getY())) {
            return pointB;
        } else if ((Math.hypot(pointA.getX(), pointA.getY())
                < Math.hypot(pointB.getX(), pointB.getY()))) {
            return pointA;
        } else {
            return new Point("SAME", pointA.getX(), pointA.getY());
        }
    }

    /**
     * Calculate circle square
     *
     * @param radius of circle
     * @return circle square
     */
    public double calculateCircleSquare(double radius) throws ValidatorException {
        if (radius <= 0) {
            throw new ValidatorException("Circle radius is less than 0");
        }
        return (Math.PI * Math.pow(radius, 2));
    }

    /**
     * Calculate circle circumference
     *
     * @param radius of circle
     * @return circle circumference
     */
    public double calculateCircumference(double radius) throws ValidatorException {
        if (radius <= 0) {
            throw new ValidatorException("Circle radius is less than 0");
        }
        return (2 * Math.PI * radius);
    }
}
