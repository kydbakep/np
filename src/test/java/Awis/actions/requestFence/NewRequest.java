package Awis.actions.requestFence;

import Awis.Conditions;
import Awis.Initializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 15.02.17.
 */

public class NewRequest extends Conditions {
    private Initializer init = new Initializer(driver);

    public NewRequest(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createRequest(){
        waitForElementPresent(createRequestButton);
        System.out.println();
        if (createRequestButton.isDisplayed()){
            System.out.println("Натискаємо кнопку 'Створити'");
            createRequestButton.click();
        } else{
            System.out.println();
            System.err.println("Не бачу кнопку 'Створити'");
        }
        waitForElementPresent(requestTab);
        System.out.println();
        System.out.println("Очікуємо на вкладку 'Заявка...'");
        if (requestTab.isDisplayed()){
            System.out.println("OK.");
        }else{
            System.out.println();
            System.err.println("Не бачу вкладку 'Заявка'");
        }
    }

    @FindBy(xpath = "//button[span = 'Створити']")
    private WebElement createRequestButton;

    @FindBy(xpath = ".//button[span = 'Заявка']")
    private WebElement requestTab;
}
