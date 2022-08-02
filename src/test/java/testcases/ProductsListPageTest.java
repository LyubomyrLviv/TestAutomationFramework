package testcases;

import actiondriver.action.Action;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ProductsListPage;

public class ProductsListPageTest extends BaseClass {

    ProductsListPage productsListPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setup()        {launchApp(); }

    @AfterMethod
    public void tearDown()    {driver.quit();}

    @Test
    public void  logoutTest ()
    {
        productsListPage = new ProductsListPage();
        loginPage = new LoginPage();
        loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        productsListPage.logoutTest();
        String cLoginPageUrl = loginPage.getLoginPageUrl();
        String actLoginPageUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(cLoginPageUrl, actLoginPageUrl);

    }
    @Test
    public void addToCartTest()
    {
        productsListPage = new ProductsListPage();
        loginPage = new LoginPage();
        loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        productsListPage.addToCart();
    }




}
