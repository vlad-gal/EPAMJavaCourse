package by.halatsevich.practice1.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CalendarValidatorTest {

    @Test
    public void testIsValidMonthSuccess() {
        boolean condition = CalendarValidator.isValidMonth(1);
        assertTrue(condition);
    }

    @Test
    public void testIsValidMonthFailure() {
        boolean condition = CalendarValidator.isValidMonth(-1);
        assertFalse(condition);
    }

    @Test
    public void testIsValidYearSuccess() {
        boolean condition = CalendarValidator.isValidYear(450);
        assertTrue(condition);
    }

    @Test
    public void testIsValidYearFailure() {
        boolean condition = CalendarValidator.isValidYear(8000);
        assertFalse(condition);
    }

    @Test
    public void testIsValidSecondsSuccess() {
        boolean condition = CalendarValidator.isValidSeconds(54600);
        assertTrue(condition);
    }

    @Test
    public void testIsValidSecondsFailure() {
        boolean condition = CalendarValidator.isValidYear(9000000);
        assertFalse(condition);
    }
}
