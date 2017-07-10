package Awis.toolbars;

import ClearTest.Conditions;
import ClearTest.Initializer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

public class CounterpatiesPage extends Conditions{
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);
    private ToolbarTypeOne toolbar = new ToolbarTypeOne(driver);

    public CounterpatiesPage(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setCounterparty(String name){
        waitForElementPresent(counterpartiesTab);
        waitForElementPresent(counterpartiesTable);
        filterInput.sendKeys(name + Keys.TAB);
        waitForElementPresent(counterpartiesTable);
        init.getAct().moveToElement(driver.findElement(By.xpath("(//div[.='" + name + "'])[last()]"))).click().perform();
        choiseButton.click();
    }


//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "(.//table)[last()]")
    private WebElement counterpartiesTable;

    @FindBy(xpath = "//button[span='Організації']")
    private WebElement counterpartiesTab;

    @FindBy(xpath = ".//button[span='Організації']/../../a[@title='Close Tab']")
    private WebElement counterpartiesTabCloser;

    @FindBy(xpath = "(//span[.='Обрати'])[last()]")
    private WebElement choiseButton;

    @FindBy(xpath = "(//span[.='Редагувати'])[last()]")
    private WebElement editButton;

//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = ".//div[contains(@id,'FilterField-bodyEl')]//input")
    private WebElement filterInput;

//----------------------------------------------------------------------------------------------------------------------

}
