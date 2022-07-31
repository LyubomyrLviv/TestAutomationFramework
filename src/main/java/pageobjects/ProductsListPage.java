package pageobjects;

import actiondriver.action.Action;
import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsListPage extends BaseClass {

//    @BeforeMethod
//    public void setup()        {launchApp(); }

    @FindBy(id ="logout_sidebar_link")
    WebElement logoutBtn;

    @FindBy(id = "react-burger-menu-btn")
    WebElement sideBarMenu;

    public ProductsListPage() { PageFactory.initElements(driver, this); }

    LoginPage loginPage;
    ProductsListPage productsListPage;


    public String getCurUrl()
    {
       String productsListUrl = driver.getCurrentUrl();
       return productsListUrl;
    }

    public void  logoutTest()
    {
        Action.click(driver,sideBarMenu);
//        driver.findElement(By.id("logout_sidebar_link")).click();
        Action.click(driver,logoutBtn);
    }


}
