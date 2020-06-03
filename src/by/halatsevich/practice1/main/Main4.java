package by.halatsevich.practice1.main;

import by.halatsevich.practice1.console.ConsoleHelper;
import by.halatsevich.practice1.exception.ValidatorException;
import by.halatsevich.practice1.parser.DataParser;
import by.halatsevich.practice1.service.MathService;
import by.halatsevich.practice1.validator.ArithmeticValidator;

public class Main4 {
    public static void main(String[] args) throws ValidatorException {
        ArithmeticValidator validator = new ArithmeticValidator();
        MathService service = new MathService();
        ConsoleHelper console = new ConsoleHelper();
        DataParser parser = new DataParser();

        //valid data
        int[] numbersInt = new int[]{1, 4, 2, 65};
        String[] numbersString = new String[]{"45", "12", "687", "33"};

        int[] parsedInt = parser.parseToInts(numbersInt);
        int[] parsedString = parser.parseToInts(numbersString);

        boolean checkCountOfNumberInt = validator.isRightCountOfNumber(parsedInt);
        boolean checkCountOfNumberString = validator.isRightCountOfNumber(parsedString);

        console.showValidation(checkCountOfNumberInt);
        console.showValidation(checkCountOfNumberString);

        boolean resultInt = service.areTwoEvenNumbers(parsedInt);
        boolean resultString = service.areTwoEvenNumbers(parsedString);

        console.showTwoEven(resultInt);
        console.showTwoEven(resultString);

        //invalid data
        int[] numbersIntInvalid = new int[]{1, 4, 2, 65, 12};
        String[] numbersStringInvalid = new String[]{"45", "687", "33"};

        parsedInt = parser.parseToInts(numbersIntInvalid);
        parsedString = parser.parseToInts(numbersStringInvalid);

        checkCountOfNumberInt = validator.isRightCountOfNumber(parsedInt);
        checkCountOfNumberString = validator.isRightCountOfNumber(parsedString);

        console.showValidation(checkCountOfNumberInt);
        console.showValidation(checkCountOfNumberString);

        resultInt = service.areTwoEvenNumbers(parsedInt);
        resultString = service.areTwoEvenNumbers(parsedString);

        console.showTwoEven(resultInt);
        console.showTwoEven(resultString);
    }
}
