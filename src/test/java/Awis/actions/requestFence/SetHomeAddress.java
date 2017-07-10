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
 * ! Created by tober on 16.02.17.
 */

public class SetHomeAddress extends Conditions {
    private WebDriverWait wait = new WebDriverWait(driver, 5);
    Initializer init = new Initializer(driver);

    public SetHomeAddress(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setHomeAddressSender(String address){
        waitForElementPresent(senderAddressChooser);
        senderAddressChooser.click();
        System.out.println();
        System.out.println("Очікую форму...");

        waitForElementPresent(addressCleaner);
        addressCleaner.click();
        justWait(250);

        filterField.sendKeys(address);
        wait.until(ExpectedConditions.attributeToBe(filterField,"value",address));
        waitForElementPresent(addressTable);
        filterField.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.textToBePresentInElement(addressCell, address));
        init.getAct().doubleClick(driver.findElement(By.xpath("//div[text() = '" + address + "']"))).perform();

        waitForElementPresent(requestTab);
        wait.until(ExpectedConditions.attributeContains(senderAddressInput, "value", address));
    }

    public void setHomeAddressRecipient(String address){
        waitForElementPresent(recipientAddressChooser);
        recipientAddressChooser.click();
        System.out.println();
        System.out.println("Очікую форму... ");

        waitForElementPresent(addressCleaner);
        addressCleaner.click();
        justWait(250);

        filterField.sendKeys(address);
        wait.until(ExpectedConditions.attributeToBe(filterField,"value",address));
        waitForElementPresent(addressTable);
        filterField.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.textToBePresentInElement(addressCell, address));
        init.getAct().doubleClick(driver.findElement(By.xpath("//div[text() = '" + address + "']"))).perform();

        waitForElementPresent(requestTab);
        wait.until(ExpectedConditions.attributeContains(recipientAddressInput, "value", address));
    }

    @FindBy(xpath = "//input[@name='SenderAddress']/../div/div[1]")
    private WebElement senderAddressChooser;

    @FindBy(xpath = "//input[@name='RecipientAddress']/../div/div[1]")
    private WebElement recipientAddressChooser;

    @FindBy(xpath = "(.//div[contains(@id,'Grid-body')])[last()]")
    private WebElement addressTable;

    @FindBy(xpath = "//div[contains(@id, 'FilterField-triggerWrap')]")
    private WebElement addressCleaner;

    @FindBy(xpath = "//div[contains(@id, 'FilterField-bodyEl')]/input")
    private WebElement filterField;

    @FindBy(xpath = "(//tr[contains(@class, 'x-grid-row')]/td[5])[last()]")
    private WebElement addressCell;

    @FindBy(xpath = ".//fieldset/legend/div[.='Відправник']/../../div/div[label='Адреса:']/div/input")
    private WebElement senderAddressInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Отримувач']/../../div/div[label='Адреса:']/div/input")
    private WebElement recipientAddressInput;

    @FindBy(xpath = "//div[contains(@class,'x-tab-active')]/em/button[span='Заявка']")
    private WebElement requestTab;
}
