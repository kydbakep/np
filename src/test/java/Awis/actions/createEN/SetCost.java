package Awis.actions.createEN;

import Awis.Conditions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 06.02.17.
 */

public class SetCost extends Conditions {
    public SetCost(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setCost(String cost){
        System.out.println();
        System.out.println("Встановлюю оголошену вартість...");
        waitForElementPresent(costInput);
        costInput.sendKeys("0"); justWait(350); costInput.clear();
        costInput.sendKeys(cost+ Keys.TAB);
        justWait(250);
        if (costInput.getAttribute("value").length()>0){
            System.out.println();
            System.out.println("OK.");
            if (cost.equals(costInput.getAttribute("value"))){
                System.out.println("Встановлено коректно: "+cost);
            }
            else {
                System.err.println("Встановлено не коректно!");
                System.err.println("Вводили: "+cost);
                System.err.println("В полі: "+costInput.getAttribute("value"));
            }
        } else {
            System.err.println("Не можу встановити оголошену вартість!");
        }
    }

    @FindBy(xpath = ".//input[@name='Cost']")
    private WebElement costInput;
}
