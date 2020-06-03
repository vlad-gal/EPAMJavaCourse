package by.halatsevich.practice1.main;

import by.halatsevich.practice1.console.ConsoleHelper;
import by.halatsevich.practice1.exception.ValidatorException;
import by.halatsevich.practice1.parser.DataParser;
import by.halatsevich.practice1.service.CalendarService;
import by.halatsevich.practice1.validator.CalendarValidator;

public class Main6 {
    public static void main(String[] args) throws ValidatorException {
        CalendarValidator validator = new CalendarValidator();
        CalendarService service = new CalendarService();
        ConsoleHelper console = new ConsoleHelper();
        DataParser parser = new DataParser();

        //valid data
        int numberInt = 24566;
        String numberString = "78284";

        int parsedInt = parser.parseToInt(numberInt);
        int parsedString = parser.parseToInt(numberString);

        boolean checkValidSecondsInt = validator.isValidSeconds(parsedInt);
        boolean checkValidSecondsString = validator.isValidSeconds(parsedString);

        console.showValidation(checkValidSecondsInt);
        console.showValidation(checkValidSecondsString);

        int[] resultInt = service.countFullTime(parsedInt);
        int[] resultString = service.countFullTime(parsedString);

        console.showFullTime(resultInt);
        console.showFullTime(resultString);

        //invalid data
        int numberIntInvalid = 888676;
        String numberStringInvalid = "-687";

        parsedInt = parser.parseToInt(numberIntInvalid);
        parsedString = parser.parseToInt(numberStringInvalid);

        checkValidSecondsInt = validator.isValidSeconds(parsedInt);
        checkValidSecondsString = validator.isValidSeconds(parsedString);

        console.showValidation(checkValidSecondsInt);
        console.showValidation(checkValidSecondsString);

        resultInt = service.countFullTime(parsedInt);
        resultString = service.countFullTime(parsedString);

        console.showFullTime(resultInt);
        console.showFullTime(resultString);
    }
}
