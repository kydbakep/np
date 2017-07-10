package Awis.actions.requestFence;

import ClearTest.Conditions;
import ClearTest.Initializer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

public class PaymentInfo extends Conditions {

    private WebDriverWait wait = new WebDriverWait(driver, 5);
    Initializer init = new Initializer(driver);

    public PaymentInfo(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void setPayer(String payer) {
//Тип платника
        waitForElementPresent(payerDropdownButton);
        payerDropdownButton.click();
        waitForElementPresent(payerDropdownList);

        if (payer.equals("Відправник")) {
            payerIsSender.click();
        }
        if (payer.equals("Отримувач")) {
            payerIsRecipient.click();
        }
        if (payer.equals("Третя особа")) {
            payerIsThirdPerson.click();
        }
    }

    private void setPayer(String payer, String payerName) {
//Тип платника
        waitForElementPresent(payerDropdownButton);
        payerDropdownButton.click();
        waitForElementPresent(payerDropdownList);

        if (payer.equals("Відправник")) {
            payerIsSender.click();
        }
        if (payer.equals("Отримувач")) {
            payerIsRecipient.click();
        }
        if (payer.equals("Третя особа")) {

            payerIsThirdPerson.click();
            justWait(100);
            thirdPersonCatalogueButton.click();

            waitForElementPresent(counterpartyesTab);
            counterpartyNameInput.sendKeys(payerName+ Keys.ENTER);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table/tbody/tr/td[15][div='"+payerName+"'])[1]")));
//            System.out.println();
//            System.out.println(driver.findElement(By.xpath("(//table/tbody/tr/td[15][div='"+payerName+"'])[1]")).getText());

            init.getAct().doubleClick(driver.findElement(By.xpath("(//table/tbody/tr/td[15][div='"+payerName+"'])[1]"))).perform();
        }
    }

    private void setPaymentType(String paymentType){
//Форма розрахунку
        waitForElementPresent(payFormDropdownButton);
        payFormDropdownButton.click();
        waitForElementPresent(payFormDropdownList);

        if (paymentType.equals("Готівка")){
            payFormIsCash.click();
        }
        if (paymentType.equals("Безготівковий")){
            payFormIsNonCash.click();
        }
    }

    public void setPaymentInfo(String payer){
        setPayer(payer);
    }

    public void setPaymentInfo(String payer, String paymentType){
        setPayer(payer);
        setPaymentType(paymentType);
    }

    public void setPaymentInfo(String payer, String payerName, String paymentType){
        if (payer.equals("Третя особа")){
            setPaymentType(paymentType);
        }
        setPayer(payer, payerName);

    }

//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = ".//fieldset/legend/div[.='Інформація про оплату']/../../div/div[label='Платник:']/div/input")
    private WebElement payerInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Інформація про оплату']/../../div/div[label='Платник:']/div/div[contains(@id,'combobox')]/div[contains(@class,' x-form-arrow-trigger')]")
    private WebElement payerDropdownButton;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul[li='Відправник']")
    private WebElement payerDropdownList;

    @FindBy(xpath = ".//fieldset/legend/div[.='Інформація про оплату']/../../div/div[label='Платник:']/div/div[contains(@id,'combobox')]/div[contains(@class,' x-form-clear-trigger')]")
    private WebElement payerClearButton;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[.='Відправник']")
    private WebElement payerIsSender;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[.='Отримувач']")
    private WebElement payerIsRecipient;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[.='Третя особа']")
    private WebElement payerIsThirdPerson;

    @FindBy(xpath = ".//fieldset/legend/div[.='Інформація про оплату']/../../div/div[label='Третя особа:']/div/input")
    private WebElement thirdPersonInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Інформація про оплату']/../../div/div[label='Третя особа:']/div/div/div[contains(@class,'x-form-choice-trigger')]")
    private WebElement thirdPersonCatalogueButton;

    @FindBy(xpath = ".//fieldset/legend/div[.='Інформація про оплату']/../../div/div[label='Третя особа:']/div/div/div[contains(@class,'x-form-clear-trigger')]")
    private WebElement thirdPersonClearButton;

    @FindBy(xpath = ".//fieldset/legend/div[.='Інформація про оплату']/../../div/div[label='Форма розрахунку:']/div/input")
    private WebElement payFormInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Інформація про оплату']/../../div/div[label='Форма розрахунку:']/div/div/div[contains(@class,'x-form-arrow-trigger')]")
    private WebElement payFormDropdownButton;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul[li='Готівка']")
    private WebElement payFormDropdownList;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[.='Готівка']")
    private WebElement payFormIsCash;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[.='Безготівковий']")
    private WebElement payFormIsNonCash;
//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = ".//div[contains(@class,'x-tab-active')]/em/button[span='Контрагенти']")
    private WebElement counterpartyesTab;

    @FindBy(xpath = ".//div[label='Найменування:']/div/input")
    private WebElement counterpartyNameInput;
}
