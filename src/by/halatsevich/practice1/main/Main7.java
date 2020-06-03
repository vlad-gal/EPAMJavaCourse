package by.halatsevich.practice1.main;

import by.halatsevich.practice1.console.ConsoleHelper;
import by.halatsevich.practice1.entity.Point;
import by.halatsevich.practice1.exception.ValidatorException;
import by.halatsevich.practice1.service.GeometricService;
import by.halatsevich.practice1.validator.ArithmeticValidator;

public class Main7 {
    public static void main(String[] args) throws ValidatorException {
        ArithmeticValidator validator = new ArithmeticValidator();
        GeometricService service = new GeometricService();
        ConsoleHelper console = new ConsoleHelper();

        //valid data
        Point a = new Point("A", 10, 34.11);
        Point b = new Point("B", -122.2, 137);

        boolean isValidRangeA = validator.isValidPoint(a);
        boolean isValidRangeB = validator.isValidPoint(b);

        console.showValidation(isValidRangeA);
        console.showValidation(isValidRangeB);

        Point nearestPoint = service.nearestPoint(a, b);

        console.showNearestPoint(nearestPoint, a, b);

        //invalid data
        Point c = new Point("C", 1000, 3411);
        Point d = new Point("D", -1222, 137);

        boolean isValidRangeC = validator.isValidPoint(c);
        boolean isValidRangeD = validator.isValidPoint(d);

        console.showValidation(isValidRangeC);
        console.showValidation(isValidRangeD);

        nearestPoint = service.nearestPoint(c, d);

        console.showNearestPoint(nearestPoint, c, d);
    }
}
