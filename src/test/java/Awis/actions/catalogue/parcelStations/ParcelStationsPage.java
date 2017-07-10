package Awis.actions.catalogue.parcelStations;

import Awis.Conditions;
import Awis.Initializer;
import Awis.toolbars.ToolbarTypeTwo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

public class ParcelStationsPage extends Conditions {
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);
    private ToolbarTypeTwo toolbar = new ToolbarTypeTwo(driver);

    public ParcelStationsPage(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void editRecord(){
        waitForElementPresent(firstRecord);
        init.getAct().moveToElement(firstRecord).click().perform();
        toolbar.clickEditButton();
    }


//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//table")
    private WebElement parcelStationsTable;

    @FindBy(xpath = ".//div[contains(@id,'gridview')]//tr[2]/td[4]")
    private WebElement firstRecord;

    @FindBy(xpath = ".//button/span[contains(text(),'Комірка поштомату:')]")
    private WebElement detailsPageTab;

}
