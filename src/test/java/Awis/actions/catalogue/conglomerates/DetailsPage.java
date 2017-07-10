package Awis.actions.catalogue.conglomerates;

import ClearTest.Conditions;
import ClearTest.Initializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

public class DetailsPage extends Conditions{
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);

    public DetailsPage(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void closeTab(){
        waitForElementPresent(conglomeratesDetailsTabCloser);
        conglomeratesDetailsTabCloser.click();
    }

    public void write(){
        waitForElementPresent(writeButton);
        writeButton.click();
    }

    public void addNew(){
        waitForElementPresent(addButton);
        addButton.click();
    }

    public void pressOK(){
        waitForElementPresent(okButton);
        okButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(String.valueOf(detailsPageTab))));
    }

    @FindBy(xpath = ".//button/span[contains(text(),'Конгломерати:')]")
    private WebElement conglomerateDetailsTab;

    @FindBy(xpath = ".//button/span[contains(text(),'Конгломерати:')]/../../../a[@title='Close Tab']")
    private WebElement conglomeratesDetailsTabCloser;

    @FindBy(xpath = ".//button[span='Записати']")
    private WebElement writeButton;

    @FindBy(xpath = ".//button[span='Додати']")
    private WebElement addButton;

    @FindBy(xpath = ".//button[span='Вилучити']")
    private WebElement removeButton;

    @FindBy(xpath = ".//button[span='OK']")
    private WebElement okButton;

    @FindBy(xpath = ".//button/span[contains(text(),'Конгломерати:')]")
    private WebElement detailsPageTab;

}
