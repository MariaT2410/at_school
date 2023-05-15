import model.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test()
public class PositiveCalculatorTest {
    @DataProvider
    public Object[][] positiveData(){
        return new Object[][]{
                {"+", "5.8", "7.2", 13.0},
                {"-", "7.0", "-6.0",13.0},
                {"+", "-2147483648", "0", -2147483648.0},
                {"*", "2.0", "3.2", 6.4},
                {"/", "1.25", "5", 0.25},
                {"-", "2147483647", "2", 2147483645},
                {"+", "1", "1", 2.0},
                {"+", "2147483646", "1", 2147483647.0}, //результат вычисления находится на верхней границе диапазона

        };
    }
    @Test(dataProvider = "positiveData")
    public void positiveTest(String op, String n1, String n2, double result){
        Assert.assertEquals(String.valueOf(Math.round(result*1000.0)/1000.0), Calculator.execute(new String[]{ n1, op, n2}), "Значения не равны");
    }
}

