package Awis.actions.createEN;

import Awis.Conditions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 31.01.17.
 */

public class SetAddress extends Conditions {

    public SetAddress(WebDriver driver) {
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void waitForSenderAddressIsFilled() {
        for (int i = 0; i < 10; i++) {
            if ((senderAddressInput).getAttribute("value").length() > 10) {
                System.out.println();
                System.out.print("Поле адреси відправника успішно заповнено: ");
                System.out.println(senderAddressInput.getAttribute("value"));
                break;
            } else {
                System.out.println();
                System.out.println("Очікую заповнення поля...");
                justWait(200);
            }
        }
    }

    private void waitForRecipientAddressIsFilled() {
        for (int i = 0; i < 10; i++) {
            if ((recipientAddressInput).getAttribute("value").length() > 10) {
                System.out.println();
                System.out.print("Поле адреси отримувача успішно заповнено: ");
                System.out.println(recipientAddressInput.getAttribute("value"));
                break;
            } else {
                System.out.println();
                System.out.println("Очікую заповнення поля...");
                justWait(200);
            }
        }
    }

    public void setWareHouseAddressSender(String whAddress) {
        System.out.println();
        System.out.println("Обираю відділення відправника...");
        waitForElementPresent(senderAddressInput);
        senderAddressInput.sendKeys(whAddress);
        justWait(100);
        senderAddressInput.sendKeys(Keys.ENTER);
        waitForSenderAddressIsFilled();
    }

    public void setWareHouseAddressRecipient(String whAddress) {
        System.out.println();
        System.out.println("Обираю відділення отримувача...");
        waitForElementPresent(recipientAddressInput);
        recipientAddressInput.sendKeys(whAddress);
        justWait(100);
        recipientAddressInput.sendKeys(Keys.ENTER);
        waitForRecipientAddressIsFilled();

    }

    public void setHomeAddressRecipient(String address) {
        System.out.println();
        System.out.println("Тисну кнопку вибору адреси отримувача");
        justWait(200);
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 8);
        waitForElementPresent(recipientAddressChooser);

        if (recipientAddressChooser.isDisplayed()) {
            recipientAddressChooser.click();
            System.out.println("Клікнув на кнопку вибору адреси отримувача");
        } else {
            System.err.println("НЕ ЗМІГ КЛІКНУТИ! Пробую ще раз!");
            waitForElementPresent(recipientAddressChooser);
            recipientAddressChooser.click();
        }

        System.out.println();
        System.out.println("Тепер чекаю форму!");
        System.out.println();
        SetCounterParties setCounterParties = new SetCounterParties(driver);
        String boxStatus = setCounterParties.getStatusOfBoxes();

        waitForElementPresent(addressGrid);
//        if (boxStatus.equals("PandoraBoxIsOpened")){waitForElementPresent(addressGridOpened);}
//        if (boxStatus.equals("PandoraBoxIsClosed")){waitForElementPresent(addressGridClosed);}

        System.out.println();
        System.out.println("Очищую фільтр");
        addressCleaner.click();
        justWait(500);
        filterField.sendKeys(address + Keys.TAB);
//        filterField.sendKeys(address + Keys.ENTER);
        System.out.println("Очікую потрібну таблицю...");
        if (boxStatus.equals("PandoraBoxIsOpened")) {
            wait.until(ExpectedConditions.textToBePresentInElement(getAddressInCellPandoraOpened, address));
        }
        if (boxStatus.equals("PandoraBoxIsClosed")) {
            wait.until(ExpectedConditions.textToBePresentInElement(getAddressInCellPandoraClosed, address));
        }
        action.doubleClick(driver.findElement(By.xpath("//div[text() = '" + address + "']"))).perform();
    }

    public void setHomeAddressSender(String address) {
        System.out.println();
        System.out.println("Тисну кнопку вибору адреси відправника");
        justWait(200);
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 8);
        waitForElementPresent(senderAddressChooser);
        senderAddressChooser.click();
        System.out.println();
        System.out.println("Очікую форму...");

        SetCounterParties setCounterParties = new SetCounterParties(driver);
        String boxStatus = setCounterParties.getStatusOfBoxes();

        waitForElementPresent(addressGrid);
//        if (boxStatus.equals("PandoraBoxIsOpened")){waitForElementPresent(addressGridOpened);}
//        if (boxStatus.equals("PandoraBoxIsClosed")){waitForElementPresent(addressGridClosed);}


        System.out.println();
        System.out.println("Очищую фільтр");
        addressCleaner.click();
        justWait(500);
        filterField.sendKeys(address + Keys.TAB);
//        filterField.sendKeys(address + Keys.ENTER);
        System.out.println("Очікую потрібну таблицю...");
        if (boxStatus.equals("PandoraBoxIsOpened")) {
            wait.until(ExpectedConditions.textToBePresentInElement(getAddressInCellPandoraOpened, address));
        }
        if (boxStatus.equals("PandoraBoxIsClosed")) {
            wait.until(ExpectedConditions.textToBePresentInElement(getAddressInCellPandoraClosed, address));
        }
        action.doubleClick(driver.findElement(By.xpath("//div[text() = '" + address + "']"))).perform();
    }

