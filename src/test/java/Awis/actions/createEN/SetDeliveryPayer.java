package Awis.actions.createEN;

import ClearTest.Conditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 05.02.17.
 */

public class SetDeliveryPayer extends Conditions {

    public SetDeliveryPayer(WebDriver driver) {
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectPayerFromDropDown(String payer) {
        waitForElementPresent(payerTypeChooser);
        if (payerTypeChooser.isDisplayed()) {
            System.out.println();
            System.out.println("Обираємо платника... ");
            payerTypeChooser.click();
            if (payer.equals("Відправник") || payer.equals("відправник")) {
                waitForElementPresent(sender);
                sender.click();
            }
            if (payer.equals("Отримувач") || payer.equals("отримувач")) {
                waitForElementPresent(recipient);
                recipient.click();
            }
            if (payer.equals("Третя особа") || payer.equals("третя особа")) {
                waitForElementPresent(thirdPerson);
                thirdPerson.click();
            }
        } else {
            System.err.println("Не можу обрати платника!");
        }
    }

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[contains(text(),'Відправник')]")
    private WebElement sender;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[contains(text(),'Отримувач')]")
    private WebElement recipient;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[contains(text(),'Третя особа')]")
    private WebElement thirdPerson;

    @FindBy(xpath = "//input[@name='PayerType']/../../div[2]/div[1]")
    private WebElement payerTypeChooser;

    @FindBy(xpath = "//input[@name='PayerType']")
    private WebDriver payerTypeInput;

    //    -----------------------------------------------------------------------------------
    @FindBy(xpath = "//label[.='Третя особа:']/following-sibling::div/div/div[1]")
    private WebElement thirdPersonChooser;
}