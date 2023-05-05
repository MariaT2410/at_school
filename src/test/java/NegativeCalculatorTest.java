import model.Calculator;
import model.CalculatorException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeCalculatorTest {
    @DataProvider
    public Object[][] negativeData(){
        return new Object[][]{
                {"+", "1.7976931348623157E+309", "7.2"},
                {"-", "", "6.0"},
                {"*", "one", "2.0"},
                {"/", "10.0", "0"}
        };
    }
    @Test(dataProvider = "negativeData")
    public void negativeTest( String op, String n1, String n2) throws CalculatorException
    {
        if(!op.isEmpty()&&!n1.isEmpty()&&!n2.isEmpty()){
            //деление на 0 и пустые строки
            if((n2.equals("0"))&&(op.equals("/"))){
                throw new CalculatorException("Деление на 0");
            }else {
                try {
                    Double.parseDouble(n1);
                    Double.parseDouble(n2);
                } catch (NumberFormatException ex) {
                    throw new CalculatorException("Одно из чисел не является числом", ex);
                }
                if (Double.parseDouble(n1) < Double.MAX_VALUE || Double.parseDouble(n1) > Double.MIN_VALUE || Double.parseDouble(n2) < Double.MAX_VALUE || Double.parseDouble(n2) < Double.MIN_VALUE) {
                    throw new CalculatorException("Одно из чисел вне границ диапазона");
                }
            }
        }else {throw new CalculatorException("Одно из значений пустая строка");}
    }
}
