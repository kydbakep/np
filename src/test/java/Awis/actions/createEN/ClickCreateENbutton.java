package Awis.actions.createEN;

import ClearTest.Conditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 30.01.17.
 */

public class ClickCreateENbutton extends Conditions {

    public ClickCreateENbutton(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateEN() {
        System.out.println();
        System.out.println("Очікую, доки з'явиться кнока 'Створити'...");
        waitForElementPresent(createENButton);
        if (createENButton.isDisplayed()) {
            System.out.println();
            System.out.println("OK.");
        } else {
            System.out.println();
            System.out.println("Failure! Не бачу кнопку 'Створити'!");
        }
        System.out.println("Натискаємо кнопку \"Створити\"");
        createENButton.click();
        waitForElementPresent(createENTab);
        if (createENTab.isDisplayed()) {
            System.out.println();
            System.out.println("OK.");
        } else {
            System.out.println();
            System.out.println("Failed!");
        }
    }

    @FindBy(xpath = "//button[span = 'Створити']")
    private WebElement createENButton;

    @FindBy(xpath = "//div[contains(@id, 'tab') and contains(@class, 'active')]//span [contains(., 'ЕН: нова')]")
    private WebElement createENTab;
}