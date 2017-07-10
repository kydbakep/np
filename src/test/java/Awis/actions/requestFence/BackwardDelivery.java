package Awis.actions.requestFence;

import ClearTest.Conditions;
import ClearTest.Initializer;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 20.02.17.
 */

public class BackwardDelivery extends Conditions {

    private WebDriverWait wait = new WebDriverWait(driver, 5);
    Initializer init = new Initializer(driver);

    public BackwardDelivery(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void Type(String type){
        waitForElementPresent(bdCargoTypeSelectButton);

        bdCargoTypeSelectButton.click();
        init.cargoType().setType(type);
    }

    private void Description(String text){
        waitForElementPresent(bdDescriptionInput);
        bdDescriptionInput.sendKeys(text+ Keys.ENTER);
    }

    public void SetTypeAndDescription(String type, String text, String payer){
        setCheckBox();
        Type(type);
        Description(text);
        setPayer(payer);
    }

    private void setCheckBox(){
        backwardDeliveryCheckbox.click();
    }

    private void setPayer(String payer){
        if (payer.equals("Відправник")){
            waitForElementPresent(bdPayerSenderRadio);
            bdPayerSenderRadio.click();
        }
        if (payer.equals("Отримувач")){
            waitForElementPresent(bdPayerRecipientRadio);
            bdPayerRecipientRadio.click();
        }
        else System.err.println("Не обрано, або не вірно обрано платника зворотньої доставки!");
    }

    @FindBy(xpath = "//div[label='Зворотня доставка:']//input")
    private WebElement backwardDeliveryCheckbox;

    @FindBy(xpath = ".//div[contains(@id,'radiofield')]/div[.='Відправник']/input")
    private WebElement bdPayerSenderRadio;

    @FindBy(xpath = ".//div[contains(@id,'radiofield')]/div[.='Отримувач']/input")
    private WebElement bdPayerRecipientRadio;

    @FindBy(xpath = ".//fieldset[legend/div[.='Зворотня доставка']]//div[label[.='Тип вантажу:']]/div/div[contains(@id,'combobox')]")
    private WebElement bdCargoTypeSelectButton;

    @FindBy(xpath = ".//fieldset[legend/div[.='Зворотня доставка']]//div[label[.='Тип вантажу:']]//input")
    private WebElement bdCargoTypeInput;

    @FindBy(xpath = "//input[@name='BackwardDeliveryDescription']")
    private WebElement bdDescriptionInput;
}
