package Awis.actions.createEN;

import Awis.Conditions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 30.01.17.
 */

public class SetCounterParties extends Conditions {

    public SetCounterParties(WebDriver driver) {
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getStatusOfBoxesMultiple() {
        String boxStatus;

        if (counterpartySenderInput.getAttribute("value").length() > 0 && counterpartyRecipientInput.getAttribute("value").length() > 0) {
            System.out.println();
            System.out.println("Відправник: "+counterpartySenderInput.getAttribute("value")+" ... символів: "+counterpartySenderInput.getAttribute("value").length());
            System.out.println("Отримувач : "+counterpartyRecipientInput.getAttribute("value")+" ... символів: "+counterpartyRecipientInput.getAttribute("value").length());
            boxStatus = "PandoraBoxIsOpened";
            System.out.println();
            System.out.println("Status is: " + boxStatus);
        }
        else{
            System.out.println();
            System.out.println("Відправник: "+counterpartySenderInput.getAttribute("value")+" ... символів: "+counterpartySenderInput.getAttribute("value").length());
            System.out.println("Отримувач : "+counterpartyRecipientInput.getAttribute("value")+" ... символів: "+counterpartyRecipientInput.getAttribute("value").length());
            boxStatus = "PandoraBoxIsClosed";
            System.out.println("");
            System.out.println("Status is: " + boxStatus);
        }

        return boxStatus;
    }

    public String getStatusOfBoxes() {
        String boxStatus;

        if (counterpartySenderInput.getAttribute("value").length() > 0 || counterpartyRecipientInput.getAttribute("value").length() > 0) {
            System.out.println();
            boxStatus = "PandoraBoxIsOpened";
            System.out.println();
            System.out.println("Status is: " + boxStatus);
        }
        else{
            System.out.println();
            boxStatus = "PandoraBoxIsClosed";
            System.out.println("");
            System.out.println("Status is: " + boxStatus);
        }

        return boxStatus;
    }

//==================================================================================================================
//ВІДПРАВНИК
// Просто по номеру телефону в інпут
    public void setConterpartySender(String phone) {
        System.out.println();
        System.out.println("Обираємо контрагента відправника за номером телефону...");
        waitForElementPresent(counterpartySenderInput);
        justWait(500);
        if (counterpartySenderInput.isDisplayed()) {
            counterpartySenderInput.sendKeys(phone);
            counterpartySenderInput.sendKeys(Keys.TAB);
            justWait(500);
            waitForElementPresent(senderNameInput);
            if (senderNameInput.getAttribute("value").length() > 0) {
                System.out.println();
                System.out.println("OK. Контактна особа відправника: " + senderNameInput.getAttribute("value") + ".");
                System.out.println("Телефон: " + phoneSenderInput.getAttribute("value"));
            } else System.out.println("Контактну особу відправника не обрано!");
        }
    }

// Використовуючи форму, та без імені контакної особи
    public void setConterpartySender(String type, String phone) {
        System.out.println();
        System.out.println("Обираємо контрагента відправника...");
        ChooseSenderType selectSenderType = new ChooseSenderType(driver);
        selectSenderType.chooseSenderType(type);
        SetSenderPhone setNumber = new SetSenderPhone(driver);
        setNumber.setSenderPhone(phone);
        justWait(500);
        waitForElementPresent(senderNameInput);
        if (senderNameInput.getAttribute("value").length() > 0) {
            System.out.println();
            System.out.println("OK. Контактна особа відправника: " + senderNameInput.getAttribute("value"));
            System.out.println("Телефон: " + phoneSenderInput.getAttribute("value"));
        } else {
            System.out.println();
            System.out.println("Контактну особу відправника не обрано!");
        }
    }

// Використовуючи форму, та з іменем контакної особи
    public void setConterpartySender(String type, String phone, String fullName) {
        System.out.println();
        System.out.println("Обираємо контрагента відправника...");
        ChooseSenderType selectSenderType = new ChooseSenderType(driver);
        selectSenderType.chooseSenderType(type);
        SetSenderPhone setNumber = new SetSenderPhone(driver);
        setNumber.setSenderPhone(phone);
        justWait(500);
        waitForElementPresent(senderNameInput);
        if (senderNameInput.getAttribute("value").length() > 0) {
            System.out.println();
            System.out.println("OK! Контактна особа відправника: " + senderNameInput.getAttribute("value"));
            System.out.println("Телефон: " + phoneSenderInput.getAttribute("value"));
        } else {
            System.out.println();
            System.out.println("Контактну особу відправника не обрано!");
        }
        chooseSenderFullname(fullName);
    }

    private void chooseSenderFullname(String fullname) {
        System.out.println();
        System.out.println("Обираємо контактну особу відправника...");
        quickWaitForElementPresent(listOfContacts);
        getStatusOfBoxes();
        if (listOfContacts.isDisplayed()) {
            Actions actions = new Actions(driver);
            actions.doubleClick(driver.findElement(By.xpath("//div[contains(@id, 'GridFoundCounterparties')]//td [contains(.,'" + fullname + "')]"))).perform();
            waitForElementNotPresent(counterpartyTypeChooseForm);
            waitForElementPresent(senderNameInput);
            if (senderNameInput.isDisplayed()) {
                System.out.println();
                System.out.println("Обрано контактну особу відправника: " + senderNameInput.getAttribute("value"));
            } else System.out.println("Why? Where is Sender\'s name?");
        }
    }

    private void chooseRecipientFullname(String fullname) {
        System.out.println();
        System.out.println("Обираємо контактну особу отримувача...");
        quickWaitForElementPresent(listOfContacts);
        getStatusOfBoxes();
        if (listOfContacts.isDisplayed()) {
            Actions actions = new Actions(driver);
            actions.doubleClick(driver.findElement(By.xpath("//div[contains(@id, 'GridFoundCounterparties')]//td [contains(.,'" + fullname + "')]"))).perform();
            waitForElementNotPresent(counterpartyTypeChooseForm);
            waitForElementPresent(recipientNameInput);
            if (recipientNameInput.isDisplayed()) {
                System.out.println();
                System.out.println("Обрано контактну особу отримувача: " + recipientNameInput.getAttribute("value"));
            } else System.out.println("Why? Where is Sender\'s name?");
        }
    }

//==================================================================================================================
//ОТРИМУВАЧ
// Просто по номеру телефону в інпут
    public void setCounterpartyRecipient(String phone) {
        System.out.println();
        System.out.println("Обираємо контрагента отримувача за номером телефону...");
        waitForElementPresent(counterpartyRecipientInput);
        justWait(500);
        if (counterpartyRecipientInput.isDisplayed()) {
            counterpartyRecipientInput.sendKeys(phone);
            counterpartyRecipientInput.sendKeys(Keys.TAB);
            justWait(500);
            waitForElementPresent(recipientNameInput);
            if (recipientNameInput.getAttribute("value").length() > 0) {
                System.out.println();
                System.out.println("OK. Контактна особа отримувача: " + recipientNameInput.getAttribute("value"));
                System.out.println("Телефон: " + phoneRecipientInput.getAttribute("value"));
            } else System.out.println("Контактну особу отримувача не обрано!");
        }
    }

// Використовуючи форму, без імені контакної особи
    public void setCounterpartyRecipient(String type, String phone) {
        System.out.println();
        System.out.println("Обираємо контрагента отримувача...");
        ChooseRecipientType selectRecipientType = new ChooseRecipientType(driver);
        selectRecipientType.chooseRecipientType(type);
        SetRecipientPhone setNumber = new SetRecipientPhone(driver);
        setNumber.setRecipientPhone(phone);
        justWait(500);
        waitForElementPresent(recipientNameInput);
        if (recipientNameInput.getAttribute("value").length() > 0) {
            System.out.println();
            System.out.println("OK. Контактна особа отримувача: " + recipientNameInput.getAttribute("value"));
            System.out.println("Телефон: " + phoneRecipientInput.getAttribute("value"));
        } else {
            System.out.println();
            System.out.println("Контактну особу отримувача не обрано!");
        }
    }

// Використовуючи форму, та з іменем контакної особи
    public void setCounterpartyRecipient(String type, String phone, String fullName) {
        System.out.println();
        System.out.println("Обираємо контрагента отримувача...");
        ChooseRecipientType selectRecipientType = new ChooseRecipientType(driver);
        selectRecipientType.chooseRecipientType(type);
        SetRecipientPhone setNumber = new SetRecipientPhone(driver);
        setNumber.setRecipientPhone(phone);
        justWait(500);
        waitForElementPresent(recipientNameInput);
        if (recipientNameInput.getAttribute("value").length() > 0) {
            System.out.println();
            System.out.println("OK! Контактна особа отримувача: " + recipientNameInput.getAttribute("value"));
            System.out.println("Телефон: " + phoneRecipientInput.getAttribute("value"));
        } else {
            System.out.println();
            System.out.println("Контактну особу отримувача не обрано!");
        }
        chooseRecipientFullname(fullName);
    }
//======================================================================================================================
    @FindBy(xpath = "//input[@name = 'CounterpartySender']")
    private WebElement counterpartySenderInput;

    @FindBy(xpath = "//input[@name = 'CounterpartyRecipient']")
    private WebElement counterpartyRecipientInput;

    @FindBy(xpath = "//input[@name='SenderName']")
    private WebElement senderNameInput;

    @FindBy(xpath = "//input[@name='RecipientName']")
    private WebElement recipientNameInput;

    @FindBy(xpath = "//input[@name='PhoneSender']")
    private WebElement phoneSenderInput;

    @FindBy(xpath = "//input[@name='PhoneRecipient']")
    private WebElement phoneRecipientInput;

    @FindBy(xpath = "//div[@id = '2CitySender-bodyEl']/input")
    private WebElement citySenderInput;

    @FindBy(xpath = "//div[contains (@id, 'CityRecipient-bodyEl')]/input")
    private WebElement cityRecipientInput;

    @FindBy(xpath = "//input[@name='PhoneNumber']")
    private WebElement phoneNumberInForm;

    @FindBy(xpath = "//span[.='Пошук за номером телефона/кодом ЄДРПОУ']")
    private WebElement counterpartyTypeChooseForm;

    @FindBy(xpath = "//div[span = 'Пошук за номером телефона/кодом ЄДРПОУ']/following-sibling::div/img")
    private WebElement counterpartyTypeChooseFormCloser;

    @FindBy(xpath = "//div[contains(@id, 'GridFoundCounterparties-body')]/div/table")
    private WebElement listOfContacts;

    @FindBy(xpath = "//input[@name = 'CounterpartySender']/../div/div[1]")
    private WebElement counterpartySenderChooser;
}