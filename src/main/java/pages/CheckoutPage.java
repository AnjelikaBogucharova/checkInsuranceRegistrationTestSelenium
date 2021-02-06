package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import static org.junit.Assert.*;

public class CheckoutPage extends BaseMethods{

    @FindBy(id="surname_vzr_ins_0")
    public WebElement lastNameInsured;

    @FindBy(id="name_vzr_ins_0")
    public WebElement firstNameInsured;

    @FindBy(id="birthDate_vzr_ins_0")
    public WebElement birthDateInsured;

    @FindBy(id="person_lastName")
    public WebElement lastName;

    @FindBy(id="person_firstName")
    public WebElement firstName;

    @FindBy(id="person_middleName")
    public WebElement secondName;

    @FindBy(id="person_birthDate")
    public WebElement birthDate;

    @FindBy(id="passportSeries")
    public WebElement docSeries;

    @FindBy(id="passportNumber")
    public WebElement docNumber;

    @FindBy(id="documentDate")
    public WebElement docDate;

    @FindBy(id="documentIssue")
    public WebElement docIssue;

    @FindBy(xpath = "//*[contains(@class,'alert-form')]")
    public WebElement error;

    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    public void fillField(String key, String value){
        switch (key){
            case "Фамилия застрахованного": fillField(lastNameInsured, value); break;
            case "Имя застрахованного": fillField(firstNameInsured, value); break;
            case "Дата рождения застрахованного": fillField(birthDateInsured, value); break;
            case "Фамилия": fillField(lastName, value); break;
            case "Имя": fillField(firstName, value); break;
            case "Отчество": fillField(secondName, value); break;
            case "Дата рождения": fillField(birthDate, value); break;
            case "Серия паспорта": fillField(docSeries, value); break;
            case "Номер паспорта": fillField(docNumber, value); break;
            case "Дата выдачи": fillField(docDate, value); break;
            case "Выдан": fillField(docIssue, value); break;
            default:  throw new AssertionError("Поле '"+key+"' не объявлено на странице");
        }
    }

    public void waitButtonIssueToBeClickable(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Оформить')]")))).click();
    }

    public void changeOfFocus()  {
        driver.findElement(By.xpath("//legend[contains(text(),'Страхователь')]")).click();
    }

    public void clickButtonContinue(){
        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();
    }

    public void checkError(String value){
        assertTrue(String.format("Полученная ошибка %s не соответствует ожидаемой %s", error.getText(), value), error.getText().contains(value));
    }

}
