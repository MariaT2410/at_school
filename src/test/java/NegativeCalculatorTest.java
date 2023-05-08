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

    @Test(dataProvider = "negativeData", expectedExceptions = {RuntimeException.class})
    public void negativeTest(String op, String n1, String n2) {
         Assert.assertTrue(Double.parseDouble(Calculator.execute(new String[]{n1, op, n2})) <= Integer.MAX_VALUE || Double.parseDouble(Calculator.execute(new String[]{n1, op, n2})) >= Integer.MIN_VALUE);

    }
}