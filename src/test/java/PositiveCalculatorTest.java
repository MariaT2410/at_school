import model.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;

@Test()
public class PositiveCalculatorTest {
    @DataProvider
    public Object[][] positiveData(){
        return new Object[][]{
                {"+", "5.8", "7.2", 13.0},
                {"-", "7.0", "-6.0",13.0},
                {"*", "2.0", "3.2", 6.4},
                {"/", "1.7976931348623157E+308", "1.7976931348623157E+308", 1.0},
                {"/", "4.9406564584124654E-324", "4.9406564584124654E-324", 1.0}
        };
    }
    @Test(dataProvider = "positiveData")
    public void positiveTest(String op, String n1, String n2, Double result){
        Assert.assertEquals(result.toString(), Calculator.execute(new String[]{op, n1, n2}), "Значения не равны");
    }
}