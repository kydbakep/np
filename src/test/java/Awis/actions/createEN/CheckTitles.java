package Awis.actions.createEN;

import ClearTest.Conditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 02.02.17.
 */

public class CheckTitles extends Conditions {
    public CheckTitles(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkCounterPartySenderBoxTitle(){
        waitForElementPresent(citySenderTitle);
        System.out.println();
        System.err.println(citySenderTitle.getText());
        String senserTitle = (citySenderTitle.getText().split("\\)")[0]).split(" ")[2];

        System.out.println("Місто в тайтлі: "+senserTitle);

        String senderInput = ((citySenderInput).getAttribute("value")).split(". ")[1];
        System.out.println("Місто в полі: "+senderInput);

        if (senserTitle.equals(senderInput)){
            System.out.println("Міста в тайтлі та полі відправника співпадають.");
        }
        else{
            System.err.println("Міста в тайтлі та полі відправника НЕ СПІВПАДАЮТЬ!");
        }
    }

    public void checkCounterPartyRecipientBoxTitle(){
        waitForElementPresent(cityRecipientTitle);
        System.out.println();
        System.err.println(cityRecipientTitle.getText());
        String senserTitle = (cityRecipientTitle.getText().split("\\)")[0]).split(" ")[2];

        System.out.println("Місто в тайтлі - "+senserTitle);

        String senderInput = ((cityRecipientInput).getAttribute("value")).split(". ")[1];
        System.out.println("Місто в полі - "+senderInput);

        if (senserTitle.equals(senderInput)){
            System.out.println("Міста в тайтлі та полі отримувача співпадають.");
        }
        else{
            System.err.println("Міста в тайтлі та полі отримувача НЕ СПІВПАДАЮТЬ!");
        }
    }
//========================================================================================================
    @FindBy(xpath = "//div[@id = '2CitySender-bodyEl']/input")
    private WebElement citySenderInput;

    @FindBy(xpath = "//div[contains (@id, 'CityRecipient-bodyEl')]/input")
    private WebElement cityRecipientInput;

    @FindBy(xpath = ".//div[contains(@id, 'panel-')]/label/div/span[contains(text(),'Відправник')]")
    private WebElement citySenderTitle;

    @FindBy(xpath = ".//div[contains(@id, 'panel-')]/label/div/span[contains(text(),'Отримувач')]")
    private WebElement cityRecipientTitle;
}



//            recipientCity = (cityRecipientInput.getAttribute("value").split(",")[0]);
//                    recipientCity = (recipientCity.split(". ")[1]);
