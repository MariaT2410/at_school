import model.Calculator;
import model.CalculatorException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeCalculatorTest {
    @DataProvider
    public Object[][] negativeData() {
        return new Object[][]{
                {"+", "2147483648.0", "7.2"},// граница верхнего диапазона
                {"+", "-2147483647.0", "-2147483647"},//результат за границей нижнего
                {"+", "-2147483649.0", "7.0"},
                {"+", "2147483646.0", "7.2"}, //результат находится за верхней границей диапазона
                {"-", "", "6.0"},//пустая строка
                {"*", "one", "2.0"},// строка one в число
                {"/", "10.0", "0"},// деление на 0
                {"+", "-2147483649.0", "7.2"},// граница нижнего диапазона
                {"", "10.0", "0"},// пустая строка в операторе
                {"=", "10.0", "2.0"},// оператор не + - / *
                {"0", "one", "two"},
                {"+", "1", "1"},
                {null, null, null},
                {"plus", "1", "1"},

        };
    }

    @Test(dataProvider = "negativeData", expectedExceptions = {CalculatorException.class})
    public void negativeTest(String op, String n1, String n2) {
        if ((!op.isEmpty()) && (!n1.isEmpty()) && (!n2.isEmpty())){
            if(op==null||n1==null||n2==null){throw new CalculatorException();}
            else {
                if ((!op.equals("")) || op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
                    //деление на 0 и пустые строки
                    if ((n2.equals("0")) && (op.equals("/"))) {
                        throw new CalculatorException("Деление на 0");
                    } else {
                        try {
                            Double.parseDouble(n1);
                            Double.parseDouble(n2);
                        } catch (RuntimeException e) {
                            throw new CalculatorException();
                        }
                        if (Double.parseDouble(n1) > Integer.MAX_VALUE || Double.parseDouble(n1) < Integer.MIN_VALUE) {
                            throw new CalculatorException("Одно из чисел вне границ диапазона n1");
                        } else {
                            if (Double.parseDouble(n2) > Integer.MAX_VALUE || Double.parseDouble(n2) < Integer.MIN_VALUE) {
                                throw new CalculatorException("Одно из чисел вне границ диапазона n2");
                            } else if (Double.parseDouble(Calculator.execute(new String[]{n1, op, n2})) > Integer.MAX_VALUE || Double.parseDouble(Calculator.execute(new String[]{n1, op, n2})) < Integer.MIN_VALUE) {
                                throw new CalculatorException("Результат вне границ диапазона");
                            } else {
                                Assert.assertTrue(Double.parseDouble(Calculator.execute(new String[]{n1, op, n2})) <= Integer.MAX_VALUE || Double.parseDouble(Calculator.execute(new String[]{n1, op, n2})) >= Integer.MIN_VALUE);

                            }
                        }
                    }
                } else {
                    throw new CalculatorException();
                }
            }

        } else {
            throw new CalculatorException();
        }


    }
}