package testcases;

import base.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ProductsListPage;

public class LoginPageTest extends BaseClass {
    //LoginPage loginPage;
    ProductsListPage productsListPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setup()        {launchApp(); }

    @AfterMethod
    public void tearDown()    {driver.quit();}

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

    @Test
    public void loginTest()
    {
        loginPage = new LoginPage();
        productsListPage = new ProductsListPage();
        loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        String actUrl = productsListPage.getCurUrl();
        String expUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actUrl, "https://www.saucedemo.com/inventory.html");
    }
}
