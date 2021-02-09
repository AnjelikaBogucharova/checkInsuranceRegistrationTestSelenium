package steps;

import pages.InsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class InsuranceStep extends BaseSteps{
    InsurancePage insurancePage = new InsurancePage();

    @Step("Проверяем заголовок страницы")
    public void checkTitle(String expect){
        String title = insurancePage.title.getText();
        assertTrue(String.format("Ожидаемое значение %s не соответствует полученному %s", expect, title),title.contains(expect));
    }

    @Step("Нажимаем на кнопку \"Оформить онлаин\"")
    public void goToRegistration(){
        insurancePage.goToRegistration();
    }
}
