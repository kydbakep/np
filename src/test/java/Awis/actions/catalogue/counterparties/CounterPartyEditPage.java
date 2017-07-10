package Awis.actions.catalogue.counterparties;

import ClearTest.Conditions;
import ClearTest.Initializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

public class CounterPartyEditPage extends Conditions{
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);

    public CounterPartyEditPage(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void editPageClose(){
        waitForElementPresent(editTabCloser);
        editTabCloser.click();
        justWait(200);
    }

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//button/span[contains(text(),'Контрагент:')]")
    private WebElement editTab;

    @FindBy(xpath = ".//button/span[contains(text(),'Контрагент:')]/../../../a[@title='Close Tab']")
    private WebElement editTabCloser;

    @FindBy(xpath = "")
    private WebElement c;

    @FindBy(xpath = "")
    private WebElement d;

    @FindBy(xpath = "")
    private WebElement e;

    @FindBy(xpath = "")
    private WebElement f;

    @FindBy(xpath = "")
    private WebElement g;

    @FindBy(xpath = "")
    private WebElement h;

    @FindBy(xpath = "")
    private WebElement i;

    @FindBy(xpath = "")
    private WebElement j;

    @FindBy(xpath = "")
    private WebElement k;
}
