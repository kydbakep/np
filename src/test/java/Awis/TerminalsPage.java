package Awis;

import ClearTest.toolbars.ToolbarTypeOne;
import ClearTest.toolbars.ToolbarTypeTwo;
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

public class TerminalsPage extends Conditions{
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);
    private ToolbarTypeOne toolbar = new ToolbarTypeOne(driver);

    public TerminalsPage(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setWarehouse(String number){
        waitForElementPresent(terminalsTab);
        waitForElementPresent(terminalsTable);

        toolbar.fillFilterField(number + Keys.ENTER);
    }

    public void setWarehouseType(String type){
        waitForElementPresent(terminalsTable);
        if (type.equals("Відділення") || type.equals("відділення")){
            init.getAct().moveToElement(driver.findElement(By.xpath("(.//td/div[contains(text(),'Відділення')])[last()]"))).click().perform();
        } else if (type.equals("Термінал") || type.equals("термінал")){
            init.getAct().moveToElement(driver.findElement(By.xpath("(.//td/div[contains(text(),'Термінал')])[last()]"))).click().perform();
        }
        choiseButton.click();
    }



//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "(.//table)[last()]")
    private WebElement terminalsTable;

    @FindBy(xpath = ".//button[span='Склади']")
    private WebElement terminalsTab;

    @FindBy(xpath = ".//button[span='Склади']/../../a[@title='Close Tab']")
    private WebElement terminalsTabCloser;

    @FindBy(xpath = "(//span[.='Обрати'])[last()]")
    private WebElement choiseButton;
}
