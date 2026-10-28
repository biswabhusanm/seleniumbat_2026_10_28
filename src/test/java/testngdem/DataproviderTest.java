package testngdem;

import org.testng.annotations.DataProvider;

public class DataproviderTest {

    @DataProvider(name = "readdatafromexcel")
    public Object[][] getExcelData() {
        String path = System.getProperty("user.dir") + "/src/test/resources/TestData/Data.xlsx";
        return ReadExcelData.getTestData(path, "credential");
    }

    @DataProvider(name = "fetchInvaliddata")
    public Object[][] fetchInvaliddata() {
        return new Object[][]{
                {"admin12345", "securePass123"},   // Negative test
                {"biswa12345", "invalidpwd"},// Negative test (Invalid username)
                {"biswatest@","password2345$"}
        };
    }


}
