package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class InsuranceSectionPage extends BaseMethods{

    @FindBy(id="main-page")
    WebElement insurance;

    public InsuranceSectionPage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
        this.driver= BaseSteps.getDriver();
    }

    public void selectSection(String name){
        insurance.findElement(By.xpath(".//label[text()='" + name +"']")).click();
    }

    public void choose(String name){
        insurance.findElement(By.xpath("//*[contains(text(), '" + name +"')]")).click();
    }

}
