package Awis.actions.requestFence;

import ClearTest.Conditions;
import ClearTest.Initializer;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 16.02.17.
 */

public class SetCounterParty extends Conditions {
    private WebDriverWait wait = new WebDriverWait(driver, 5);
    Initializer init = new Initializer(driver);

    public SetCounterParty(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

//======================================================================================================================

    public void setSender(String phone) throws Exception {

        System.out.println("Обираємо відправника за номером телефону...");
        waitForElementPresent(cpSenderInput);
        cpSenderInput.sendKeys(phone);
        justWait(225);
        cpSenderInput.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.attributeContains(cpSenderPhoneInput,"value", phone));
        if (cpSenderPhoneInput.getAttribute("value").contains(phone)){
            System.out.println();
            System.out.println("Обрано контрагента відправника: " + cpSenderContactNameInput.getAttribute("value") + "; телефон: " + cpSenderPhoneInput.getAttribute("value"));
        } else System.err.println("Відправника не обрано!");
    }

//----------------------------------------------------------------------------------------------------------------------

    public void setRecipient(String phone) throws Exception {

        System.out.println("Обираємо отримувача за номером телефону...");
        waitForElementPresent(cpRecipientInput);
        cpRecipientInput.sendKeys(phone);
        justWait(225);
        cpRecipientInput.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.attributeContains(cpRecipientPhoneInput,"value", phone));
        if (cpRecipientPhoneInput.getAttribute("value").contains(phone)){
            System.out.println();
            System.out.println("Обрано контрагента отримувача: " + cpRecipientContactNameInput.getAttribute("value") + "; телефон: " + cpRecipientPhoneInput.getAttribute("value"));
        } else System.err.println("Отримувача не обрано!");
    }

//======================================================================================================================


    @FindBy(xpath = ".//fieldset/legend/div[.='Відправник']/../../div/div[label='Контрагент:']/div/input")
    private WebElement cpSenderInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Отримувач']/../../div/div[label='Контрагент:']/div/input")
    private WebElement cpRecipientInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Відправник']/../../div/div[label='Телефон:']/div/input")
    private WebElement cpSenderPhoneInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Отримувач']/../../div/div[label='Телефон:']/div/input")
    private WebElement cpRecipientPhoneInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Відправник']/../../div/div/label[contains(text(),'Контактне')]/../div/input")
    private WebElement cpSenderContactNameInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Отримувач']/../../div/div/label[contains(text(),'Контактне')]/../div/input")
    private WebElement cpRecipientContactNameInput;
}
