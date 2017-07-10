package Awis.actions.createEN;

import Awis.Conditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 06.02.17.
 */

public class SetPaymantMethod extends Conditions {


    public SetPaymantMethod(WebDriver driver) {
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectPaymantMethodFromDropdown(String type) {
        waitForElementPresent(paymentMethodChooser);
        if (paymentMethodChooser.isDisplayed()) {
            System.out.println();
            System.out.println("Обираємо форму розрахунку... ");
            paymentMethodChooser.click();
            if (type.equals("Готівка") || type.equals("готівка")) {
                waitForElementPresent(cash);
                cash.click();
            }
            if (type.equals("Безготівковий") || type.equals("безготівковий")) {
                waitForElementPresent(nonCash);
                nonCash.click();
            }
        } else {
            System.err.println("Не можу обрати форму розрахунку!");
        }
    }

    @FindBy(xpath = "//input[@name='PaymentMethod']/../../div[2]/div[1]")
    private WebElement paymentMethodChooser;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[contains(text(),'Готівка')]")
    private WebElement cash;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[contains(text(),'Безготівковий')]")
    private WebElement nonCash;
}