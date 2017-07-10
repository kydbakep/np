package Awis.actions.createEN;

import Awis.Conditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *! Created by tober on 03.02.17.
 */

public class InitializeForms extends Conditions {
    public InitializeForms(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void initializeForms(){
        waitForElementPresent(senderAddressChooser);
        senderAddressChooser.click();
        waitForElementPresent(addressTabCloser);
        addressTabCloser.click();
        waitForElementPresent(senderAddressChooser);
    }

    @FindBy(xpath = "//input[@name='SenderAddress']/../div/div[1]")
    private WebElement senderAddressChooser;

    @FindBy(xpath = "//a[@title='Close Tab']/../em/button/span[contains(text(),'Адреси')]/../../../a")
    private WebElement addressTabCloser;
}
