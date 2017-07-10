package Awis.toolbars;

import Awis.Conditions;
import Awis.Initializer;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

public class ToolbarTypeTwo extends Conditions {
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);

    public ToolbarTypeTwo(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkForTableIsLoad(){
        waitForElementPresent(toolbarFrame);
        if (toolbarFrame.isDisplayed()){
            System.out.println();
            System.out.println("OK. Toolbar is here!");
        } else System.err.println("Toolbar loading failed!");
    }

    public void clickChoiceButton(){
        waitForElementPresent(choiceButton);
        choiceButton.click();
    }

    public void fillFilterField(String text){
        waitForElementPresent(filterFieldInput);
        init.getAct().moveToElement(filterFieldInput).perform();
        filterFieldInput.sendKeys(text + Keys.TAB);
    }

    public void clickCreateButton(){
        waitForElementPresent(createButton);
        createButton.click();
    }

    public void clickRemoveButton(){
        waitForElementPresent(removeButton);
        removeButton.click();
    }

    public void clickEditButton(){
        waitForElementPresent(editButton);
        editButton.click();
    }

    public void clickHelpButton(){
        waitForElementPresent(helpButton);
        helpButton.click();
    }

    public void clickFirstPageButton(){
        waitForElementPresent(firstPageButton);
        firstPageButton.click();
    }

    public void clickLastPageButton(){
        waitForElementPresent(lastPageButton);
        lastPageButton.click();
    }

    public void clickPreviousPageButton(){
        waitForElementPresent(previousPageButton);
        previousPageButton.click();
    }

    public void clickNextPageButton(){
        waitForElementPresent(nextPageButton);
        nextPageButton.click();
    }

    public void clickRefreshPageButton(){
        waitForElementPresent(refreshPageButton);
        refreshPageButton.click();
    }

    public void fillPageNumberInput(String number){
        waitForElementPresent(pageNumberInput);
        waitForElementPresent(table);
        pageNumberInput.clear();
        pageNumberInput.sendKeys(number + Keys.ENTER);
    }

//----------------------------------------------------------------------------------------------------------------------
    public void clickOKButton(){
        waitForElementPresent(okButton);
        okButton.click();
    }

    public void clickWriteButton(){
        waitForElementPresent(writeButton);
        writeButton.click();
    }

//----------------------------------------------------------------------------------------------------------------------

    public void openHelpFrame(){
        waitForElementPresent(helpButton);
        helpButton.click();
    }
    public void closeHelpFrame(){
        waitForElementPresent(helpFrame);
        waitForElementPresent(helpFrameCloser);
        helpFrameCloser.click();
    }

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//div[contains(@id,'Toolbar')]")
    private WebElement toolbarFrame;

    @FindBy(xpath = "(.//div[contains(@id,'Toolbar')]//div[contains(@id,'choiceButton')])[last()]")
    private WebElement choiceButton;

    @FindBy(xpath = ".//div[contains(@id,'Toolbar')]/div/div[contains(@id,'FilterField')]//input")
    private WebElement filterFieldInput;

    @FindBy(xpath = ".//div[contains(@id,'Toolbar')]//button[span='Створити']")
    private WebElement createButton;

    @FindBy(xpath = ".//div[contains(@id,'Toolbar')]//button[span='Видалити']")
    private WebElement removeButton;

    @FindBy(xpath = ".//div[contains(@id,'Toolbar')]//div[contains(@id,'editButton')]")
    private WebElement editButton;

    @FindBy(xpath = ".//div[contains(@id,'Toolbar')]//button[span='Масове створення']")
    private WebElement massCreateButton;

    @FindBy(xpath = ".//div[contains(@id,'Toolbar')]//div[contains(@id,'buttonHelp')]")
    private WebElement helpButton;

    @FindBy(xpath = ".//div[contains(@id,'Toolbar')]//button[@data-qtip='Перша сторінка']")
    private WebElement firstPageButton;

    @FindBy(xpath = ".//div[contains(@id,'Toolbar')]//button[@data-qtip='Остання сторінка']")
    private WebElement lastPageButton;

    @FindBy(xpath = ".//div[contains(@id,'Toolbar')]//button[@data-qtip='Попередня сторінка']")
    private WebElement previousPageButton;

    @FindBy(xpath = ".//div[contains(@id,'Toolbar')]//button[@data-qtip='Наступна сторінка']")
    private WebElement nextPageButton;

    @FindBy(xpath = ".//div[contains(@id,'Toolbar')]//button[@data-qtip='Освіжити']")
    private WebElement refreshPageButton;

    @FindBy(xpath = ".//div[contains(@id,'Toolbar')]//input[@name='inputItem']")
    private WebElement pageNumberInput;

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//button[span='Записати']")
    private WebElement writeButton;

    @FindBy(xpath = ".//button[span='OK']")
    private WebElement okButton;

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//div[contains(@id,'tooltip')]//h3[.='Гарячі клавіші']")
    private WebElement helpFrame;

    @FindBy(xpath = ".//div[contains(@id,'tooltip')]//img[contains(@class,'close')]")
    private WebElement helpFrameCloser;

    @FindBy(xpath = ".//table")
    private WebElement table;
}
