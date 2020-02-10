package ru.aplana.autotests.steps;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;

public class MyStepdefs {
    MainPageSteps mainPageSteps = new MainPageSteps();
    ContributionPageSteps contributionPageSteps = new ContributionPageSteps();

    @Когда("выбран пункт меню {string}")
    public void selectMenuItem(String arg0) {
        mainPageSteps.selectMenu(arg0);
    }

    @Когда("заполнена сумма вклада{string}")
    public void fillDepositAmount(String arg0) {
        contributionPageSteps.fillDepositAmount(arg0);
    }

    @Когда("выбран срок вклада {string}")
    public void selectTerm(String arg0) {
        contributionPageSteps.selectTerm(arg0);
    }

    @Когда("заполнена сумма ежемесячного пополнения{string}")
    public void fillMonthlyReplenishment(String arg0) {
        contributionPageSteps.fillMonthlyReplenishment(arg0);
    }

    @И("отмечено {string} {string}")
    public void selectCapitalization(String arg0, String arg1) {
        if (arg1.equals("true")) {
            contributionPageSteps.selectCapitalization(arg0);
        }
    }

    @Тогда("проверить значения полей:")
    public void checkFields(DataTable table) {
        table.asMap(String.class, String.class)
                .forEach((field, value) -> contributionPageSteps.checkFields((String) field, (String) value));
    }

    @Когда("^выбрана валюта - \"(.+)\"$")
    public void selectCurrency(String arg0) {
        contributionPageSteps.selectCurrency(arg0);
    }

    @Когда("отмечено {string}")
    public void selectCapitalization(String arg0) {
        contributionPageSteps.selectCapitalization(arg0);
    }
}
