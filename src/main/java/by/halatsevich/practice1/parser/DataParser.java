package by.halatsevich.practice1.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Parsing data to readable
 *
 * @author Vladislav Halatsevich
 */

public class DataParser {

    public int[] parseToInts(String... values) {
        List<Integer> temp = new ArrayList<>();
        for (String s : values) {
            try {
                int value = Integer.parseInt(s);
                temp.add(value);
            } catch (NumberFormatException e) {
                System.err.printf("Incorrect data to parse: %s\n", s);
            }
        }
        int[] parsedValues = new int[temp.size()];
        for (int i = 0; i < parsedValues.length; i++) {
            parsedValues[i] = temp.get(i);
        }
        return parsedValues;
    }
}
