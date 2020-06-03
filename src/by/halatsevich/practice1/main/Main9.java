package by.halatsevich.practice1.main;

import by.halatsevich.practice1.console.ConsoleHelper;
import by.halatsevich.practice1.exception.ValidatorException;
import by.halatsevich.practice1.parser.DataParser;
import by.halatsevich.practice1.service.GeometricService;
import by.halatsevich.practice1.validator.ArithmeticValidator;

public class Main9 {
    public static void main(String[] args) throws ValidatorException {
        ArithmeticValidator validator = new ArithmeticValidator();
        GeometricService service = new GeometricService();
        ConsoleHelper console = new ConsoleHelper();
        DataParser parser = new DataParser();

        //valid data
        double radiusDouble = 13.4;
        String radiusString = "946.1";

        double parsedRadiusDouble = parser.parseToDouble(radiusDouble);
        double parsedRadiusString = parser.parseToDouble(radiusString);

        boolean checkPositiveDouble = validator.isPositiveDoubleValue(parsedRadiusDouble);
        boolean checkPositiveString = validator.isPositiveDoubleValue(parsedRadiusString);

        console.showValidation(checkPositiveDouble);
        console.showValidation(checkPositiveString);

        double squareDouble = service.calculateCircleSquare(parsedRadiusDouble);
        double circumferenceDouble = service.calculateCircumference(parsedRadiusDouble);
        double squareString = service.calculateCircleSquare(parsedRadiusString);
        double circumferenceString = service.calculateCircumference(parsedRadiusString);

        console.showSquareAndCircum(squareDouble, circumferenceDouble);
        console.showSquareAndCircum(squareString, circumferenceString);

        //invalid data
        double radiusDoubleInvalid = -330.7;
        String radiusStringInvalid = "-7082";

        parsedRadiusDouble = parser.parseToDouble(radiusDoubleInvalid);
        parsedRadiusString = parser.parseToDouble(radiusStringInvalid);

        checkPositiveDouble = validator.isPositiveDoubleValue(parsedRadiusDouble);
        checkPositiveString = validator.isPositiveDoubleValue(parsedRadiusString);

        console.showValidation(checkPositiveDouble);
        console.showValidation(checkPositiveString);

        squareDouble = service.calculateCircleSquare(parsedRadiusDouble);
        circumferenceDouble = service.calculateCircumference(parsedRadiusDouble);
        squareString = service.calculateCircleSquare(parsedRadiusString);
        circumferenceString = service.calculateCircumference(parsedRadiusString);

        console.showSquareAndCircum(squareDouble, circumferenceDouble);
        console.showSquareAndCircum(squareString, circumferenceString);

    }
}
