package by.halatsevich.practice1.parser;

/**
 * Parsing data to readable
 *
 * @author vlad
 */

public class DataParser {

    public int parseToInt(String value) {
        int parsedValue = Integer.parseInt(value);
        return parseToInt(parsedValue);
    }

    public int parseToInt(int value) {
        return value;
    }

    public double parseToDouble(String value) {
        double parsedValue = Double.parseDouble(value);
        return parseToDouble(parsedValue);
    }

    public double parseToDouble(double value) {
        return value;
    }

    public int[] parseToInts(String... values) {
        int[] parsedValues = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            parsedValues[i] = Integer.parseInt(values[i]);
        }
        return parseToInts(parsedValues);
    }

    public int[] parseToInts(int... values) {
        return values;
    }


}
