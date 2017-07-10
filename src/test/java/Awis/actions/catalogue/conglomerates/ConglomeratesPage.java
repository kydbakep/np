package Awis.actions.catalogue.conglomerates;

//import ClearTest.Conditions;
//import ClearTest.Initializer;

import Awis.Conditions;
import Awis.Initializer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

public class ConglomeratesPage extends Conditions {
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);

    public ConglomeratesPage(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

//----------------------------------------------------------------------------------------------------------------------
    private void printAttribute(WebElement element){
        System.out.println();
        System.out.println("Attribute of " +element+ " is: " +element.getAttribute("value"));
    }

    private void fillFilter(String conglomerateName){
        waitForElementPresent(filterInput);
        filterCleaner.click();
        filterInput.sendKeys(conglomerateName);
        wait.until(ExpectedConditions.attributeToBe(filterInput,"value",conglomerateName));

    }

    private void waitForConglomerate(String conglomerateName){
        wait.until(ExpectedConditions.textToBe((By.xpath(".//td[div='"+conglomerateName+"']")),conglomerateName));
    }

    private void waitForConglamerateIsLoad(){
        waitForElementPresent(conglomerateDetailsTab);
        if (conglomerateDetailsTab.isDisplayed()){
            System.out.println();
            System.out.println("ОК!");
        }
        else System.err.println("Failed!");
    }

//----------------------------------------------------------------------------------------------------------------------

    public void applyFilter(String conglomerateName){
        fillFilter(conglomerateName);
        filterInput.sendKeys(Keys.ENTER);

        waitForConglomerate(conglomerateName);
        init.getAct().doubleClick(driver.findElement(By.xpath(".//td[div='"+conglomerateName+"']"))).perform();
        waitForConglamerateIsLoad();
    }

    public void applyFilter(String conglomerateName, String method) throws Exception {

        fillFilter(conglomerateName);

        if (method.equals("button")){
            System.out.println();
            System.out.println("Застосовуємо фільтр за допомогою кнопки 'ОБРАТИ'");
            selectButton.click();
        }
        if (method.equals("ENTER")){
            System.out.println();
            System.out.println("Застосовуємо фільтр за допомогою клавіші 'ENTER'");
            filterInput.sendKeys(Keys.ENTER);
        }

        if (method.equals("TAB")){
            System.out.println();
            System.out.println("Застосовуємо фільтр за допомогою клавіші 'TAB'");
            filterInput.sendKeys(Keys.TAB);
        }

        justWait(250);
        init.getAct().doubleClick(driver.findElement(By.xpath(".//td[div='"+conglomerateName+"']"))).perform();
        waitForConglamerateIsLoad();
    }

    public void closeTab(){
        waitForElementPresent(conglomeratesTabCloser);
        conglomeratesTabCloser.click();
        waitForElementNotPresent(conglomeratesTabCloser);
    }

    public void nextAndBack(){
        waitForElementPresent(nextPageButton);
        nextPageButton.click();
        waitForElementPresent(nameCellOne);
        String cellInfo = nameCellOne.getText();

        System.out.println();
        System.out.println(cellInfo);

        waitForElementPresent(prevPageButton);
        prevPageButton.click();

        waitForElementPresent(nameCellOne);
        String cellInfo2 = nameCellOne.getText();

        System.out.println();
        System.out.println(cellInfo2);

        if (cellInfo.equals(cellInfo2)){
            System.err.println("Значення першої ячейки на 1 та на 2 сторінці співпадають!");
        }else{
            System.out.println("Все ОК, значення різні!");
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//button[span='Конгломерати']")
    private WebElement conglomeratesTab;

    @FindBy(xpath = ".//button[span='Конгломерати']//../../a[@title='Close Tab']")
    private WebElement conglomeratesTabCloser;

    @FindBy(xpath = ".//button/span[contains(text(),'Конгломерати:')]")
    private WebElement conglomerateDetailsTab;

    @FindBy(xpath = ".//button[span='Обрати']")
    private WebElement selectButton;

    @FindBy(xpath = ".//div[label='Фільтр:']//input")
    private WebElement filterInput;

    @FindBy(xpath = ".//div[label='Фільтр:']//div[contains(@id,'FilterField-triggerWrap')]/div[@role='button']")
    private WebElement filterCleaner;

    @FindBy(xpath = ".//button[span='Створити']")
    private WebElement createButton;

    @FindBy(xpath = ".//button[span='Видалити']")
    private WebElement deleteButton;

    @FindBy(xpath = ".//button[span='Редагувати']")
    private WebElement editButton;

    @FindBy(xpath = ".//button[span='Довідка']")
    private WebElement helpButton;

    @FindBy(xpath = ".//div[h3='Гарячі клавіші']/..")
    private WebElement helpFrame;

    @FindBy(xpath = ".//div[h3='Гарячі клавіші']/..//div/img[@class='x-tool-close']")
    private WebElement helpFrameCloser;

    @FindBy(xpath = ".//button[@data-qtip='Перша сторінка']")
    private WebElement firstPageButton;

    @FindBy(xpath = ".//button[@data-qtip='Наступна сторінка']")
    private WebElement nextPageButton;

    @FindBy(xpath = ".//button[@data-qtip='Попередня сторінка']")
    private WebElement prevPageButton;

    @FindBy(xpath = ".//button[@data-qtip='Остання сторінка']")
    private WebElement lastPageButton;

    @FindBy(xpath = ".//button[@data-qtip='Освіжити']")
    private WebElement reloadPageButton;

    @FindBy(xpath = ".//table[contains(@class,'x-grid-table')]/tbody/tr[2]/td[4]")
    private WebElement nameCellOne;

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//div[contains(@id,'Grid-body')]//table/tbody")
    private WebElement resultTable;

    @FindBy(xpath = "")
    private WebElement b;

    @FindBy(xpath = "")
    private WebElement c;

    @FindBy(xpath = "")
    private WebElement d;

//----------------------------------------------------------------------------------------------------------------------

}
