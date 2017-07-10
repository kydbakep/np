package Awis.actions.requestFence;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ! Created by tober on 15.02.17.
 */

public class SetRecipientInfo {

    @FindBy(xpath = ".//div[label = 'Місто:']")
    private WebElement cityRecipientInput;
}
