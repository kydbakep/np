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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * ! Created by tober on 17.02.17.
 */

public class TakeFromEN extends Conditions{
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);

    public TakeFromEN(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

//----------------------------------------------------------------------------------------------------------------------

    public void fillFieldsFromEN() throws FileNotFoundException {
        waitForElementPresent(choiseButton);
        choiseButton.click();
        waitForElementPresent(numberEN);
        numberEN.sendKeys(readLastLineFromFile("numbers.txt")+ Keys.ENTER);

        System.out.println();
        System.out.println(numberEN.getAttribute("value"));

        justWait(250);
        waitForElementPresent(driver.findElement(By.xpath("//div[.='"+readLastLineFromFile("numbers.txt")+"']")));
        init.getAct().doubleClick((driver.findElement(By.xpath("//div[.='"+readLastLineFromFile("numbers.txt")+"']/..")))).perform();

        waitForElementPresent(fillFieldsButton);
        fillFieldsButton.click();

        wait.until(ExpectedConditions.attributeToBeNotEmpty(remarksInput,"value"));

    }

//----------------------------------------------------------------------------------------------------------------------

    public void remarksFill(String text){
        remarksInput.sendKeys(text);
    }

//----------------------------------------------------------------------------------------------------------------------

    public String readLastLineFromFile(String file) throws FileNotFoundException {
        BufferedReader input = new BufferedReader(new FileReader("/home/tober/Projects/WebDriver/src/test/java/ClearTest/" + file));
        String last = "", line;

        try {
            while ((line = input.readLine()) != null) {
                last = line.split(" ")[1];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return last;
    }

//----------------------------------------------------------------------------------------------------------------------
    public void ENConstruct(WebDriver driver) throws Exception {

    Conditions.driver = driver;
    PageFactory.initElements(driver, this);
//----------------------------------------------------------------------------------------------------------------------
    System.err.println("Створюємо ЕН зі зворотньою доставкою...");
//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================
    init.getSelectionPage().openDocumentsEN();
    init.getCreateENbutton().clickCreateEN();
    init.getSetCounterparties().getStatusOfBoxes();

    init.getSetCounterparties().getStatusOfBoxes();

    init.getSetCounterpartyCity().setCitySender("Київ","м. Київ, Київська область");
    init.getSetCounterparties().setConterpartySender("0111111111");
    init.getSetAddress().setWareHouseAddressSender("1");

    init.getSetCounterpartyCity().setCityRecipient("Харків", "м. Харків, Харківська область");
    init.getSetCounterparties().setCounterpartyRecipient("0333333333");
    init.getSetAddress().setWareHouseAddressRecipient("2");

    init.getCheckTitles().checkCounterPartySenderBoxTitle();
    init.getCheckTitles().checkCounterPartyRecipientBoxTitle();
    init.getSetCounterpartyCity().RouteCheck();

    init.getSetDeliveryPayer().selectPayerFromDropDown("отримувач");
    init.getSetPaymantMethod().selectPaymantMethodFromDropdown("готівка");

    init.getSetCargoType().selectCargoType("Шини-диски");
    init.getSetCargoType().selectCargoType("Документи");

    init.getSetNumber().setNumber();
    init.getSetCost().setCost("25750");


    init.getSetBackwardDelivery().setBackwardDelivery("отримувач", "Інше");

    init.getWriteEN().writeEN();
    init.getWriteEN().writeENnumberToFile("numbers.txt");
//----------------------------------------------------------------------------------------------------------------------
    System.out.println();


//        driver.quit();

//        init.getPlayer().play("good.mp3");
}
//======================================================================================================================

    @FindBy(xpath = ".//fieldset/legend/div[.='Експрес-накладна']/../../div/div[label='Номер ЕН:']/div/input")
    private WebElement numberInput;

    @FindBy(xpath = ".//fieldset/legend/div[.='Експрес-накладна']/../../div/div[label='Номер ЕН:']/div//div/div[contains(@class,'choice')]")
    private WebElement choiseButton;

    @FindBy(xpath = ".//fieldset/legend/div[.='Експрес-накладна']/../../div/div[label='Номер ЕН:']/div//div/div[contains(@class,'clear')]")
    private WebElement clearButton;

    @FindBy(xpath = ".//fieldset/legend/div[.='Експрес-накладна']/../../div/div[label='Номер ЕН:']/div//div/div[contains(@class,'search')]")
    private WebElement findButton;

    @FindBy(xpath = ".//fieldset/legend/div[.='Експрес-накладна']/../../div/div[contains(@id,'button')]")
    private WebElement fillFieldsButton;

    @FindBy(xpath = ".//textarea[@name='Note']")
    private WebElement remarksInput;

    @FindBy(xpath = ".//input[contains(@id,'ext-gen')][@role='textbox'][contains(@aria-describedby,'NumberFilter-errorEl')]")
    private WebElement numberEN;
}
