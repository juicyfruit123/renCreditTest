package ru.aplana.autotests.steps;

import io.qameta.allure.Step;
import ru.aplana.autotests.pages.ContributionsPage;

public class ContributionPageSteps {
    @Step("выбрана валюта {0}")
    public void selectCurrency(String arg0) {
        new ContributionsPage().selectCurrency(arg0);
    }

    @Step("заполняется сумма вклада {0}")
    public void fillDepositAmount(String arg0) {
        new ContributionsPage().inputAmount(arg0);
    }

    @Step("выбор срока вклада {0}")
    public void selectTerm(String arg0) {
        new ContributionsPage().selectContributionsTerm(arg0);
    }

    @Step("заполнение суммы ежемесячного пополнения {0}")
    public void fillMonthlyReplenishment(String arg0) {
        new ContributionsPage().inputMonthlyReplenishment(arg0);
    }

    @Step("выбрана {0}")
    public void selectCapitalization(String arg0) {
        new ContributionsPage().selectCapitalization(arg0);
    }

    @Step("проверка значения поля {0}")
    public void checkFields(String field, String value) {
        new ContributionsPage().checkField(field, value);
    }
}
