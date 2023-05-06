package model;

//import java.model.CalculatorException;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static String execute(String[] params) {
        //Calculator.isOperator(params);
        String operator = params[isOperator(params)];
        try {
                double value1 = Double.parseDouble(isNum(params)[0]);
                double value2 = Double.parseDouble(isNum(params)[1]);
                double result = Math.round(calculate(operator, value1, value2) * 1000.0) / 1000.0;
                if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE || value1 > Integer.MAX_VALUE || value1 < Integer.MIN_VALUE || value2 > Integer.MAX_VALUE || value2 < Integer.MIN_VALUE) {
                    throw new CalculatorException("Превышен порог у вводимых значений и выводимых значений");
                }
                return String.valueOf(result);
        } catch (NumberFormatException e){
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

    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static int isOperator(String[] params){
        int newParam = 0;
        for(int i =0; i<3; i++) {
            //String op = params[i];
            if (!isDouble(params[i])) {
                newParam = i;
            }
        }
        return newParam;
    }
    private static String[] isNum(String[] params){
        //String[] newParam = new String[]{};
        ArrayList<String> res = new ArrayList<>();
        String[] resul = new String[2];
        String a;
        int j=0;
        for(String i:params) {
            if(!i.equals(params[isOperator(params)])){
                res.add(i);
                resul[j]=i;
                j++;
            }
        }
        return resul;
    }

}

