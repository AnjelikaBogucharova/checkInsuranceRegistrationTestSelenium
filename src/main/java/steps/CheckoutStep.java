package steps;

import pages.CheckoutPage;
import ru.yandex.qatools.allure.annotations.Step;
import static junit.framework.TestCase.*;
import java.util.HashMap;

public class CheckoutStep extends BaseSteps{
    CheckoutPage checkoutPage = new CheckoutPage();

    @Step("Переходим к заполнению данных")
    public void waitButtonIssueToBeClickable(){
        checkoutPage.waitButtonIssueToBeClickable();
    }

    @Step("Заполняем данные")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkoutPage.fillField(k,v));
    }

    @Step("Поле {0} заполнено значением {1}")
    public void checkFillField(String fieldName, String expectedValue){
        String valueField = checkoutPage.getField(fieldName);
        assertTrue(String.format("Ожидаемое значение %s не соответствует полученному %s", expectedValue, valueField),
                valueField.contains(expectedValue));
    }

    @Step("Проверяем заполненные данные")
    public void checkFillFields(HashMap<String,String> data){
        data.forEach((k,v)->checkFillField(k,v));
    }

    @Step("Нажимаем кнопку \"Продолжить\"")
    public void clickButtonContinue(){
        checkoutPage.clickButtonContinue();
    }

    @Step("Получено сообщение об ошибке {0}")
    public void checkError(String value){
        checkoutPage.checkError(value);
    }
}
