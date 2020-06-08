package by.halatsevich.practice1.service;

import by.halatsevich.practice1.exception.ValidatorException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class MathServiceTest {
    MathService service;

    @BeforeClass
    public void setUp() {
        service = new MathService();
    }

    @Test
    public void testLastSquareDigitSuccess() {
        try {
            int actual = 6;
            int expected = service.lastSquareDigit(4);
            assertEquals(actual, expected);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test
    public void testLastSquareDigitFailure() {
        try {
            int actual = 6;
            int expected = service.lastSquareDigit(13);
            assertNotEquals(actual, expected);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "The number is not in the range \\[-400;400\\]")
    public void testLastSquareDigitExceptionMessage() throws ValidatorException {
        service.lastSquareDigit(-7000);
    }

    @Test
    public void testAreTwoEvenNumbersSuccess() {
        try {
            boolean condition = service.areTwoEvenNumbers(4, 3, 1, 2);
            assertTrue(condition);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test
    public void testAreTwoEvenNumbersFailure() {
        try {
            boolean condition = service.areTwoEvenNumbers(4, 3, 1, 1);
            assertFalse(condition);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "The number of values differs from 4")
    public void testAreTwoEvenNumbersExceptionMessage() throws ValidatorException {
        service.areTwoEvenNumbers(4, 3, 1, 2, 85);
    }

    @Test
    public void testIsPerfectNumberSuccess() {
        try {
            boolean condition = service.isPerfectNumber(6);
            assertTrue(condition);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test
    public void testIsPerfectNumberFailure() {
        try {
            boolean condition = service.isPerfectNumber(342);
            assertFalse(condition);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "The number is less than 0")
    public void testIsPerfectNumberExceptionMessage() throws ValidatorException {
        service.isPerfectNumber(-13);
    }

    @DataProvider(name = "valuesForFx")
    public Object[][] createDataForFx() {
        return new Object[][]{
                {1, -0.2},
                {3, 9},
                {8, -31}
        };
    }

    @Test(dataProvider = "valuesForFx")
    public void testCalculateFxSuccess(double value, double actual) {
        try {
            double expected = service.calculateFx(value);
            assertEquals(actual, expected, 0.001);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @DataProvider(name = "invalidValuesForFx")
    public Object[][] createInvalidDataForFx() {
        return new Object[][]{
                {1, 1},
                {3, 1},
                {8, 1}
        };
    }

    @Test(dataProvider = "invalidValuesForFx")
    public void testCalculateFxFailure(double value, double actual) {
        try {
            double expected = service.calculateFx(value);
            assertNotEquals(actual, expected, 0.001);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "X is not in the range \\[-400;400\\]")
    public void testCalculateFxExceptionMessage() throws ValidatorException {
        service.calculateFx(-4000);
    }

    @Test
    public void testCalculateTgxSuccess() {
        try {
            Map<Double, Double> actual = new LinkedHashMap<>();
            actual.put(70.0, 2.7474774194546216);
            actual.put(80.0, 5.671281819617707);
            actual.put(90.0, Double.POSITIVE_INFINITY);
            actual.put(93.0, -19.081136687728208);
            Map<Double, Double> expected = service.calculateTgx(70, 93, 10);
            assertEqualsDeep(actual, expected);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test
    public void testCalculateTgxFailure() {
        try {
            Map<Double, Double> actual = new LinkedHashMap<>();
            actual.put(70.0, 2.1);
            actual.put(80.0, 5.7);
            actual.put(90.0, 1.1);
            actual.put(100.0, -5.6);
            Map<Double, Double> expected = service.calculateTgx(70, 100, 10);
            assertNotEqualsDeep(actual, expected);
        } catch (ValidatorException e) {
            fail("Something went wrong");
        }
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "Finish border <= start border")
    public void testCalculateTgxBorderExceptionMessage() throws ValidatorException {
        service.calculateTgx(90, -100, 10);
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "Borders are not in the range \\[-360;360\\]")
    public void testCalculateTgxBorderRangeExceptionMessage() throws ValidatorException {
        service.calculateTgx(-9000, -100, 10);
    }

}