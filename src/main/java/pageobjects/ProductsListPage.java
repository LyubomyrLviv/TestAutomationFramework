package pageobjects;

import actiondriver.action.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsListPage extends BaseClass {

    @FindBy(id ="logout_sidebar_link")
    WebElement logoutBtn;

    @FindBy(id = "react-burger-menu-btn")
    WebElement sideBarMenu;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addCart;

    @FindBy(id="item_4_title_link")
    WebElement product;

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

    public void addToCart()
    {
        Action.click(driver, addCart);
    }

    public void goToProdDetails()
    {
        Action.click(driver, product);
//        return new ProductProfilePage();
    }


}
