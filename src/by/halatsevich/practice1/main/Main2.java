package by.halatsevich.practice1.main;

import by.halatsevich.practice1.console.ConsoleHelper;
import by.halatsevich.practice1.exception.ValidatorException;
import by.halatsevich.practice1.parser.DataParser;
import by.halatsevich.practice1.service.CalendarService;
import by.halatsevich.practice1.validator.CalendarValidator;

public class Main2 {
    public static void main(String[] args) throws ValidatorException {
        CalendarValidator validator = new CalendarValidator();
        CalendarService service = new CalendarService();
        ConsoleHelper console = new ConsoleHelper();
        DataParser parser = new DataParser();

        //valid data
        int yearInt = 1324;
        int monthInt = 2;
        String yearString = "3455";
        String monthString = "1";

        int parsedYearInt = parser.parseToInt(yearInt);
        int parsedMonthInt = parser.parseToInt(monthInt);
        int parsedYearString = parser.parseToInt(yearString);
        int parsedMonthString = parser.parseToInt(monthString);

        boolean checkValidYearInt = validator.isValidYear(parsedYearInt);
        boolean checkValidMonthInt = validator.isValidMonth(parsedMonthInt);
        boolean checkValidYearString = validator.isValidYear(parsedYearString);
        boolean checkValidMonthString = validator.isValidMonth(parsedMonthString);

        console.showValidation(checkValidYearInt);
        console.showValidation(checkValidMonthInt);
        console.showValidation(checkValidYearString);
        console.showValidation(checkValidMonthString);

        int resultInt = service.countDaysInMonth(parsedYearInt, parsedMonthInt);
        int resultString = service.countDaysInMonth(parsedYearString, parsedMonthString);

        console.showDaysInMonth(resultInt);
        console.showDaysInMonth(resultString);

        //invalid data
        int yearIntInvalid = 444444;
        int monthIntInvalid = 789;
        String yearStringInvalid = "-425";
        String monthStringInvalid = "888";

        parsedYearInt = parser.parseToInt(yearIntInvalid);
        parsedMonthInt = parser.parseToInt(monthIntInvalid);
        parsedYearString = parser.parseToInt(yearStringInvalid);
        parsedMonthString = parser.parseToInt(monthStringInvalid);

        checkValidYearInt = validator.isValidYear(parsedYearInt);
        checkValidMonthInt = validator.isValidMonth(parsedMonthInt);
        checkValidYearString = validator.isValidYear(parsedYearString);
        checkValidMonthString = validator.isValidMonth(parsedMonthString);

        console.showValidation(checkValidYearInt);
        console.showValidation(checkValidMonthInt);
        console.showValidation(checkValidYearString);
        console.showValidation(checkValidMonthString);

        resultInt = service.countDaysInMonth(parsedYearInt, parsedMonthInt);
        resultString = service.countDaysInMonth(parsedYearString, parsedMonthString);

        console.showDaysInMonth(resultInt);
        console.showDaysInMonth(resultString);


    }
}