//    public void setHomeAddressSender(String address) {
//        Act_CreateEN_SetCounterParties setCounterParties = new Act_CreateEN_SetCounterParties(driver);
//        String boxStatus = setCounterParties.getStatusOfBoxes();
//
//        System.out.println();
//        System.out.println("Пробую нажати кнопку вибору адреси");
//        justWait(200);
//        Actions action = new Actions(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        waitForElementPresent(senderAddressChooser);
//        senderAddressChooser.click();
//        System.out.println();
//        System.out.println("Типу клікнув...");
//        System.out.println("Тепер чекаю форму...");
//        waitForElementPresent(addressCleaner);
//        addressCleaner.click();
//        waitForElementPresent(addressGrid);
//        filterField.sendKeys(address + Keys.TAB);
//        if (boxStatus.equals("PandoraBoxIsClosed")){wait.until(ExpectedConditions.textToBePresentInElement(addressGridPandoraIsClosed, address));}
//        if (boxStatus.equals("PandoraBoxIsOpened")){wait.until(ExpectedConditions.textToBePresentInElement(addressGridPandoraIsOpened, address));}
//
//        action.doubleClick(driver.findElement(By.xpath("//div[@id='forms-body']/div[not (contains(@style, 'none'))]//div[.='" + address + "']"))).perform();
//    }

//    public void setHomeAddress(String street, int buildingNumber) {
//
//        Actions action = new Actions(driver);
//        String number = Integer.toString(buildingNumber);
//
//        waitForElementPresent(recipientAddressChooser);
//        recipientAddressChooser.click();
//        waitForElementPresent(addressCleaner);
//        addressCleaner.click();
//        waitForElementNotPresent(loadingFrame);
//        filterField.sendKeys(street + Keys.TAB);
//        filterField.sendKeys(number + Keys.TAB);
//        action.doubleClick(driver.findElement(By.xpath("//div[@id='forms-body']/div[not (contains(@style, 'none'))]//div[.='" + street + " " + buildingNumber + "']"))).perform();
//    }
//
//    public void setHomeAddress(String street, int buildingNumber, int apartment) {
//        waitForWebElementPresent(recipientAddressChooser);
//        recipientAddressChooser.click();
//        waitForWebElementPresent(addressCleaner);
//        Actions action = new Actions(driver);
//        String buildNumber = Integer.toString(buildingNumber);
//        String apartmentNumber = Integer.toString(apartment);
//        addressCleaner.click();
//        filterField.sendKeys(street + Keys.TAB);
//        filterField.sendKeys(buildNumber + Keys.TAB);
//        filterField.sendKeys(apartmentNumber + Keys.TAB);
//        action.doubleClick(driver.findElement(By.xpath("//div[@id='forms-body']/div[not (contains(@style, 'none'))]//div[.='" + street + " " + buildingNumber + " " + apartment + "']"))).perform();
//    }

    @FindBy(xpath = "//input[@name='SenderAddress']/../div/div[1]")
    private WebElement senderAddressChooser;

    @FindBy(xpath = "//input[@name='RecipientAddress']/../div/div[1]")
    private WebElement recipientAddressChooser;

    @FindBy(xpath = "//input[@name='SenderAddress']")
    private WebElement senderAddressInput;

    @FindBy(xpath = "//input[@name='RecipientAddress']")
    private WebElement recipientAddressInput;

    @FindBy(xpath = "//div[contains(@id, 'FilterField-triggerWrap')]")
    private WebElement addressCleaner;

    @FindBy(xpath = "//div[contains(@id, 'FilterField-bodyEl')]/input")
    private WebElement filterField;

    @FindBy(xpath = "//tr[contains(@class, 'x-grid-row-focused')]/td[5]")
    private WebElement addressInCellFocused;

    @FindBy(xpath = "(//tr[contains(@class, 'x-grid-row')]/td[5])[1]")
    private WebElement getAddressInCellPandoraClosed;

    @FindBy(xpath = "(//tr[contains(@class, 'x-grid-row')]/td[5])[last()]")
    private WebElement getAddressInCellPandoraOpened;

    @FindBy(xpath = ".//*[@id='4Grid-body']/div/table")
    private WebElement addressGridPandoraIsClosed;
    @FindBy(xpath = ".//*[@id='5Grid-body']/div/table")
    private WebElement addressGridPandoraIsOpened;

    @FindBy(xpath = "//div[contains(@id,'gridview')]/table")
    private WebElement addressGrid;
    @FindBy(xpath = "(//div[contains(@id,'gridview')]/table)[1]")
    private WebElement addressGridClosed;
    @FindBy(xpath = "(//div[contains(@id,'gridview')]/table)[2]")
    private WebElement addressGridOpened;

    @FindBy(xpath = "//input[@name='PhoneSender']")
    private WebElement phoneSenderInput;
}