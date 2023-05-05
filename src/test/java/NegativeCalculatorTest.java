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
                {"/", "10.0", "0"},
                {"+", "-2147483649 ", "7.2"},
                {"", "10.0", "0"},
        };
    }
    @Test(dataProvider = "negativeData", expectedExceptions= {RuntimeException.class})
    public void negativeTest( String op, String n1, String n2)
    {
        if(op.equals("")){throw new RuntimeException();}
        else {
            if (!op.isEmpty() && !n1.isEmpty() && !n2.isEmpty()) {
                //деление на 0 и пустые строки
                if ((n2.equals("0")) && (op.equals("/"))) {
                    throw new RuntimeException("Деление на 0");
                } else {
                    try {
                        Double.parseDouble(n1);
                        Double.parseDouble(n2);
                    } catch (RuntimeException e) { }
                    if (Double.parseDouble(n1) < Integer.MAX_VALUE || Double.parseDouble(n1) > Integer.MIN_VALUE || Double.parseDouble(n2) < Integer.MAX_VALUE || Double.parseDouble(n2) < Integer.MIN_VALUE) {
                        throw new RuntimeException("Одно из чисел вне границ диапазона");
                    }
                }
            } else {
                throw new RuntimeException();
            }
        }
    }
}