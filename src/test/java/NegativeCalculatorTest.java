import model.Calculator;
import model.CalculatorException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeCalculatorTest {
    @DataProvider
    public Object[][] negativeData(){
        return new Object[][]{
                {"+", "5.8", "7.2", "13.6"},
                {"-", "", "6.0", "1.1"},
                {"*", "2.2", "2.0", "4.4"},
                {"/", "10.0", "0.0", "20.0"}
        };
    }
    @Test(dataProvider = "negativeData")
    public void negativeTest( String op, String n1, String n2, String result) throws CalculatorException
    {
        //деление на 0 и пустые строки
        if(((n2.equals("0"))&&(op.equals("/")))||(n1.equals(""))||(n2.equals(""))||(op.equals(""))){
            throw new CalculatorException();
        }else {
            Assert.assertNotEquals(result, Calculator.execute(new String[]{op, n1, n2}), "Значения равны");
        }
    }
}
