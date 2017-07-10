package Awis.actions.catalogue.cashRegisters;

import Awis.CitiesPage;
import Awis.Conditions;
import Awis.Initializer;
import Awis.TerminalsPage;
import Awis.toolbars.ToolbarTypeTwo;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

public class CashRegistersDetailsPage extends Conditions {
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);
    private ToolbarTypeTwo toolbarTypeTwo = new ToolbarTypeTwo(driver);
    private CitiesPage cities = new CitiesPage(driver);
    private TerminalsPage terminal = new TerminalsPage(driver);

    public CashRegistersDetailsPage(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setCode(String code){
        waitForElementPresent(codeInput);
        codeInput.clear();
        codeInput.sendKeys(code + Keys.TAB);
    }
    public void setDescription(String description){
        waitForElementPresent(descriptionInput);
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
    }
    public void setCity(String city){
        waitForElementPresent(citySelectorButton);
        citySelectorButton.click();
        cities.setCity(city);
    }
    public void setWarehouse(String type, String number){
        waitForElementPresent(warehouseSelectorButton);
        warehouseSelectorButton.click();
        terminal.setWarehouse(number);
        terminal.setWarehouseType(type);
    }

    public void setNumber(String number){
        waitForElementPresent(numberInput);
        numberInput.clear();
        numberInput.sendKeys(number);
    }
    public void transformPermission(String status){
        if (status.equals("yes") || status.equals("да") || status.equals("так")) {
            transformCheckbox.click();
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//input[@name='Code']")
    private WebElement codeInput;

    @FindBy(xpath = ".//input[@name='Description']")
    private WebElement descriptionInput;

    @FindBy(xpath = ".//input[@name='City']")
    private WebElement citySelectorInput;
    @FindBy(xpath = ".//div[contains(@id,'City-triggerWrap')]/div[contains(@class,'x-form-choice')]")
    private WebElement citySelectorButton;
    @FindBy(xpath = ".//div[contains(@id,'City-triggerWrap')]/div[contains(@class,'x-form-clear')]")
    private WebElement citySelectorCleaner;

    @FindBy(xpath = ".//input[@name='Owner']")
    private WebElement warehouseSelectorInput;
    @FindBy(xpath = ".//div[contains(@id,'Owner-triggerWrap')]/div[contains(@class,'x-form-choice')]")
    private WebElement warehouseSelectorButton;
    @FindBy(xpath = ".//div[contains(@id,'Owner-triggerWrap')]/div[contains(@class,'x-form-clear')]")
    private WebElement warehouseSelectorCleaner;

    @FindBy(xpath = ".//input[@name='Number']")
    private WebElement numberInput;

    @FindBy(xpath = ".//div[contains(@id,'checkboxfield')]/input")
    private WebElement transformCheckbox;

}
