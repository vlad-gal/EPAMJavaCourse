package by.halatsevich.practice1.console;

import by.halatsevich.practice1.entity.Point;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ConsoleHelperTest {
    ConsoleHelper helper;
    Point a;
    Point b;
    Point sameCoordinates;
    Map<Double, Double> resultTgx;

    @BeforeClass
    public void setUp() {
        helper = new ConsoleHelper();
        a = new Point("A", 12, 3);
        b = new Point("B", 55, 78);
        sameCoordinates = new Point("SAME", 12, 3);
        resultTgx = new LinkedHashMap<>();
        resultTgx.put(10.0, 0.176);
    }

    @Test
    public void testShowLastDigitSuccess() {
        String actual = helper.showLastDigit(1);
        String expected = "The last digit of the square of this number: 1";
        assertEquals(actual, expected);
    }

    @Test
    public void testShowLastDigitFailure() {
        String actual = helper.showLastDigit(123);
        String expected = "The last digit of the square of this number: 23";
        assertNotEquals(actual, expected);
    }

    @Test
    public void testShowDaysInMonthSuccess() {
        String actual = helper.showDaysInMonth(23);
        String expected = "Number of days per month: 23";
        assertEquals(actual, expected);
    }

    @Test
    public void testShowDaysInMonthFailure() {
        String actual = helper.showDaysInMonth(23);
        String expected = "Number of days per month: 32";
        assertNotEquals(actual, expected);
    }

    @Test
    public void testShowAreaAndRatioSuccess() {
        String actual = helper.showAreaAndRatio(1.2, 2);
        String expected = "Area of the inscribed square is 1,20." +
                "\nArea ratio between specified and inscribed square is 2,00.";
        assertEquals(actual, expected);
    }

    @Test
    public void testShowAreaAndRatioFailure() {
        String actual = helper.showAreaAndRatio(12, 200);
        String expected = "Area of the inscribed square is 12." +
                "\nArea ratio between specified and inscribed square is 200.";
        assertNotEquals(actual, expected);
    }

    @Test
    public void testShowTwoEvenSuccess() {
        String actual = helper.showTwoEven(true);
        String expected = "Are there two even number? true";
        assertEquals(actual, expected);
    }

    @Test
    public void testShowTwoEvenFailure() {
        String actual = helper.showTwoEven(true);
        String expected = "Are there two even number? false";
        assertNotEquals(actual, expected);
    }

    @Test
    public void testShowPerfectNumberSuccess() {
        String actual = helper.showPerfectNumber(true);
        String expected = "Is perfect number? true";
        assertEquals(actual, expected);
    }

    @Test
    public void testShowPerfectNumberFailure() {
        String actual = helper.showPerfectNumber(true);
        String expected = "Is perfect number? false";
        assertNotEquals(actual, expected);
    }

    @Test
    public void testShowFullTimeSuccess() {
        String actual = helper.showFullTime(4, 25, 7);
        String expected = "4 hours, 25 minutes and 7 seconds passed since the beginning of the day.";
        assertEquals(actual, expected);
    }

    @Test
    public void testShowFullTimeFailure() {
        String actual = helper.showFullTime(4, 25, 7);
        String expected = "6 hours, 32 minutes and 17 seconds passed since the beginning of the day.";
        assertNotEquals(actual, expected);
    }

    @Test
    public void testShowNearestPointSuccess() {
        String actual = helper.showNearestPoint(a);
        String expected = "A is nearest point to plot origin";
        assertEquals(actual, expected);
    }

    @Test
    public void testShowNearestPointFailure() {
        String actual = helper.showNearestPoint(b);
        String expected = "A is nearest point to plot origin";
        assertNotEquals(actual, expected);
    }

    @Test
    public void testShowNearestPointAtSameCoordinatesSuccess() {
        String actual = helper.showNearestPoint(sameCoordinates);
        String expected = "Points in the same coordinates";
        assertEquals(actual, expected);
    }

    @Test
    public void testShowNearestPointAtSameCoordinatesFailure() {
        String actual = helper.showNearestPoint(a);
        String expected = "Points in the same coordinates";
        assertNotEquals(actual, expected);
    }

    @Test
    public void testShowFxSuccess() {
        String actual = helper.showFx(2);
        String expected = "Function value F(x) = 2,00";
        assertEquals(actual, expected);
    }

    @Test
    public void testShowFxFailure() {
        String actual = helper.showFx(2);
        String expected = "Function value F(x) = 2";
        assertNotEquals(actual, expected);
    }

    @Test
    public void testShowSquareAndCircumSuccess() {
        String actual = helper.showSquareAndCircum(2, 3);
        String expected = "Circle square = 2,00.\nCircumference = 3,00.";
        assertEquals(actual, expected);
    }

    @Test
    public void testShowSquareAndCircumFailure() {
        String actual = helper.showSquareAndCircum(2, 3);
        String expected = "Circle square = 2.\nCircumference = 3.";
        assertNotEquals(actual, expected);
    }

    @Test
    public void testShowTgxSuccess() {
        String actual = helper.showTgx(resultTgx);
        String expected = String.format("Result of the calculations:\n" +
                "========================\n" +
                "|%-10s||%-10s|\n" +
                "========================\n" +
                "|%-10.1f||%-10.3f|\n" +
                "========================", "argument", "value", 10.0, 0.176);
        assertEquals(actual, expected);
    }

    @Test
    public void testShowTgxFailure() {
        String actual = helper.showTgx(resultTgx);
        String expected = String.format("Result of the calculations:\n" +
                "========================\n" +
                "|%-10s||%-10s|\n" +
                "========================\n" +
                "|%-10.1f||%-10.3f|\n" +
                "========================", "argument", "value", 132.2, 0.17600);
        assertNotEquals(actual, expected);
    }
}
