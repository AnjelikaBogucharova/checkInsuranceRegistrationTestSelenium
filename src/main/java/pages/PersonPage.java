package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class PersonPage extends BaseMethods{

    @FindBy(xpath = "//div[contains(@class,'site-header')]")
    WebElement header;

    public PersonPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        this.driver= BaseSteps.getDriver();
    }

    public void selectMenu(String nameMenu){
        header.findElement(By.xpath(".//*[@aria-label='" + nameMenu +"']")).click();
    }

    public void selectSubMenu(String nameSubMenu){
        header.findElement(By.xpath("//*[contains(text(), '" + nameSubMenu +"')]")).click();
    }

}
