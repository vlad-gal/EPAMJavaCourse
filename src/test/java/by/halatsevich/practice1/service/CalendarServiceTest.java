package by.halatsevich.practice1.service;

import by.halatsevich.practice1.exception.ValidatorException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;


public class CalendarServiceTest {
    CalendarService service;

    @BeforeClass
    public void setUp() {
        service = new CalendarService();
    }

    @DataProvider(name = "date")
    public Object[][] createDate() {
        return new Object[][]{
                {0, 10, 31},
                {4000, 2, 29},
                {2019, 2, 28},
                {223, 4, 30}};
    }

    @Test(dataProvider = "date")
    public void testCountDaysInMonthSuccess(int year, int month, int expectedDays) throws ValidatorException {
        int actual = service.countDaysInMonth(year, month);
        assertEquals(actual, expectedDays);
    }

    @DataProvider(name = "invalidDate")
    public Object[][] createInvalidDate() {
        return new Object[][]{
                {4, 10, 30},
                {2501, 7, 249},
                {2020, 2, 64},
                {66, 3, 641}};
    }

    @Test(dataProvider = "invalidDate")
    public void testCountDaysInMonthFailure(int year, int month, int expectedDays) throws ValidatorException {
        int actual = service.countDaysInMonth(year, month);
        assertNotEquals(actual, expectedDays);
    }

    @DataProvider(name = "invalidMonth")
    public Object[][] createInvalidMonth() {
        return new Object[][]{
                {234, 121},
                {2000, 444},
                {42, 26},
                {445, 83}};
    }

    @Test(dataProvider = "invalidMonth", expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "Month number is not in the range from 1 to 12")
    public void testCountDaysInMonthExceptionMessageMonth(int year, int month) throws ValidatorException {
        service.countDaysInMonth(year, month);
    }

    @DataProvider(name = "invalidYear")
    public Object[][] createInvalidYear() {
        return new Object[][]{
                {-234, 11},
                {20001, 4},
                {42345, 1},
                {44685, 1}};
    }

    @Test(dataProvider = "invalidYear", expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "Year is not in the range from 0 to 4800")
    public void testCountDaysInMonthExceptionMessageYear(int year, int month) throws ValidatorException {
        service.countDaysInMonth(year, month);
    }

    @DataProvider(name = "seconds")
    public Object[][] createSeconds() {
        return new Object[][]{
                {new int[]{1, 34, 5}, 5645},
                {new int[]{8, 28, 59}, 30539},
                {new int[]{14, 5, 15}, 50715},
                {new int[]{23, 59, 59}, 86399}};
    }

    @Test(dataProvider = "seconds")
    public void testCountFullTimeSuccess(int[] expectedTime, int seconds) throws ValidatorException {
        int[] actual = service.countFullTime(seconds);
        assertEquals(actual, expectedTime);
    }

    @DataProvider(name = "invalidSeconds")
    public Object[][] createInvalidSeconds() {
        return new Object[][]{
                {new int[]{1, 34, 5}, 564},
                {new int[]{8, 28, 59}, 3539},
                {new int[]{14, 5, 15}, 715},
                {new int[]{23, 59, 59}, 6399}};
    }

    @Test(dataProvider = "invalidSeconds")
    public void testCountFullTimeFailure(int[] expectedTime, int seconds) throws ValidatorException {
        int[] actual = service.countFullTime(seconds);
        assertNotEquals(actual, expectedTime);
    }

    @Test(expectedExceptions = ValidatorException.class,
            expectedExceptionsMessageRegExp = "Seconds are not in the range from 0 to 86400")
    public void testCountFullTimeExceptionMessage() throws ValidatorException {
        service.countFullTime(764631);
    }
}
