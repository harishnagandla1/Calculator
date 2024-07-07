package org.dataProvider;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class CalculatorDataProvider {

    @DataProvider(name = "calculatorDataProvider")
    public static Object[][] calculatorDataProvider(Method m) {
        return switch (m.getName()) {
            case "testSumLongNum" ->
                    new Object[][]{{2000, 50000, 52000}, {3000, -700, 2300}, {-3000, 700, -2300}, {-1000, -2000, -3000}};
            case "testSumDoubleNum" ->
                    new Object[][]{{400.50, 520.80, 921.30}, {700.32, -735.62, -35.299999999999955}, {-250.50, -250.50, -501.0}};
            case "testSubLongNum" ->
                    new Object[][]{{50000, 2000, 48000}, {3000, -700, 3700}, {-5000, -3000, -2000}};
            case "testSubDoubleNum" ->
                    new Object[][]{{520.80, 400.50, 120.29999999999995}, {-700.32, -735.23, 34.90999999999997}};
            case "testMultiplyLongNum" ->
                    new Object[][]{{20000, 5000, 100000000}, {30000, -5000, -150000000}, {-25700, 5000, -128500000}, {23000, 0, 0}};
            case "testMultiplyDoubleNum" ->
                    new Object[][]{{228.23, 532.21, 121466.0}, {355.35, -280.32, -99612.0}, {-435.12, 528.78, -230083.0}, {-258.52, -2375.82, 614196.0}, {328.85, 0, 0}};
            case "testDivisionLongNum" ->
                    new Object[][]{{25000, 5000, 5}, {30000, -5000, -6}, {-2500, 500, -5}};
            case "testDivisionLongNumBy0" ->
                    new Object[][]{ {23000, 0, 0}};
            case "testDivisionDoubleNum" ->
                    new Object[][]{{2280.23, 532.21, 4.284455384152872}, {355.35, -28.32, -12.547669491525424}, {-435.12, 52.78, -8.244031830238727}, {-258.52, -23.82, 10.853064651553316}, {528.78, 0.0, Double.POSITIVE_INFINITY}, {-638.76, 0.0, Double.NEGATIVE_INFINITY}};
            default -> null;
        };
    }
}
