package Awis.actions.requestFence;

import ClearTest.Conditions;
import ClearTest.Initializer;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

public class CargoPreferences extends Conditions {

    private WebDriverWait wait = new WebDriverWait(driver, 5);
    Initializer init = new Initializer(driver);

    public CargoPreferences(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void SetCargoType(String type){
        waitForElementPresent(cargoTypeDropdownButton);
        cargoTypeDropdownButton.click();
        init.cargoType().setType(type);
    }

    public void SetSeatsAmount(String quantity){
        waitForElementPresent(seatsAmountInput);
        seatsAmountInput.sendKeys(quantity+ Keys.TAB);
    }

    public void SetWeight(String weight){
        waitForElementPresent(weightInput);
        weightInput.sendKeys(weight+Keys.TAB);
    }
    public void SetVolumeWeight(String width, String lenght, String height){
        waitForElementPresent(volumeWeightButton);
        volumeWeightButton.click();

        waitForElementPresent(volWeight_AddNew_Button);
        volWeight_AddNew_Button.click();

        waitForElementPresent(widthInput);
        widthInput.sendKeys(width+Keys.TAB);

        waitForElementPresent(lengthInput);
        lengthInput.sendKeys(lenght+Keys.TAB);

        waitForElementPresent(heigthInput);
        heigthInput.sendKeys(height+Keys.ENTER);

        volWeight_OK_Button.click();
    }

    public void SetCost(String cost){
        waitForElementPresent(costInput);
        costInput.sendKeys(cost+Keys.TAB);
    }

    public void SetDescription(String text){
        waitForElementPresent(cargoDescriptionInput);
        cargoDescriptionInput.sendKeys(text);
    }

//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = ".//fieldset/legend/div[.='Параметри вантажу']/../../div/div[contains(@id,'combobox')]/div[@role='presentation'][contains(@id,'combobox')]/input")
    private WebElement cargoTypeDropdownInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Параметри вантажу']/../../div/div[contains(@id,'combobox')]/div[@role='presentation'][contains(@id,'combobox')]/div[contains(@id,'combobox')]")
    private WebElement cargoTypeDropdownButton;

    @FindBy(xpath = "//input[@name='SeatsAmount']") //Кількість місць
    private WebElement seatsAmountInput;

    @FindBy(xpath = "//input[@name='FactualWeight']") //Вага
    private WebElement weightInput;

    @FindBy(xpath = "//input[@name='VolumetricWeight']") //Об'ємна вага
    private WebElement volumeWeightInput;

    @FindBy(xpath = "//input[@name='VolumetricWeight']/../div[contains(@id,'triggerfield')]")
    private WebElement volumeWeightButton;

    @FindBy(xpath = "//input[@name='Cost']") //Оголошена вартість
    private WebElement costInput;

    @FindBy(xpath = "//input[@name='CargoDescriptionString']") //Опис вантажу
    private WebElement cargoDescriptionInput;

    @FindBy(xpath = "//input[@name='ServiceType']") //Тип послуги
    private WebElement serviceTypeInput;

    @FindBy(xpath = "//textarea[@name='PricingDetails']") //Розшифрування вартості
    private WebElement priceDetailsInput;
//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[.='Документи']")
    private WebElement cargoIsDocuments;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[.='Палети']")
    private WebElement cargoIsPalets;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[.='Вантаж']")
    private WebElement cargoIsCargo;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[.='Цінні папери']")
    private WebElement cargoIsCostPapers;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[.='Шини-диски']")
    private WebElement cargoIsTyresWheels;

//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = "//div[contains(@id,'VolumetricWeightDetailsTab-body')]//button/span[.='Додати']")
    private WebElement volWeight_AddNew_Button;

    @FindBy(xpath = "//div[contains(@id,'VolumetricWeightDetailsTab-body')]//button/span[.='Вилучити']")
    private WebElement volWeight_Remove_Button;

    @FindBy(xpath = "//div[contains(@id,'VolumetricWeightDetailsTab-body')]//button/span[.='ОК']")
    private WebElement volWeight_OK_Button;

    @FindBy(xpath = "//input[@name='Width']")
    private WebElement widthInput;
    @FindBy(xpath = ".//div[contains(@id,'VolumetricWeightDetailsTab-body')]//div[contains(@id,'gridview')]/table/tbody/tr[contains(@id,'ext-gen')]/td[2]")
    private WebElement widthCell;

    @FindBy(xpath = "//input[@name='Length']")
    private WebElement lengthInput;
    @FindBy(xpath = ".//div[contains(@id,'VolumetricWeightDetailsTab-body')]//div[contains(@id,'gridview')]/table/tbody/tr[contains(@id,'ext-gen')]/td[3]")
    private WebElement lenghtCell;

    @FindBy(xpath = "//input[@name='Height']")
    private WebElement heigthInput;
    @FindBy(xpath = ".//div[contains(@id,'VolumetricWeightDetailsTab-body')]//div[contains(@id,'gridview')]/table/tbody/tr[contains(@id,'ext-gen')]/td[4]")
    private WebElement heightCell;
}
