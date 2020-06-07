package by.halatsevich.practice1.service;

import by.halatsevich.practice1.entity.Point;
import by.halatsevich.practice1.exception.ValidatorException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class GeometricServiceTest {
    GeometricService service;
    Point a;
    Point b;

    @BeforeMethod
    public void setUp() {
        service = new GeometricService();
        a = new Point("A", 2, 43);
        b = new Point("B", 54, -6);
    }

    @Test
    public void testCalculateAreaAndRatioSuccess() throws ValidatorException {
        double[] actual = service.calculateAreaAndRatio(8);
        double[] expected = {4.0, 2.0};
        assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void testCalculateAreaAndRatioFailure() throws ValidatorException {
        double[] actual = service.calculateAreaAndRatio(8);
        double[] expected = {3.0, 2.0};
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "Specified square area is less than 0")
    public void testCalculateAreaAndRatioException() throws ValidatorException {
        service.calculateAreaAndRatio(-4);
    }

    @Test
    public void testNearestPointSuccess() throws ValidatorException {
        Point expected = service.nearestPoint(a, b);
        assertEquals(a, expected);
    }

    @Test
    public void testNearestPointFailure() throws ValidatorException {
        Point expected = service.nearestPoint(a, b);
        assertNotEquals(b, expected);
    }

    @Test
    public void testNearestPointSame() throws ValidatorException {
        b = new Point("B", 2, 43);
        Point actual = new Point("SAME", a.getX(), a.getY());
        Point expected = service.nearestPoint(a, b);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "First point's coordinates are not in the range \\[-360;360\\]")
    public void testNearestPointExceptionMessageFirst() throws ValidatorException {
        a = new Point("A", 380, 2546);
        service.nearestPoint(a, b);
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "Second point's coordinates are not in the range \\[-360;360\\]")
    public void testNearestPointExceptionMessageSecond() throws ValidatorException {
        b = new Point("B", -380, 452);
        service.nearestPoint(a, b);
    }

    @Test
    public void testCalculateCircleSquareSuccess() throws ValidatorException {
        double actual = 50.265;
        double expected = service.calculateCircleSquare(4);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testCalculateCircleSquareFailure() throws ValidatorException {
        double actual = 50;
        double expected = service.calculateCircleSquare(4);
        assertNotEquals(actual, expected, 0.001);
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "Circle radius is less than 0")
    public void testCalculateCircleSquareExceptionMessage() throws ValidatorException {
        service.calculateCircleSquare(-465);
    }

    @Test
    public void testCalculateCircumferenceSuccess() throws ValidatorException {
        double actual = 12.566;
        double expected = service.calculateCircumference(2);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testCalculateCircumferenceFailure() throws ValidatorException {
        double actual = 123;
        double expected = service.calculateCircumference(2);
        assertNotEquals(actual, expected, 0.001);
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "Circle radius is less than 0")
    public void testCalculateCircumferenceExceptionMessage() throws ValidatorException {
        service.calculateCircumference(-13);
    }

}