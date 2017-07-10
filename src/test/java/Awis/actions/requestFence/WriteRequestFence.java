package Awis.actions.requestFence;

import Awis.Conditions;
import Awis.Initializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

public class WriteRequestFence extends Conditions {
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);

    public WriteRequestFence(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//button[span='Записати']")
    private WebElement writeButton;

    public void writeRequest(){
        waitForElementPresent(writeButton);
        writeButton.click();
    }
}
