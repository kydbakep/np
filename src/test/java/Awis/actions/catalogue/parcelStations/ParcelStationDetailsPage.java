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

public class ParcelStationDetailsPage extends Conditions {
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);
    private ToolbarTypeTwo toolbarTypeTwo = new ToolbarTypeTwo(driver);

    public ParcelStationDetailsPage(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCellType(String type){
        waitForElementPresent(cellTypeSelectorButton);
        init.getAct().moveToElement(cellTypeSelectorButton).click().perform();
        System.out.println();
        if (type.equals("A")){
            waitForElementPresent(listFrame);
            waitForElementPresent(cellTypePostA);
            cellTypePostA.click();
        }
        if (type.equals("B")){
            waitForElementPresent(listFrame);
            waitForElementPresent(cellTypePostB);
            cellTypePostB.click();
        }
        if (type.equals("C")){
            waitForElementPresent(listFrame);
            waitForElementPresent(cellTypePostC);
            cellTypePostC.click();
        }
        if (type.equals("Small")){
            waitForElementPresent(listFrame);
            waitForElementPresent(cellTypeSmall);
            cellTypeSmall.click();
        }
        if (type.equals("Medium")){
            waitForElementPresent(listFrame);
            waitForElementPresent(cellTypeMedium);
            cellTypeMedium.click();
        }
        if (type.equals("Large")){
            waitForElementPresent(listFrame);
            waitForElementPresent(cellTypeLarge);
            cellTypeLarge.click();
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//input[@name='Description']")
    private WebElement cellNameInput;

    @FindBy(xpath = ".//input[@name='City']")
    private WebElement citySelectorInput;
    @FindBy(xpath = ".//div[contains(@id,'City-triggerWrap')]/div[contains(@class,'x-form-choice')]")
    private WebElement citySelectorButton;
    @FindBy(xpath = ".//div[contains(@id,'City-triggerWrap')]/div[contains(@class,'x-form-clear')]")
    private WebElement citySelectorCleaner;

    @FindBy(xpath = ".//input[@name='Owner']")
    private WebElement warehouseSelectorInput;
    @FindBy(xpath = ".//div[contains(@id,'Owner-triggerWrap')]/div[contains(@class,'x-form-choice')]")
    private WebElement warehouseSelectorButton;
    @FindBy(xpath = ".//div[contains(@id,'Owner-triggerWrap')]/div[contains(@class,'x-form-clear')]")
    private WebElement warehouseSelectorCleaner;


    @FindBy(xpath = ".//input[@name='CellNumber']")
    private WebElement parcelStationIDinput;

    @FindBy(xpath = ".//input[@name='CellType']")
    private WebElement cellTypeInput;
    @FindBy(xpath = ".//div[contains(@id,'CellType-triggerWrap')]/div[@role='button']")
    private WebElement cellTypeSelectorButton;
    @FindBy(xpath = ".//div[@role='listbox']")
    private WebElement listFrame;
    @FindBy(xpath = ".//div[@role='listbox']//li[.='InPost A']")
    private WebElement cellTypePostA;
    @FindBy(xpath = ".//div[@role='listbox']//li[.='InPost B']")
    private WebElement cellTypePostB;
    @FindBy(xpath = ".//div[@role='listbox']//li[.='InPost C']")
    private WebElement cellTypePostC;
    @FindBy(xpath = ".//div[@role='listbox']//li[.='Small']")
    private WebElement cellTypeSmall;
    @FindBy(xpath = ".//div[@role='listbox']//li[.='Medium']")
    private WebElement cellTypeMedium;
    @FindBy(xpath = ".//div[@role='listbox']//li[.='Large']")
    private WebElement cellTypeLarge;

}
