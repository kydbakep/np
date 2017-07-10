package Awis.actions.catalogue.fiscalRegistrars;

import Awis.CitiesPage;
import Awis.Conditions;
import Awis.Initializer;
import Awis.TerminalsPage;
import Awis.toolbars.CounterpatiesPage;
import Awis.toolbars.Toolbar;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 17.02.17.
 */

public class FiscalRegistrarsDetailsPage extends Conditions {
    private Initializer init = new Initializer(driver);
    private Toolbar toolbar = new Toolbar(driver);
    private CitiesPage city = new CitiesPage(driver);
    private TerminalsPage warehouse = new TerminalsPage(driver);
    CounterpatiesPage counterpaty = new CounterpatiesPage(driver);

    public FiscalRegistrarsDetailsPage(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pressOK(){
        waitForElementPresent(buttonOK);
        buttonOK.click();
        waitForElementNotPresent(detailsPageTab);
    }

    public String readCode(){
        waitForElementPresent(codeInput);
        System.out.println("Attr "+codeInput.getAttribute("value"));
        return codeInput.getAttribute("value");
    }

    public void fillRRO(String text){
        waitForElementPresent(znRRO);
        znRRO.clear();
        justWait(200);
        znRRO.sendKeys(text + Keys.TAB);
    }

    public void setCity(String name){
        waitForElementPresent(cityInput);
        if (!cityInput.getAttribute("value").equals(name)) {
            waitForElementPresent(citiesSelectButton);
            citiesSelectButton.click();
            city.setCity(name);
        } else {
            System.out.println(cityInput.getAttribute("value"));
        }
    }

    public void setWarehouse(String number, String type){
        waitForElementPresent(warehouseSelectButton);
        warehouseSelectButton.click();
        warehouse.setWarehouse(number);
        warehouse.setWarehouseType(type);
    }

    public void setCounterparty(String name){
        waitForElementPresent(organisationSelectButton);
        organisationSelectButton.click();
        counterpaty.setCounterparty(name);
    }

//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = "//button[span='Ok']")
    private WebElement buttonOK;

    @FindBy(xpath = ".//button/span[contains(text(),'Фіскальний реєстратор:')]")
    private WebElement detailsPageTab;

    @FindBy(xpath = "//input[@name='Code']")
    private WebElement codeInput;

    @FindBy(xpath = "//input[@name='Description']")
    private WebElement znRRO;

    @FindBy(xpath = "//input[@name='City']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@name='City']/..//div[@role='button']")
    private WebElement citiesSelectButton;

    @FindBy(xpath = "//input[@name='Warehouse']/..//div")
    private WebElement warehouseInput;

    @FindBy(xpath = "//input[@name='Warehouse']/..//div[@role='button'][contains(@class,'form-choice')]")
    private WebElement warehouseSelectButton;

    @FindBy(xpath = "//input[@name='Warehouse']/..//div[@role='button'][contains(@class,'form-search')]")
    private WebElement warehouseFindButton;

    @FindBy(xpath = "//input[@name='Organization']")
    private WebElement organisationInput;

    @FindBy(xpath = "//input[@name='Organization']/..//div[@role='button'][contains(@class,'form-choice')]")
    private WebElement organisationSelectButton;

    @FindBy(xpath = "//input[@name='Organization']/..//div[@role='button'][contains(@class,'form-search')]")
    private WebElement organisationFindButton;
//----------------------------------------------------------------------------------------------------------------------

}
