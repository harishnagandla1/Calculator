import com.epam.tat.module4.Calculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dataProvider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.*;

@SuppressWarnings("ALL")
public class CalculatorTest {
    Calculator calculator;
    Logger log = LogManager.getLogger(CalculatorTest.class);

    @BeforeTest(alwaysRun = true, groups = "smoke")
    public void intializeCalculator() {
        calculator = new Calculator();
        log.info("Calculator is Turn on");
    }

    @BeforeMethod(alwaysRun = true)
    public void getReadyCalculator() {
        log.info("Calculator is ready");
    }

    @Test(groups = "smoke", dataProvider = "calculatorDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void testSumLongNum(long num1, long num2, long expectedResult) {
        log.info(STR."Perform long Sum Operation Between  \{num1} And \{+num2}");
        Assert.assertEquals(calculator.sum(num1, num2), expectedResult);
    }

    @Test(dependsOnGroups = "smoke", dataProvider = "calculatorDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void testSumDoubleNum(double num1, double num2, double expectedResult) {
        log.info(STR."Perform double Sum Operation Between  \{num1} And \{+num2}");
        Assert.assertEquals(calculator.sum(num1, num2), expectedResult);
    }

    @Test(groups = "smoke", dataProvider = "calculatorDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void testSubLongNum(long num1, long num2, long expectedResult) {
        log.info(STR."Perform long Subtraction Operation Between  \{num1} And \{+num2}");
        Assert.assertEquals(calculator.sub(num1, num2), expectedResult);
    }

    @Test(dataProvider = "calculatorDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void testSubDoubleNum(double num1, double num2, double expectedResult) {
        log.info(STR."Perform double Subtraction Operation Between  \{num1} And \{+num2}");
        Assert.assertEquals(calculator.sub(num1, num2), expectedResult);
    }

    @Test(dependsOnGroups = "smoke", dataProvider = "calculatorDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void testMultiplyLongNum(long num1, long num2, long expectedResult) {
        log.info(STR."Perform long multiply Operation Between  \{num1} And \{+num2}");
        Assert.assertEquals(calculator.mult(num1, num2), expectedResult);
    }

    @Test(dataProvider = "calculatorDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void testMultiplyDoubleNum(double num1, double num2, double expectedResult) {
        log.info(STR."Perform double multiply Operation Between  \{num1} And \{+num2}");
        Assert.assertEquals(calculator.mult(num1, num2), expectedResult);
    }

    @Test(dataProvider = "calculatorDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void testDivisionLongNum(long num1, long num2, long expectedResult) {
        log.info(STR."Perform long Division Operation Between  \{num1} And \{+num2}");
        Assert.assertEquals(calculator.div(num1, num2), expectedResult);
    }

    @Test(expectedExceptions = {Exception.class, NumberFormatException.class}, expectedExceptionsMessageRegExp = "Attempt to divide by zero", dataProvider = "calculatorDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void testDivisionLongNumBy0(long num1, long num2, long expectedResult) {
        log.info(STR."Perform long Division Operation Between  \{num1} And \{+num2}");
        Assert.assertEquals(calculator.div(num1, num2), expectedResult);
    }

    @Test(dataProvider = "calculatorDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void testDivisionDoubleNum(double num1, double num2, double expectedResult) {
        log.info(STR."Perform double Division Operation Between \{num1} And \{+num2}");
        Assert.assertEquals(calculator.div(num1, num2), expectedResult);
    }

    @AfterMethod(alwaysRun = true)
    public void getCalculatorStatus() {
        log.info("Calculator is successfully completed calculation operation");
    }

    @AfterTest(alwaysRun = true, groups = "smoke")
    public void tearDownCalculator() {
        calculator = new Calculator();
        log.info("Calculator is Turn Off");
    }
}
