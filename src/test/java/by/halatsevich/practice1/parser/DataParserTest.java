package by.halatsevich.practice1.parser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class DataParserTest {
    DataParser parser;

    @BeforeClass
    public void setUp() {
        parser = new DataParser();
    }

    @Test
    public void testParseToIntsSuccess() {
        int[] actual = parser.parseToInts("1", "3", "43", "12.3");
        int[] expected = {1, 3, 43};
        assertEquals(actual, expected);
    }

    @Test
    public void testParseToIntsFailure() {
        int[] actual = parser.parseToInts("1", "3", "43", "12.3");
        int[] expected = {1, 3, 43, (int) 12.3};
        assertNotEquals(actual, expected);
    }
}
