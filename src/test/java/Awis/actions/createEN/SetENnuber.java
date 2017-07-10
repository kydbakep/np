package Awis.actions.createEN;

import Awis.Conditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBeNotEmpty;

/**
 * ! Created by tober on 30.01.17.
 */

public class SetENnuber extends Conditions {

    public SetENnuber(WebDriver driver) {
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setNumber() {
        waitForElementPresent(addENNumberButton);
        System.out.println();
        System.out.println("Натискаємо кнопку \"Додати номер (+)\"");
        addENNumberButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(attributeToBeNotEmpty(numberENfield, "value"));

        if ((numberENfield).getAttribute("value").length() > 0) {
            System.out.println();
            System.out.println("OK.");
            System.out.println("Номер ЕН - " + (numberENfield).getAttribute("value"));
        } else System.err.println("Failed! Не можу натиснути \'+\' !");
    }

    @FindBy(xpath = ".//button[contains(@id,'newNumber')]")
    private WebElement addENNumberButton;

    @FindBy(xpath = "//input[@name = 'Number']")
    private WebElement numberENfield;
}