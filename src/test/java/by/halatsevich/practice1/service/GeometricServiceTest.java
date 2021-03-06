package by.halatsevich.practice1.service;

import by.halatsevich.practice1.entity.Point;
import by.halatsevich.practice1.exception.ValidatorException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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
    public void testCalculateAreaAndRatioSuccess() {
        try {
            double[] actual = service.calculateAreaAndRatio(8);
            double[] expected = {4.0, 2.0};
            assertEquals(actual, expected, 0.0001);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test
    public void testCalculateAreaAndRatioFailure() {
        try {
            double[] actual = service.calculateAreaAndRatio(8);
            double[] expected = {3.0, 2.0};
            assertNotEquals(actual, expected);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "Specified square area is less than 0")
    public void testCalculateAreaAndRatioException() throws ValidatorException {
        service.calculateAreaAndRatio(-4);
    }

    @Test
    public void testNearestPointSuccess() {
        try {
            Point actual = service.nearestPoint(a, b);
            assertEquals(actual, a);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test
    public void testNearestPointFailure() {
        try {
            Point actual = service.nearestPoint(a, b);
            assertNotEquals(actual, b);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test
    public void testNearestPointSame() {
        try {
            b = new Point("B", 2, 43);
            Point actual = service.nearestPoint(a, b);
            Point expected = new Point("SAME", a.getX(), a.getY());
            assertEquals(actual, expected);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
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
    public void testCalculateCircleSquareSuccess() {
        try {
            double actual = service.calculateCircleSquare(4);
            double expected = 50.265;
            assertEquals(actual, expected, 0.001);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test
    public void testCalculateCircleSquareFailure() {
        try {
            double actual = service.calculateCircleSquare(4);
            double expected = 50;
            assertNotEquals(actual, expected, 0.001);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "Circle radius is less than 0")
    public void testCalculateCircleSquareExceptionMessage() throws ValidatorException {
        service.calculateCircleSquare(-465);
    }

    @Test
    public void testCalculateCircumferenceSuccess() {
        try {
            double actual = service.calculateCircumference(2);
            double expected = 12.566;
            assertEquals(actual, expected, 0.001);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test
    public void testCalculateCircumferenceFailure() {
        try {
            double actual = service.calculateCircumference(2);
            double expected = 123;
            assertNotEquals(actual, expected, 0.001);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "Circle radius is less than 0")
    public void testCalculateCircumferenceExceptionMessage() throws ValidatorException {
        service.calculateCircumference(-13);
    }

}