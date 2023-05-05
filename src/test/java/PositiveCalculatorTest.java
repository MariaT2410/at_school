import model.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;

@Test()
public class PositiveCalculatorTest {
    @DataProvider
    public Object[][] positiveData(){
        return new Object[][]{
                {"+", "5", "7", 12.0},
                {"-", "7", "-6",13.0},
                {"*", "2", "3", 6.0},
                {"/", "-2147483648", "-2147483648", 1.0},
                {"+", "2147483646", "0", 2147483646.0}
        };
    }
    @Test(dataProvider = "positiveData")
    public void positiveTest(String op, String n1, String n2, double result){
        Assert.assertEquals(String.valueOf(result), Calculator.execute(new String[]{op, n1, n2}), "Значения не равны");
    }
}