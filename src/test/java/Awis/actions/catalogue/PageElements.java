package Awis.actions.catalogue;

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

public class PageElements extends Conditions{
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);

    public PageElements(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "")
    private WebElement a;

    @FindBy(xpath = "")
    private WebElement b;

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
