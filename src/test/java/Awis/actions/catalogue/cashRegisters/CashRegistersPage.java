package Awis.actions.catalogue.cashRegisters;

import ClearTest.Conditions;
import ClearTest.Initializer;
import ClearTest.actions.catalogue.conglomerates.CitiesPage;
import ClearTest.toolbars.ToolbarTypeTwo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Principal;
import java.security.PrivateKey;

/**
 * ! Created by tober on 17.02.17.
 */

public class CashRegistersPage extends Conditions{
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);
    private ToolbarTypeTwo toolbar = new ToolbarTypeTwo(driver);
    private ClearTest.CitiesPage city = new ClearTest.CitiesPage(driver);

    public CashRegistersPage(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void editFirstRecord(){
        waitForElementPresent(firstRecord);
        init.getAct().moveToElement(firstRecord).click().perform();
        toolbar.clickEditButton();
    }

    public void editRecord(String name){
        waitForElementPresent(firstRecord);
        init.getAct().moveToElement(driver.findElement(By.xpath(".//td[div='" + name + "']"))).click().perform();
        toolbar.clickEditButton();
    }

    public void closeTab(){
        waitForElementPresent(cashRegistersTab);
        cashRegistersTabCloser.click();
        waitForElementNotPresent(cashRegistersTab);
    }

    public void addAffiliate(String name){
        waitForElementPresent(addNewAffiliateButton);
        addNewAffiliateButton.click();
        waitForElementPresent(citiesFrame);

        citiesFilter.sendKeys(name + Keys.TAB);
        waitForElementPresent(citiesTabe);
        init.getAct().moveToElement(driver.findElement(By.xpath("(.//td[div='" + name + "'])[last()]"))).click().perform();

        waitForElementPresent(citySetButton);
        citySetButton.click();
        alertHandler();
    }

    public void removeAffiliate(String name){
        waitForElementPresent(removeAffiliateButoon);
        waitForElementPresent(citiesTabe);
        init.getAct().moveToElement(driver.findElement(By.xpath(".//td[div='"+name+"']"))).click().perform();
        removeAffiliateButoon.click();
    }

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//table")
    private WebElement parcelStationsTable;

    @FindBy(xpath = ".//div[contains(@id,'gridview')]//tr[2]/td[4]")
    private WebElement firstRecord;

    @FindBy(xpath = ".//button/span[contains(text(),'Комірка поштомату:')]")
    private WebElement detailsPageTab;

    @FindBy(xpath = ".//button[span='Каси']")
    private WebElement cashRegistersTab;

    @FindBy(xpath = ".//button[span='Каси']/../../a[@title='Close Tab']")
    private WebElement cashRegistersTabCloser;

//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = ".//button[span='Додати']")
    private WebElement addNewAffiliateButton;

    @FindBy(xpath = ".//button[span='Видалити']")
    private WebElement removeAffiliateButoon;

    @FindBy(xpath = ".//div[span='Міста']")
    private WebElement citiesFrame;

    @FindBy(xpath = "(.//div[contains(@id,'FilterField')]//input)[last()]")
    private WebElement citiesFilter;

    @FindBy(xpath = "(.//button[span='Обрати'])[last()]")
    private WebElement citySetButton;

    @FindBy(xpath = "(.//table)[last()]")
    private WebElement citiesTabe;
//----------------------------------------------------------------------------------------------------------------------

}
