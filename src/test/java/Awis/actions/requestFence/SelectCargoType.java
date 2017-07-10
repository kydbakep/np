package Awis.actions.requestFence;

import Awis.Conditions;
import Awis.Initializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 20.02.17.
 */

public class SelectCargoType extends Conditions {

    private WebDriverWait wait = new WebDriverWait(driver, 5);
    Initializer init = new Initializer(driver);

    public SelectCargoType(WebDriver driver) {
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setType(String type) {

        checkStatus();

        if (checkStatus()) {
            cargoTypeOne(type);
        } else {
            cargoTypeTwo(type);
        }
    }

    private void cargoTypeOne(String type) {

        System.out.println();
        System.out.println("ONE!!!!");

        if (type.equals("Документи")) {
            waitForElementPresent(cargoIsDocuments);
            cargoIsDocuments.click();
        }
        if (type.equals("Палети")) {
            waitForElementPresent(cargoIsPalets);
            cargoIsPalets.click();
        }
        if (type.equals("Вантаж")) {
            waitForElementPresent(cargoIsCargo);
            cargoIsCargo.click();
        }
        if (type.equals("Цінні папери")) {
            waitForElementPresent(cargoIsCostPapers);
            cargoIsCostPapers.click();
        }
        if (type.equals("Шини-диски")) {
            waitForElementPresent(cargoIsTyresWheels);
            cargoIsTyresWheels.click();
        }
    }

    private void cargoTypeTwo(String type) {

        System.out.println();
        System.out.println("TWO!!!!");

        if (type.equals("Документи")) {
            waitForElementPresent(cargoIsDocuments2);
            cargoIsDocuments2.click();
        }
        if (type.equals("Палети")) {
            waitForElementPresent(cargoIsPalets2);
            cargoIsPalets2.click();
        }
        if (type.equals("Вантаж")) {
            waitForElementPresent(cargoIsCargo2);
            cargoIsCargo2.click();
        }
        if (type.equals("Цінні папери")) {
            waitForElementPresent(cargoIsCostPapers2);
            cargoIsCostPapers2.click();
        }
        if (type.equals("Шини-диски")) {
            waitForElementPresent(cargoIsTyresWheels2);
            cargoIsTyresWheels2.click();
        }
    }

    private boolean checkStatus() {
        return !(cargoTypeDropdownParamsInput.getAttribute("value").length() > 0 || cargoTypeDropdownBackwardInput.getAttribute("value").length() > 0);
    }

    //----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = ".//fieldset/legend/div[.='Параметри вантажу']/../../div/div[contains(@id,'combobox')]/div[@role='presentation'][contains(@id,'combobox')]/div[contains(@id,'combobox')]")
    private WebElement cargoTypeDropdownParamsButton;
    @FindBy(xpath = ".//fieldset/legend/div[.='Параметри вантажу']/../../div/div[contains(@id,'combobox')]/div[@role='presentation'][contains(@id,'combobox')]//input")
    private WebElement cargoTypeDropdownParamsInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Зворотня доставка']/../../div/div[contains(@id,'combobox')]/div[@role='presentation'][contains(@id,'combobox')]/div[contains(@id,'combobox')]")
    private WebElement cargoTypeDropdownBackwardButton;
    @FindBy(xpath = ".//fieldset/legend/div[.='Зворотня доставка']/../../div/div[contains(@id,'combobox')]/div[@role='presentation'][contains(@id,'combobox')]//input")
    private WebElement cargoTypeDropdownBackwardInput;

    @FindBy(xpath = "(.//div[contains(@id,'boundlist')]/ul/li[.='Документи'])[1]")
    private WebElement cargoIsDocuments;

    @FindBy(xpath = "(.//div[contains(@id,'boundlist')]/ul/li[.='Палети'])[1]")
    private WebElement cargoIsPalets;

    @FindBy(xpath = "(.//div[contains(@id,'boundlist')]/ul/li[.='Вантаж'])[1]")
    private WebElement cargoIsCargo;

    @FindBy(xpath = "(.//div[contains(@id,'boundlist')]/ul/li[.='Цінні папери'])[1]")
    private WebElement cargoIsCostPapers;

    @FindBy(xpath = "(.//div[contains(@id,'boundlist')]/ul/li[.='Шини-диски'])[1]")
    private WebElement cargoIsTyresWheels;

    @FindBy(xpath = "(.//div[contains(@id,'boundlist')]/ul/li[.='Документи'])[2]")
    private WebElement cargoIsDocuments2;

    @FindBy(xpath = "(.//div[contains(@id,'boundlist')]/ul/li[.='Палети'])[2]")
    private WebElement cargoIsPalets2;

    @FindBy(xpath = "(.//div[contains(@id,'boundlist')]/ul/li[.='Вантаж'])[2]")
    private WebElement cargoIsCargo2;

    @FindBy(xpath = "(.//div[contains(@id,'boundlist')]/ul/li[.='Цінні папери'])[2]")
    private WebElement cargoIsCostPapers2;

    @FindBy(xpath = "(.//div[contains(@id,'boundlist')]/ul/li[.='Шини-диски'])[2]")
    private WebElement cargoIsTyresWheels2;
}
