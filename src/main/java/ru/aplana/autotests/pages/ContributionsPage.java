package ru.aplana.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContributionsPage extends BasePage {
    @FindBy(xpath = "//span[@class='calculator__currency-field-text']")
    List<WebElement> currency;
    @FindBy(xpath = "//input[@name='amount']")
    WebElement contributionsAmount;
    @FindBy(xpath = "//select")
    WebElement select;
    @FindBy(xpath = "//input[@name='replenish']")
    WebElement monthlyReplenishment;
    @FindBy(xpath = "//span[@class='js-deposit-name']")
    WebElement depositName;
    @FindBy(xpath = "//span[@class='js-calc-rate']")
    WebElement calcRate;
    @FindBy(xpath = "//span[@class='js-calc-earned']")
    WebElement calcEarnied;
    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    WebElement calcReplenish;
    @FindBy(xpath = "//span[@class='js-calc-result']")
    WebElement calcResult;

    /**
     * Выбор валюты
     */
    public void selectCurrency(String cur) {
        for (WebElement element : currency) {
            if (element.getText().equals(cur)) {
                element.click();
            }
        }
    }

    /**
     * Ввод суммы вклада
     */
    public void inputAmount(String amount) {
        contributionsAmount.sendKeys(amount);
    }

    /**
     * Выбор срока вклада
     */
    public void selectContributionsTerm(String value) {
        Select select1 = new Select(select);
        select1.selectByVisibleText(value);
    }

    /**
     * Метод ввода ежемесячного пополнения
     */
    public void inputMonthlyReplenishment(String value) {
        monthlyReplenishment.sendKeys(value);
    }

    /**
     * Метод выбора Капитализации частичного снятия
     */
    public void selectCapitalization(String arg0) {
        driver.findElement(By.xpath("//div[@class='calculator__check-row-field']//span[text()='" + arg0 + "']")).click();
        waitCalcResult(calcResult.getText());
    }

    /**
     * Метод который ждет когда посчитается сумма к снятию
     */
    private void waitCalcResult(String name) {
        (new WebDriverWait(driver, 10))
                .until((ExpectedCondition<Boolean>) d -> !depositName.getText().equals(name));
    }

    /**
     * Метод проверки расчетов полей
     */
    public void checkField(String field, String value) {
        switch (field) {
            case "Название вклада":
                Assert.assertEquals(value, depositName.getText());
                break;
            case "Ставка":
                Assert.assertEquals(value, calcRate.getText());
                break;
            case "Начислено %":
                Assert.assertEquals(value, calcEarnied.getText());
                break;
            case "Пополнение за 6 месяцев":
                Assert.assertEquals(value, calcReplenish.getText());
                break;
            case "К снятию через 6 месяцев":
                Assert.assertEquals(value, calcResult.getText());
                break;
            default:
                throw new AssertionError("Поле '" + field + "' не объявлено на странице");

        }
    }
}