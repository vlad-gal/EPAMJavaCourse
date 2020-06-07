package by.halatsevich.practice1.validator;

import by.halatsevich.practice1.entity.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArithmeticValidatorTest {
    Point validPoint;
    Point invalidPoint;

    @BeforeClass
    public void setUp() {
        validPoint = new Point("1", 50, 78);
        invalidPoint = new Point("1", -8987, 234);
    }

    @Test
    public void testIsValidNumberSuccess() {
        boolean condition = ArithmeticValidator.isValidNumber(50);
        Assert.assertTrue(condition);
    }

    @Test
    public void testIsValidNumberFailure() {
        boolean condition = ArithmeticValidator.isValidNumber(-46510);
        Assert.assertFalse(condition);
    }

    @Test
    public void testIsRightCountOfNumberSuccess() {
        boolean condition = ArithmeticValidator.isRightCountOfNumber(4, 12, 45, 8);
        Assert.assertTrue(condition);
    }

    @Test
    public void testIsRightCountOfNumberFailure() {
        boolean condition = ArithmeticValidator.isRightCountOfNumber(26578, 6, 3);
        Assert.assertFalse(condition);
    }

    @Test
    public void testCheckCorrectBordersSuccess() {
        boolean condition = ArithmeticValidator.checkCorrectBorders(4, 5);
        Assert.assertTrue(condition);
    }

    @Test
    public void testCheckCorrectBordersFailure() {
        boolean condition = ArithmeticValidator.checkCorrectBorders(65, 3);
        Assert.assertFalse(condition);
    }

    @Test
    public void testCheckCorrectRangeSuccess() {
        boolean condition = ArithmeticValidator.checkCorrectRange(-270, 98);
        Assert.assertTrue(condition);
    }

    @Test
    public void testCheckCorrectRangeFailure() {
        boolean condition = ArithmeticValidator.checkCorrectRange(-465, 8791);
        Assert.assertFalse(condition);
    }

    @Test
    public void testIsValidPointSuccess() {
        boolean condition = ArithmeticValidator.isValidPoint(validPoint);
        Assert.assertTrue(condition);
    }

    @Test
    public void testIsValidPointFailure() {
        boolean condition = ArithmeticValidator.isValidPoint(invalidPoint);
        Assert.assertFalse(condition);
    }

}