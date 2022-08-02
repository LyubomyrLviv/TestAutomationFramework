package pageobjects;

import actiondriver.action.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductProfilePage extends BaseClass {
    //Locators
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addTCartProductPage;

    public ProductProfilePage() {PageFactory.initElements(driver, this);}

    //Related pages
    LoginPage loginPage;
    ProductsListPage productsListPage;
    ProductProfilePage productProfilePage;

    //Start Stop
    @BeforeMethod
    public void setup()   {launchApp(); }



    //Methods
    @Test
    public void addTCartFromProductPage()
    {
        loginPage = new LoginPage();
        productsListPage = new ProductsListPage();
//        productProfilePage = new ProductProfilePage();
        productsListPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        productsListPage.goToProdDetails();
        Action.click(driver, addTCartProductPage);

    }

//    public String getPpageTitle()
//    {
//        String currPageTitle = driver.getTitle();
//        return  currPageTitle;
//    }


}
