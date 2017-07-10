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

public class ToolbarTypeOne extends Conditions {
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);

    public ToolbarTypeOne(WebDriver driver){
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

    @FindBy(xpath = ".//div[contains(@id,'pagingtoolbar')]")
    private WebElement toolbarFrame;

    @FindBy(xpath = "(.//div[contains(@id,'pagingtoolbar')]//div[contains(@id,'choiceButton')])[last()]//button")
    private WebElement choiceButton;

    @FindBy(xpath = ".//div[contains(@id,'pagingtoolbar')]/div/div[contains(@id,'FilterField')]//input")
    private WebElement filterFieldInput;

    @FindBy(xpath = ".//div[contains(@id,'pagingtoolbar')]//button[span='Створити']")
    private WebElement createButton;

    @FindBy(xpath = ".//div[contains(@id,'pagingtoolbar')]//button[span='Видалити']")
    private WebElement removeButton;

    @FindBy(xpath = ".//div[contains(@id,'pagingtoolbar')]//div[contains(@id,'editButton')]")
    private WebElement editButton;

    @FindBy(xpath = ".//div[contains(@id,'pagingtoolbar')]//button[span='Масове створення']")
    private WebElement massCreateButton;

    @FindBy(xpath = ".//div[contains(@id,'pagingtoolbar')]//div[contains(@id,'buttonHelp')]")
    private WebElement helpButton;

    @FindBy(xpath = ".//div[contains(@id,'pagingtoolbar')]//button[@data-qtip='Перша сторінка']")
    private WebElement firstPageButton;

    @FindBy(xpath = ".//div[contains(@id,'pagingtoolbar')]//button[@data-qtip='Остання сторінка']")
    private WebElement lastPageButton;

    @FindBy(xpath = ".//div[contains(@id,'pagingtoolbar')]//button[@data-qtip='Попередня сторінка']")
    private WebElement previousPageButton;

    @FindBy(xpath = ".//div[contains(@id,'pagingtoolbar')]//button[@data-qtip='Наступна сторінка']")
    private WebElement nextPageButton;

    @FindBy(xpath = ".//div[contains(@id,'pagingtoolbar')]//button[@data-qtip='Освіжити']")
    private WebElement refreshPageButton;

    @FindBy(xpath = ".//div[contains(@id,'pagingtoolbar')]//input[@name='inputItem']")
    private WebElement pageNumberInput;

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//button[span='Записати']")
    private WebElement writeButton;

    @FindBy(xpath = ".//button[span='OK']")
    private WebElement okButton;

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//table")
    private WebElement table;
}
