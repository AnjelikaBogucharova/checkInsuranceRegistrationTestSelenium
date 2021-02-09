package steps;

import org.openqa.selenium.By;
import pages.InsuranceSectionPage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsuranceSectionStep extends BaseSteps{
    InsuranceSectionPage insuranceSectionPage = new InsuranceSectionPage();

    @Step("Выбран раздел продуктов {0}")
    public void selectSection(String name){
        insuranceSectionPage.selectSection(name);
    }

    @Step("Выбран вид страховки {0}")
    public void choose(String name){
        insuranceSectionPage.choose(name);
    }
}
