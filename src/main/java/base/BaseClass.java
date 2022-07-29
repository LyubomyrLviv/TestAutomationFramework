package base;


import actiondriver.action.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import pageobjects.LoginPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClass
{
    public static Properties prop;
    public static WebDriver driver;
    public static FileInputStream fis;

    //static LoginPage loginPage = new LoginPage();



    @BeforeTest
    public void loadConfig() throws IOException {
        prop = new Properties();
        fis = new FileInputStream(System.getProperty("user.dir")+"/configuration/config.properties");
        prop.load(fis);
        System.out.println("webdriver" + driver);

    }

    public void launchApp(){
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");

        if (browserName.contains("chrome"))
        {
            driver = new ChromeDriver();
        } else if (browserName.contains("firefox"))
        {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        Action.implicitWait(driver,10);
        Action.pageLoadTimeOut(driver,30);
        driver.get(prop.getProperty("url"));



    }

}
