import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;

    public static Properties property = TestProperties.getInstance().getProperties();


    @BeforeClass
    public static void executeBeforeTest(){
        System.setProperty("webdriver.chrome.driver",property.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(property.getProperty("url"));
    }

    protected static void fillField(By elem, String value){
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(value);
    }

    @AfterClass
    public static void executeAfterTest(){
        driver.quit();
    }
}
