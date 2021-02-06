package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertEquals;

public class BaseMethods {
    WebDriver driver;

    public void fillField(WebElement elem, String value){
        elem.clear();
        elem.sendKeys(value);
    }

    public void checkFillField(String value, WebElement element) {
        assertEquals(String.format("Ожидаемое значение %s не соответствует полученному %s", value, element.getAttribute("value")), value, element.getAttribute("value"));
    }

}
