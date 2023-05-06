package model;

//import java.model.CalculatorException;

public class Calculator {

    public static String execute(String[] params) {
        String operator = params[1];
        try {
            double value1 = Double.parseDouble(params[0]);
            double value2 = Double.parseDouble(params[2]);
            double result = Math.round(calculate(operator, value1, value2)*1000.0)/1000.0;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE || value1> Integer.MAX_VALUE || value1 < Integer.MIN_VALUE || value2> Integer.MAX_VALUE || value2 < Integer.MIN_VALUE) {
                throw new CalculatorException("Превышен порог у вводимых значений и выводимых значений");
            }
            return String.valueOf(result);
        } catch (CalculatorException e){
            throw new CalculatorException("Проблема перевода строки в число");
        }
    }

    private static double calculate(String operator, double a, double b) {
            switch (operator) {
            case "+":
                return add(a, b);
            case "-":
                return subst(a, b);
            case "*":
                return mult(a, b);
            case "/":
                return div(a, b);
        }
        throw new CalculatorException("Неизвестный оператор");
    }

    private static double add(double a, double b) {
        return a + b;
    }

    private static double subst(double a, double b) {
        return a - b;
    }

    private static double div(double a, double b) {
        if (b == 0) {
            throw new CalculatorException();
        }
        return a / b;
    }

    private static double mult(double a, double b) {
        return a * b;
    }
}
