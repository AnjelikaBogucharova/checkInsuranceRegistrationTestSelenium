import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class InsuranceTest {
    WebDriver driver;

    @Before
    public void executeBeforeTest(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.sberbank.ru/ru/person");
    }

    @Test
    public void executeest(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        driver.findElement(By.xpath("//*[@aria-label='Страхование']")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Перейти в каталог')]")).click();
        driver.findElement(By.xpath("//label[text()='Путешествия']")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'для путешественников')]")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-test-id='PageTeaserDict_header']"))));
        assertEquals("Страхование путешественников",
                driver.findElement(By.xpath("//*[@data-test-id='PageTeaserDict_header']")).getText());

        driver.findElement(By.xpath("//*[@data-test-id='PageTeaserDict_button']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Оформить')]")))).click();

        fillField(By.id("surname_vzr_ins_0"), "Иванов");
        fillField(By.id("name_vzr_ins_0"), "Иван");
        fillField(By.id("birthDate_vzr_ins_0"), "01.01.1970");
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("person_lastName"))));
        fillField(By.id("person_lastName"), "Петров");
        fillField(By.id("person_firstName"), "Петр");
        fillField(By.id("person_middleName"), "Петрович");
        fillField(By.id("person_birthDate"), "01.01.1990");
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("passportSeries"))));
        fillField(By.id("passportSeries"), "1234");
        fillField(By.id("passportNumber"), "654321");
        fillField(By.id("documentDate"), "01.02.2010");
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("documentIssue"))));
        fillField(By.id("documentIssue"), "test");


        assertEquals("Иванов", driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        assertEquals("Иван", driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        assertEquals("01.01.1970", driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));
        assertEquals("Петр", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Петрович", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("01.01.1990", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        assertEquals("654321", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("01.02.2010", driver.findElement(By.id("documentDate")).getAttribute("value"));

        assertEquals("Петров", driver.findElement(By.xpath("//*[@id='person_lastName']")).getAttribute("value"));
        assertEquals("1234", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("test", driver.findElement(By.id("documentIssue")).getAttribute("value"));


        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")))).click();

        assertEquals("При заполнении данных произошла ошибка", driver.findElement(By.xpath("//*[contains(@class,'alert-form')]")).getText());
    }

    public void fillField(By elem, String value){
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(value);
    }

    @After
    public void executeAfterTest(){
        driver.quit();
    }
}
