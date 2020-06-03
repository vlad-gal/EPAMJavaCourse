package by.halatsevich.practice1.main;

import by.halatsevich.practice1.console.ConsoleHelper;
import by.halatsevich.practice1.exception.ValidatorException;
import by.halatsevich.practice1.parser.DataParser;
import by.halatsevich.practice1.service.MathService;
import by.halatsevich.practice1.validator.ArithmeticValidator;

public class Main5 {
    public static void main(String[] args) throws ValidatorException {
        ArithmeticValidator validator = new ArithmeticValidator();
        MathService service = new MathService();
        ConsoleHelper console = new ConsoleHelper();
        DataParser parser = new DataParser();

        //valid data
        int numberInt = 2;
        String numberString = "28";

        int parsedInt = parser.parseToInt(numberInt);
        int parsedString = parser.parseToInt(numberString);

        boolean checkPositiveInt = validator.isPositiveIntValue(parsedInt);
        boolean checkPositiveString = validator.isPositiveIntValue(parsedString);

        console.showValidation(checkPositiveInt);
        console.showValidation(checkPositiveString);

        boolean resultInt = service.isPerfectNumber(parsedInt);
        boolean resultString = service.isPerfectNumber(parsedString);

        console.showPerfectNumber(resultInt);
        console.showPerfectNumber(resultString);

        //invalid data
        int numberIntInvalid = -4;
        String numberStringInvalid = "-687";

        parsedInt = parser.parseToInt(numberIntInvalid);
        parsedString = parser.parseToInt(numberStringInvalid);

        checkPositiveInt = validator.isPositiveIntValue(parsedInt);
        checkPositiveString = validator.isPositiveIntValue(parsedString);

        console.showValidation(checkPositiveInt);
        console.showValidation(checkPositiveString);

        resultInt = service.isPerfectNumber(parsedInt);
        resultString = service.isPerfectNumber(parsedString);

        console.showPerfectNumber(resultInt);
        console.showPerfectNumber(resultString);

    }
}
