package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LaunchBrowser {

    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties ploc = new Properties();
    public static FileReader fr;
    public static FileReader frloc;


    @BeforeMethod
    public void start() throws IOException
    {

        if(driver==null)
        {
            fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/config.properties");
            frloc = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/locators.properties");
            prop.load(fr);
            ploc.load(frloc);
        }

        if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("testUrl"));

        }
        else if(prop.getProperty("browser").equalsIgnoreCase("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("testUrl"));
        }




    }
    @AfterMethod
    public void close()
    {
        driver.close();
        System.out.println("browser closed successfully");
    }

}
