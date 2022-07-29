package pageobjects;


import actiondriver.action.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class LoginPage extends BaseClass {


    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement loginUserPassword;

    @FindBy(id="login-button")
    WebElement loginButton;

    @FindBy(className = "bot_column")
    WebElement imageLoginPage;


    public LoginPage() { PageFactory.initElements(driver, this); }

    public boolean validateLogo()

    {
        return Action.isDisplayed(driver, imageLoginPage);
    }

    public String getMyStoreTitle()
    {
        String myStoreTitle = driver.getTitle();
        return myStoreTitle;
    }


    public ProductsListPage login (String uname, String pswd)
    {
        Action.type(userName, uname);
        Action.type(loginUserPassword, pswd);
        Action.click(driver, loginButton);
        return new ProductsListPage();


    }

}
