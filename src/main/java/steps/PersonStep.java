package steps;

import pages.PersonPage;
import ru.yandex.qatools.allure.annotations.Step;

public class PersonStep extends BaseSteps{
    PersonPage personPage = new PersonPage();

    @Step("На верхней панели меню выбран раздел {0}")
    public void selectMenu(String menuName){
        personPage.selectMenu(menuName);
    }

    @Step("В меню раздела выбран пункт {0}")
    public void selectSubMenu(String subMenuName){
        personPage.selectSubMenu(subMenuName);
    }
}
