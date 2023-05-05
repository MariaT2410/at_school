import model.Calculator;
import model.CalculatorException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeCalculatorTest {
    @DataProvider
    public Object[][] negativeData(){
        return new Object[][]{
                {"+", "2147483648", "7.2"},
                {"+", "-2147483648 ", "7.2"},
                {"-", "", "6.0"},
                {"*", "one", "2.0"},
                {"/", "10.0", "0"}
        };
    }
    @Test(dataProvider = "negativeData", expectedExceptions= {ArithmeticException.class, NullPointerException.class, NumberFormatException.class})
    public void negativeTest( String op, String n1, String n2)
    {
        if(op.equals("")){throw new NullPointerException();}
        else {
            if (!op.isEmpty() && !n1.isEmpty() && !n2.isEmpty()) {
                //деление на 0 и пустые строки
                if ((n2.equals("0")) && (op.equals("/"))) {
                    throw new ArithmeticException("Деление на 0");
                } else {
                    try {
                        Double.parseDouble(n1);
                        Double.parseDouble(n2);
                    } catch (NumberFormatException e) { }
                    if (Double.parseDouble(n1) < Integer.MAX_VALUE || Double.parseDouble(n1) > Integer.MIN_VALUE || Double.parseDouble(n2) < Integer.MAX_VALUE || Double.parseDouble(n2) < Integer.MIN_VALUE) {
                        throw new ArithmeticException("Одно из чисел вне границ диапазона");
                    }
                }
            } else {
                throw new NullPointerException();
            }
        }
    }
}