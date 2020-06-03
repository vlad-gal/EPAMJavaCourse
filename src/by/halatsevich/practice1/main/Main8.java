package by.halatsevich.practice1.main;

import by.halatsevich.practice1.console.ConsoleHelper;
import by.halatsevich.practice1.exception.ValidatorException;
import by.halatsevich.practice1.parser.DataParser;
import by.halatsevich.practice1.service.MathService;
import by.halatsevich.practice1.validator.ArithmeticValidator;

public class Main8 {
    public static void main(String[] args) throws ValidatorException {
        ArithmeticValidator validator = new ArithmeticValidator();
        MathService service = new MathService();
        ConsoleHelper console = new ConsoleHelper();
        DataParser parser = new DataParser();

        //valid data

        double numberDouble = -100.13;
        String numberString = "23.75";

        double parsedDouble = parser.parseToDouble(numberDouble);
        double parsedString = parser.parseToDouble(numberString);

        boolean checkMinMaxDouble = validator.isValidNumber(parsedDouble);
        boolean checkMinMaxString = validator.isValidNumber(parsedString);

        console.showValidation(checkMinMaxDouble);
        console.showValidation(checkMinMaxString);

        double resultDouble = service.calculateFx(parsedDouble);
        double resultString = service.calculateFx(parsedString);

        console.showFx(resultDouble);
        console.showFx(resultString);

        //invalid data
        int numberDoubleInvalid = 500;
        String numberStringInvalid = "-2142";

        parsedDouble = parser.parseToDouble(numberDoubleInvalid);
        parsedString = parser.parseToDouble(numberStringInvalid);

        checkMinMaxDouble = validator.isValidNumber(parsedDouble);
        checkMinMaxString = validator.isValidNumber(parsedString);

        console.showValidation(checkMinMaxDouble);
        console.showValidation(checkMinMaxString);

        resultDouble = service.calculateFx(parsedDouble);
        resultString = service.calculateFx(parsedString);

        console.showFx(resultDouble);
        console.showFx(resultString);

    }
}
