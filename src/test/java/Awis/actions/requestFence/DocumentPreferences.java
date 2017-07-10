package Awis.actions.requestFence;

import Awis.Conditions;
import Awis.Initializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

public class DocumentPreferences extends Conditions {
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);

    public DocumentPreferences(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

//----------------------------------------------------------------------------------------------------------------------

    public void getNumber(){
        waitForElementPresent(documentNumberInput);
        System.out.println();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(documentNumberInput,"value"));
        System.out.println("Номер заявки: "+documentNumberInput.getAttribute("value"));
    }

//----------------------------------------------------------------------------------------------------------------------

    public void getDate(){
        waitForElementPresent(dateExecuteInput);
        System.out.println();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dateExecuteInput,"value"));
        System.out.println("Дата виконання: "+dateExecuteInput.getAttribute("value"));
    }

    public void setDate(){
        waitForElementPresent(dateExecuteInput);
        dateExecuteInput.getAttribute("value");
        System.out.println(dateExecuteInput.getAttribute("value"));
    }

//----------------------------------------------------------------------------------------------------------------------

    public void getInterval(){
        waitForElementPresent(timeIntervalInput);
        System.out.println();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(timeIntervalInput,"value"));
        System.out.println("Часовий інтервал: "+timeIntervalInput.getAttribute("value"));
    }

    public void setInterval(String interval){
        waitForElementPresent(timeIntervalButton);
        timeIntervalInput.getAttribute("value");
        timeIntervalButton.click();
        waitForElementPresent(withoutIntervals);

        if (interval.equals("9-21")){
            from9to21.click();
        }
        if (interval.equals("9-18")){
            from9to18.click();
        }
        if (interval.equals("9-17")){
            from9to17.click();
        }
        if (interval.equals("15-18")){
            from15to18.click();
        }
        if (interval.equals("18-21")){
            from18to21.click();
        }
        if (interval.equals("without")){
            withoutIntervals.click();
        }

    }

//----------------------------------------------------------------------------------------------------------------------

    public void getStatus(){
        waitForElementPresent(statusInput);
        System.out.println();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(statusInput,"value"));
        System.out.println("Статус: "+statusInput.getAttribute("value"));
    }

    public void setStatus(){
        waitForElementPresent(statusInput);
        statusInput.getAttribute("value");
        System.out.println(statusInput.getAttribute("value"));
    }

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//fieldset/legend/div[.='Властивості документа']/../..//div[label[.='Номер:']]//input")
    private WebElement documentNumberInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Властивості документа']/../..//div[label[.='Дата виконання:']]//input")
    private WebElement dateExecuteInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Властивості документа']/../..//div[label[.='Дата виконання:']]//div[@role='button']")
    private WebElement dateExecuteButton;

    @FindBy(xpath = ".//fieldset/legend/div[.='Властивості документа']/../..//div[label[.='Статус:']]//input")
    private WebElement statusInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Властивості документа']/../..//div[label[.='Статус:']]//div[@role='button']")
    private WebElement statusButton;

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//fieldset/legend/div[.='Властивості документа']/../..//div[label[.='Часовий інтервал:']]//input[not(@name='TimeInterval')]")
    private WebElement timeIntervalInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Властивості документа']/../..//div[label[.='Часовий інтервал:']]//div[@role='button']")
    private WebElement timeIntervalButton;

    @FindBy(xpath = ".//li[.='09:00 - 21:00']")
    private WebElement from9to21;

    @FindBy(xpath = ".//li[.='09:00 - 18:00']")
    private WebElement from9to18;

    @FindBy(xpath = ".//li[.='09:00 - 17:00']")
    private WebElement from9to17;

    @FindBy(xpath = ".//li[.='15:01 - 18:00']")
    private WebElement from15to18;

    @FindBy(xpath = ".//li[.='18:01 - 21:00']")
    private WebElement from18to21;

    @FindBy(xpath = ".//li[.='Без часових інтервалів']")
    private WebElement withoutIntervals;

//----------------------------------------------------------------------------------------------------------------------

}
