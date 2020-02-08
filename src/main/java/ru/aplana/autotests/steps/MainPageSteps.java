package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import ru.aplana.autotests.pages.MainPage;

public class MainPageSteps {
    @Step("выбран пункт меню {0}")
    public void selectMenu(String arg0) {
        new MainPage().clickOnMenu(arg0);
    }
}
