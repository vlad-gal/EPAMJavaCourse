package by.halatsevich.practice1.main;

import by.halatsevich.practice1.console.ConsoleHelper;
import by.halatsevich.practice1.exception.ValidatorException;
import by.halatsevich.practice1.parser.DataParser;
import by.halatsevich.practice1.service.GeometricService;
import by.halatsevich.practice1.validator.ArithmeticValidator;

public class Main3 {
    public static void main(String[] args) throws ValidatorException {
        ArithmeticValidator validator = new ArithmeticValidator();
        GeometricService service = new GeometricService();
        ConsoleHelper console = new ConsoleHelper();
        DataParser parser = new DataParser();

        //valid data
        double squareDouble = 342.213;
        String squareString = "213.1";

        double parsedSquareDouble = parser.parseToDouble(squareDouble);
        double parsedSquareString = parser.parseToDouble(squareString);

        boolean checkPositiveDouble = validator.isPositiveDoubleValue(parsedSquareDouble);
        boolean checkPositiveString = validator.isPositiveDoubleValue(parsedSquareString);

        console.showValidation(checkPositiveDouble);
        console.showValidation(checkPositiveString);

        double[] resultDouble = service.calculateAreaAndRatio(parsedSquareDouble);
        double[] resultString = service.calculateAreaAndRatio(parsedSquareString);

        console.showAreaAndRatio(resultDouble);
        console.showAreaAndRatio(resultString);

        //invalid data
        double squareDoubleInvalid = -33.7;
        String squareStringInvalid = "-782";

        parsedSquareDouble = parser.parseToDouble(squareDoubleInvalid);
        parsedSquareString = parser.parseToDouble(squareStringInvalid);

        checkPositiveDouble = validator.isPositiveDoubleValue(parsedSquareDouble);
        checkPositiveString = validator.isPositiveDoubleValue(parsedSquareString);

        console.showValidation(checkPositiveDouble);
        console.showValidation(checkPositiveString);

        resultDouble = service.calculateAreaAndRatio(parsedSquareDouble);
        resultString = service.calculateAreaAndRatio(parsedSquareString);

        console.showAreaAndRatio(resultDouble);
        console.showAreaAndRatio(resultString);
    }
}
