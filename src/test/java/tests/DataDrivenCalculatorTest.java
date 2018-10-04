package tests;

import objects.CalculatorPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DataDrivenCalculatorTest extends BaseTest {

    private static CalculatorPage calc;

    @Parameterized.Parameter
    public String expression;

    @Parameterized.Parameter(1)
    public String expected;

    @BeforeClass
    public static void setup() {
        calc = new CalculatorPage(driver);
        calc.open();
    }

    @Before
    public void cleanup() {
        calc.clear();
    }

    @Test
    public void calculator_DataDrivenTest(){
        Assert.assertEquals(expected, calc.calculate(expression));
    }

    @Parameterized.Parameters (name="Test: {0}={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "1+1", "2" },
                { "5-1", "4" },
                { "8/0", "You cannot davide on 0" },
                { "8/2", "4" },
                { "-6-6", "-12" },
                { "10-100", "-90" },
                { "-88+1000", "912" },
                { "2x2", "4" },
                { "888888888888888888888888=", "888888888888888888888888" },
                { "-88+1000", "912" },
                { "5+5+6", "16" },
                { "10-2/2+0", "9" },
                { "0-2", "-2" },
                { ".5+4.5", "5" },

        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}