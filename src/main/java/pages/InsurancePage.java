package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class InsurancePage extends BaseMethods{

    @FindBy(xpath = "//*[@data-test-id='PageTeaserDict_header']")
    public WebElement title;

    public InsurancePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public void waitTitle(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public void goToRegistration(){
        driver.findElement(By.xpath("//*[@data-test-id='PageTeaserDict_button']")).click();
    }


}
