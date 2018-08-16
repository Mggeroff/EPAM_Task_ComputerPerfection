package edu.epam.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrderInfoValidatorTest {
    OrderInfoValidator orderInfoValidator = new OrderInfoValidator();

    @DataProvider(name = "dataForComputerNameValidator")
    public static Object[][] dataForComputerNameValidator() {
        return new Object[][]{
                { "12", false },
                { "PC", false },
                { "SuperMegaInsaneGamerComputer", false },
                { "PowerPC", true },
                { "DellWorkstation", true }
        };
    }

    @DataProvider(name = "dataForComputerAmountValidator")
    public static Object[][] dataForComputerAmountValidator() {
        return new Object[][]{
                { "12", false },
                { "dfa", false },
                { "0", false },
                { "2", true },
                { "7", true }
        };
    }

    @DataProvider(name = "dataForComputerCaseSetValidator")
    public static Object[][] dataForComputerCaseSetValidator() {
        return new Object[][]{
                { "PC_MINI", false },
                { "Pc_corsair", false },
                { "PC_BLOCK", true },
                { "MINI_PC_BLOCK", true }
        };
    }

    @DataProvider(name = "dataForCustomerIdValidator")
    public Object[][] dataForCustomerIdValidator() {
        return new Object[][]{
                { "1234567", false },
                { "123", false },
                { "john", false },
                { "12345", true },
                { "54321", true }
        };
    }

    @Test(dataProvider = "dataForCustomerIdValidator")
    public void testIsValidCustomerId(String data, boolean expectedResult) {
        boolean result = orderInfoValidator.isValidCustomerId(data);
        Assert.assertEquals(result, expectedResult);
    }

    @Test(dataProvider = "dataForComputerNameValidator")
    public void testIsValidComputerName(String data, boolean expectedResult) {
        boolean result = orderInfoValidator.isValidComputerName(data);
        Assert.assertEquals(result, expectedResult);
    }

    @Test(dataProvider = "dataForComputerAmountValidator")
    public void testIsValidComputerAmount(String data, boolean expectedResult) {
        boolean result = orderInfoValidator.isValidComputerAmount(data);
        Assert.assertEquals(result, expectedResult);
    }

    @Test(dataProvider = "dataForComputerCaseSetValidator")
    public void testIsComputerCaseSet(String data, boolean expectedResult) {
        boolean result = orderInfoValidator.isComputerCaseSet(data);
        Assert.assertEquals(result, expectedResult);
    }
}
