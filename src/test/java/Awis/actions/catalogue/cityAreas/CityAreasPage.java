package Awis.actions.catalogue.cityAreas;

import ClearTest.Conditions;
import ClearTest.Initializer;
import ClearTest.toolbars.ToolbarTypeTwo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

public class CityAreasPage extends Conditions{
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);
    private ToolbarTypeTwo toolbar = new ToolbarTypeTwo(driver);
    private ClearTest.CitiesPage city = new ClearTest.CitiesPage(driver);

    public CityAreasPage(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void testHelp(){
        toolbar.clickHelpButton();
        justWait(1000);

    }


//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "(.//table)[last()]")
    private WebElement citiesTable;

    @FindBy(xpath = "(.//div[contains(@id,'gridview')]//tr[2]/td[4])[last()]")
    private WebElement firstRecord;

//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = ".//button[span='Додати']")
    private WebElement addNewAffiliateButton;

    @FindBy(xpath = ".//button[span='Видалити']")
    private WebElement removeAffiliateButoon;

    @FindBy(xpath = ".//button[span='Райони міста']")
    private WebElement citiesAreasTab;

    @FindBy(xpath = "(.//div[contains(@id,'FilterField')]//input)[last()]")
    private WebElement citiesFilter;

    @FindBy(xpath = "(.//button[span='Обрати'])[last()]")
    private WebElement citySetButton;
//----------------------------------------------------------------------------------------------------------------------

}
