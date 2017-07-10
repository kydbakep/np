package Awis.actions.catalogue.fiscalRegistrars;

import ClearTest.Conditions;
import ClearTest.Initializer;
import ClearTest.toolbars.Toolbar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 17.02.17.
 */

public class FiscalRegistrarsPage extends Conditions{
    private Initializer init = new Initializer(driver);
    private Toolbar toolbar = new Toolbar(driver);

    public FiscalRegistrarsPage(WebDriver driver){
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
        waitForElementPresent(fiscalRegistrarsTab);
        fiscalRegistrarsTab.click();
        waitForElementNotPresent(fiscalRegistrarsTab);
    }

    public void fillFilter(String text){
        toolbar.fillFilter(text);
    }

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//table")
    private WebElement parcelStationsTable;

    @FindBy(xpath = ".//div[contains(@id,'gridview')]//tr[2]/td[4]")
    private WebElement firstRecord;

    @FindBy(xpath = ".//button/span[contains(text(),'Фіскальний реєстратор:')]/../../../a[@title='Close Tab']")
    private WebElement detailsPageTabCloser;

    @FindBy(xpath = ".//button[span='Фіскальні реєстратори']")
    private WebElement fiscalRegistrarsTab;

    @FindBy(xpath = ".//button[span='Фіскальні реєстратори']/../../a[@title='Close Tab']")
    private WebElement fiscalRegistrarsTabCloser;

//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = ".//div[contains(@id,'CityFilter-bodyEl')]/input")
    private WebElement selectionsCityInput;

    @FindBy(xpath = ".//div[contains(@id,'CityFilter-bodyEl')]/div[contains(@id,'CityFilter-triggerWrap')]")
    private WebElement selectionsCityListButton;

    @FindBy(xpath = "(.//div[contains(@id,'listEl')])[last()]")
    private WebElement selectionsCityListFrame;

    @FindBy(xpath = ".//div[contains(@id,'WarehouseFilter-bodyEl')]/input")
    private WebElement selectionsWarehouseInput;

    @FindBy(xpath = ".//div[contains(@id,'WarehouseFilter-bodyEl')]/div[contains(@id,'WarehouseFilter-triggerWrap')]")
    private WebElement selectionsWarehouseListButton;

    @FindBy(xpath = "(.//div[contains(@id,'listEl')])[last()]")
    private WebElement selectionsWarehouseListFrame;
//----------------------------------------------------------------------------------------------------------------------

}
