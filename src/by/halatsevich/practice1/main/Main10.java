package by.halatsevich.practice1.main;

import by.halatsevich.practice1.console.ConsoleHelper;
import by.halatsevich.practice1.exception.ValidatorException;
import by.halatsevich.practice1.parser.DataParser;
import by.halatsevich.practice1.service.MathService;
import by.halatsevich.practice1.validator.ArithmeticValidator;

import java.util.Map;

public class Main10 {
    public static void main(String[] args) throws ValidatorException {
        ArithmeticValidator validator = new ArithmeticValidator();
        MathService service = new MathService();
        ConsoleHelper console = new ConsoleHelper();
        DataParser parser = new DataParser();

        //valid data
        double startBorder = -270;
        String finishBorder = "200";
        double step = 10;

        double parsedStartBorder = parser.parseToDouble(startBorder);
        double parsedFinishBorder = parser.parseToDouble(finishBorder);
        double parsedStep = parser.parseToDouble(step);

        boolean isCorrectBorders = validator.checkCorrectBorders(parsedStartBorder, parsedFinishBorder);
        boolean isCorrectRange = validator.checkCorrectRange(parsedStartBorder, parsedFinishBorder);

        console.showValidation(isCorrectBorders);
        console.showValidation(isCorrectRange);

        Map<Double, Double> result = service.calculateTgx(parsedStartBorder, parsedFinishBorder, parsedStep);

        console.showTgx(result);

        //invalid data
        startBorder = -9000;
        finishBorder = "350";
        step = 10;

        parsedStartBorder = parser.parseToDouble(startBorder);
        parsedFinishBorder = parser.parseToDouble(finishBorder);
        parsedStep = parser.parseToDouble(step);

        isCorrectBorders = validator.checkCorrectBorders(parsedStartBorder, parsedFinishBorder);
        isCorrectRange = validator.checkCorrectRange(parsedStartBorder, parsedFinishBorder);

        console.showValidation(isCorrectBorders);
        console.showValidation(isCorrectRange);

        result = service.calculateTgx(parsedStartBorder, parsedFinishBorder, parsedStep);

        console.showTgx(result);
    }
}
