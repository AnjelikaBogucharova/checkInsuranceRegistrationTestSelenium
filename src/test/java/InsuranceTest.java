import org.junit.*;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;
import java.util.HashMap;



public class InsuranceTest extends BaseSteps {


    @Test
    @Title("Оформление страховки для путешественников")
    public void executeTest(){
        PersonStep personStep = new PersonStep();
        InsuranceSectionStep insuranceSectionStep = new InsuranceSectionStep();
        InsuranceStep insuranceStep = new InsuranceStep();
        CheckoutStep checkoutStep = new CheckoutStep();

        HashMap<String,String> personData = new HashMap<>();
        personData.put("Фамилия застрахованного", "Иванов");
        personData.put("Имя застрахованного", "Иван");
        personData.put("Дата рождения застрахованного", "01.01.1970");
        personData.put("Фамилия", "Петров");
        personData.put("Имя", "Петр");
        personData.put("Отчество", "Петрович");
        personData.put("Дата рождения", "01.01.1990");
        personData.put("Серия паспорта", "1234");
        personData.put("Номер паспорта", "654321");
        personData.put("Дата выдачи", "01.02.2010");
        personData.put("Выдан", "test");

        personStep.selectMenu("Страхование");
        personStep.selectSubMenu("Перейти в каталог");

        insuranceSectionStep.selectSection("Путешествия");
        insuranceSectionStep.choose("для путешественников");

        String expect = "Страхование путешественников";
        insuranceStep.checkTitle(expect);
        insuranceStep.goToRegistration();

        checkoutStep.waitButtonIssueToBeClickable();
        checkoutStep.fillFields(personData);
        checkoutStep.checkFillFields(personData);
        checkoutStep.clickButtonContinue();
        checkoutStep.checkError("При заполнении данных произошла ошибка");
    }

}
