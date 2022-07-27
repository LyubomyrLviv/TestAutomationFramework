package testcases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
    LoginPage loginPage;

    @BeforeMethod
    public void setup()
    {
        launchApp();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void verifyLogo()
    {
        loginPage = new LoginPage();
        boolean result = loginPage.validateLogo();
        Assert.assertTrue(result);
    }

    @Test
    public void verifyTitle()
    {
        String actTitle = loginPage.getMyStoreTitle();
        Assert.assertEquals(actTitle,"Swag Labs");
    }

    public void loginTest()
    {
        loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }
}
