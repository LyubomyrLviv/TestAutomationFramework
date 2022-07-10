package testcases;

import base.LaunchBrowser;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.ReadXlsData;

public class SimpleTestCase extends LaunchBrowser {

    @Test(dataProviderClass = ReadXlsData.class, dataProvider = "loginDataProvider")
    public static void loginTest (String username, String password)
    {
        driver.findElement(By.id(ploc.getProperty("loginNameId"))).sendKeys("username");
        driver.findElement(By.id(ploc.getProperty("loginPasswordId"))).sendKeys("password");
        driver.findElement(By.id(ploc.getProperty("loginButtonId"))).click();

    }
      //TestNG data provider. Now we're using reading from xls data
//    @DataProvider(name="testdata")
//    public Object[][] tData()
//    {
//        return new Object[][]
//        {
//                {"standard_user", "secret_sauce"},
//                {"performance_glitch_user", "secret_sauce"}
//        };
//    }

}
