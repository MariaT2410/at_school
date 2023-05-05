import model.Calculator;
import model.CalculatorException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeCalculatorTest {
    @DataProvider
    public Object[][] negativeData(){
        return new Object[][]{
                {"+", "2147483646", "2147483646"}
                //{"-", "", "6"},
                //{"*", "one", "2.0"},
                //{"/", "10", "0"},
                //{"+", "-2147483648", "2147483648"}
        };
    }
    @Test(dataProvider = "negativeData")
    public void negativeTest( String op, String n1, String n2) throws CalculatorException
    {
        if(op.equals("")){throw new CalculatorException();}
        else {
            if (!op.isEmpty() && !n1.isEmpty() && !n2.isEmpty()) {
                //деление на 0 и пустые строки
                if ((n2.equals("0")) && (op.equals("/"))) {
                    throw new CalculatorException("Деление на 0");
                } else {
                    try {
                        Integer.parseInt(n1);
                        Integer.parseInt(n2);
                    } catch (NumberFormatException ex) {
                        throw new CalculatorException("Одно из чисел не является числом", ex);
                    }
                    if (Integer.parseInt(n1) < Integer.MAX_VALUE || Integer.parseInt(n1) > Integer.MIN_VALUE || Integer.parseInt(n2) < Integer.MAX_VALUE || Integer.parseInt(n2) < Integer.MIN_VALUE) {
                        throw new CalculatorException("Одно из чисел вне границ диапазона");
                    }
                }
            } else {
                throw new CalculatorException("Одно из значений пустая строка");
            }
        }
    }
}