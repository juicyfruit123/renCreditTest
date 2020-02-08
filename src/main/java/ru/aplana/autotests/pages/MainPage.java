package ru.aplana.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = "//div[@class='service']")
    WebElement menu;

    public void clickOnMenu(String menuName) {
        menu.findElement(By.xpath("//div[text()='" + menuName + "']/../a[@href='/contributions/']")).click();
    }

}
