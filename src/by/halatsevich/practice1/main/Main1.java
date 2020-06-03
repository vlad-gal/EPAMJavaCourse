package by.halatsevich.practice1.main;

import by.halatsevich.practice1.console.ConsoleHelper;
import by.halatsevich.practice1.exception.ValidatorException;
import by.halatsevich.practice1.parser.DataParser;
import by.halatsevich.practice1.service.MathService;
import by.halatsevich.practice1.validator.ArithmeticValidator;

public class Main1 {
    public static void main(String[] args) throws ValidatorException {
        ArithmeticValidator validator = new ArithmeticValidator();
        MathService service = new MathService();
        ConsoleHelper console = new ConsoleHelper();
        DataParser parser = new DataParser();

        // valid data
        int numberInteger = 1;
        String numberString = "23";

        int parsedInt = parser.parseToInt(numberInteger);
        int parsedString = parser.parseToInt(numberString);

        boolean checkMinMaxInteger = validator.isValidNumber(parsedInt);
        boolean checkMinMaxString = validator.isValidNumber(parsedString);

        console.showValidation(checkMinMaxInteger);
        console.showValidation(checkMinMaxString);

        int resultInt = service.lastSquareDigit(parsedInt);
        int resultString = service.lastSquareDigit(parsedString);

        console.showLastDigit(resultInt);
        console.showLastDigit(resultString);

        //invalid data
        int numberIntegerInvalid = 500;
        String numberStringInvalid = "-2142";

        parsedInt = parser.parseToInt(numberIntegerInvalid);
        parsedString = parser.parseToInt(numberStringInvalid);

        checkMinMaxInteger = validator.isValidNumber(parsedInt);
        checkMinMaxString = validator.isValidNumber(parsedString);

        console.showValidation(checkMinMaxInteger);
        console.showValidation(checkMinMaxString);

        resultInt = service.lastSquareDigit(parsedInt);
        resultString = service.lastSquareDigit(parsedString);

        console.showLastDigit(resultInt);
        console.showLastDigit(resultString);

    }
}
