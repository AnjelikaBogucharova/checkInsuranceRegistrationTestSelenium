import org.junit.*;
import pages.*;
import static org.junit.Assert.*;


public class InsuranceTest extends BaseTest{


    @Test
    public void executeTest(){
//        driver.get(property.getProperty("url"));
        PersonPage personPage = new PersonPage(driver);
        InsuranceSectionPage insuranceSectionPage = new InsuranceSectionPage(driver);
        InsurancePage insurancePage = new InsurancePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        personPage.selectMenu("Страхование");
        personPage.selectSubMenu("Перейти в каталог");

        insuranceSectionPage.selectSection("Путешествия");
        insuranceSectionPage.choose("для путешественников");

        String expect = "Страхование путешественников";
        String title = insurancePage.title.getText();
        assertTrue(String.format("Ожидаемое значение %s не соответствует полученному %s", expect,title),title.contains(expect));
        insurancePage.goToRegistration();

        checkoutPage.waitButtonIssueToBeClickable();
        checkoutPage.fillField("Фамилия застрахованного", "Иванов");
        checkoutPage.fillField("Имя застрахованного", "Иван");
        checkoutPage.fillField("Дата рождения застрахованного", "01.01.1970");
        checkoutPage.changeOfFocus();
        checkoutPage.fillField("Фамилия", "Петров");
        checkoutPage.fillField("Имя", "Петр");
        checkoutPage.fillField("Отчество", "Петрович");
        checkoutPage.fillField("Дата рождения", "01.01.1990");
        checkoutPage.changeOfFocus();
        checkoutPage.fillField("Серия паспорта", "1234");
        checkoutPage.fillField("Номер паспорта", "654321");
        checkoutPage.fillField("Дата выдачи", "01.02.2010");
        checkoutPage.changeOfFocus();
        checkoutPage.fillField("Выдан", "test");


        checkoutPage.checkFillField("Иванов", checkoutPage.lastNameInsured);
        checkoutPage.checkFillField("Иван",  checkoutPage.firstNameInsured);
        checkoutPage.checkFillField("01.01.1970",  checkoutPage.birthDateInsured);
        checkoutPage.checkFillField("Петр",  checkoutPage.firstName);
        checkoutPage.checkFillField("Петрович",  checkoutPage.secondName);
        checkoutPage.checkFillField("01.01.1990",  checkoutPage.birthDate);
        checkoutPage.checkFillField("654321",  checkoutPage.docNumber);
        checkoutPage.checkFillField("01.02.2010",  checkoutPage.docDate);
        checkoutPage.checkFillField("Петров",  checkoutPage.lastName);
        checkoutPage.checkFillField("1234",  checkoutPage.docSeries);
        checkoutPage.checkFillField("test",  checkoutPage.docIssue);

        checkoutPage.clickButtonContinue();
        checkoutPage.checkError("При заполнении данных произошла ошибка");
    }


}
