package Awis.actions.requestFence;

import ClearTest.Conditions;
import ClearTest.Initializer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 15.02.17.
 */

public class SetCity extends Conditions {

    private WebDriverWait wait = new WebDriverWait(driver, 5);
    Initializer init = new Initializer(driver);

    public SetCity(WebDriver driver){
    Conditions.driver = driver;
    PageFactory.initElements(driver, this);
    }
//======================================================================================================================
//                                          Set CITY (Sender)
//======================================================================================================================

    public void SetSenderCity(String cityName, String cityFullName) throws Exception {
        System.out.println();
        System.out.println("Обираємо місто відправника...");
        String boxCity = "(.//div[contains(@id,'boundlist')]/ul/li[.='"+cityName+"'])[1]";

        System.out.println("RECIPIENT: "+cityRecipientInput.getAttribute("value"));

        waitForElementPresent(citySenderInput);
        citySenderInput.sendKeys(cityName+"  "+ Keys.BACK_SPACE+Keys.BACK_SPACE);

        wait.until(ExpectedConditions.textToBe(By.xpath(boxCity),cityName));
        driver.findElement(By.xpath(boxCity)).click();

        System.out.println();
        System.out.println("Обрано місто відправника: "+citySenderInput.getAttribute("value"));
    }

//======================================================================================================================
//                                          Set CITY (Recipient)
//======================================================================================================================

    public void SetRecipientCity(String cityName, String cityFullName) throws Exception {
        String box;
        System.out.println();
        System.out.println("Обираємо місто отримувача...");
        String boxCity = "(.//div[contains(@id,'boundlist')]/ul/li[.='"+cityName+"'])[1]";

        System.out.println("SENDER: "+citySenderInput.getAttribute("value"));
        if (citySenderInput.getAttribute("value").equals(cityName)){
            box = "(.//div[contains(@id,'boundlist')]/ul/li[.='"+cityName+"'])[2]";
        } else box = boxCity;
        System.out.println("BOX "+box);

        waitForElementPresent(cityRecipientInput);
        cityRecipientInput.sendKeys(cityName+"  "+ Keys.BACK_SPACE+Keys.BACK_SPACE);

        wait.until(ExpectedConditions.textToBe(By.xpath(box),cityName));

        driver.findElement(By.xpath(box)).click();

        System.out.println();
        System.out.println("Обрано місто отримувача: "+cityRecipientInput.getAttribute("value"));
    }

//======================================================================================================================
    @FindBy(xpath = ".//fieldset/legend/div[.='Відправник']/../../div/div[contains(@id,'combobox')]/div[@role='presentation'][contains(@id,'combobox')]/input")
    private WebElement citySenderInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Отримувач']/../../div/div[contains(@id,'combobox')]/div[@role='presentation'][contains(@id,'combobox')]/input")
    private WebElement cityRecipientInput;

}
