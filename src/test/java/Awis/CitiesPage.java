package Awis;

import Awis.toolbars.ToolbarTypeOne;
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

public class CitiesPage extends Conditions{
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);
    private ToolbarTypeOne toolbar = new ToolbarTypeOne(driver);

    public CitiesPage(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setCity(String city){
        waitForElementPresent(citiesTab);
        waitForElementPresent(citiesTable);

        toolbar.fillFilterField(city + Keys.TAB);
        waitForElementPresent(citiesTable);

        init.getAct().moveToElement(driver.findElement(By.xpath("(.//td[div='"+city+"'])[last()]"))).click().perform();

        toolbar.clickChoiceButton();
        waitForElementNotPresent(citiesTab);
    }



//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "(.//table)[last()]")
    private WebElement citiesTable;

    @FindBy(xpath = ".//button[span='Міста']")
    private WebElement citiesTab;
}
