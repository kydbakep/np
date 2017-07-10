package Awis.actions.createEN;

import ClearTest.Conditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 30.01.17.
 */
public class ChooseSenderType extends Conditions {

    ChooseSenderType(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void chooseSenderType(String type) {
//----------------------------------------------------------------------------------------------------------------------
// Шукаємо кнопку
        System.out.println();
        System.out.println("Відкриваємо вікно вибору контрагента відправника...");

        SetCounterParties setCounterParties = new SetCounterParties(driver);
        String boxStatus = setCounterParties.getStatusOfBoxes();

// Якщо заповнюється єдина форма
        if (boxStatus.equals("PandoraBoxIsClosed")) {
            waitForElementPresent(counterpartySenderChooser);
            if (counterpartySenderChooser.isDisplayed()) {
                System.out.println();
                System.out.println("Кнопка вибору контрагента відправника доступна. Натискаємо...");
                counterpartySenderChooser.click();

                waitForElementPresent(selectTypeFramePandoraIsClosed);
                if (selectTypeFramePandoraIsClosed.isDisplayed()) {

                    System.out.println();
                    System.out.println("OK.");
                    System.out.println();
                    System.out.println("Вибір типу контрагента відправника...");

                } else System.out.println("Failed! Не бачу фрейм вибору типу контрагента відправника!");

            } else {
                System.out.println();
                System.out.println("Failed! Не можу натиснути кнопку \'Вибір контрагента\' відправника!");
            }
        }
// Якщо заповнюється друга форма (Контрагент - відправник, тому обираємо ті ж елементи, що й при єдиній формі!)
        if (boxStatus.equals("PandoraBoxIsOpened")) {

            waitForElementPresent(counterpartySenderChooser);
            if (counterpartySenderChooser.isDisplayed()) {
                System.out.println();
                System.out.println("Кнопка вибору контрагента відправника доступна. Натискаємо... (2 форма)");
                counterpartySenderChooser.click();

//                waitForElementPresent(selectTypeFramePandoraIsOpened);
                waitForElementPresent(selectTypeFramePandoraIsClosed);
//                if (selectTypeFramePandoraIsOpened.isDisplayed())
                if (selectTypeFramePandoraIsClosed.isDisplayed())
                {

                    System.out.println();
                    System.out.println("OK.");
                    System.out.println();
                    System.out.println("Вибір типу контрагента (2 форма) відправника...");

                } else System.out.println("Failed! Не бачу фрейм вибору типу контрагента відправника! (2 форма)");

            } else {
                System.out.println();
                System.out.println("Failed! Не можу натиснути кнопку \'Вибір контрагента\' (2 форма)");
            }
        }

// Перевіримо статус
        System.out.println(boxStatus);

// Обираємо тип контрагента
// Якщо єдина форма
        if (boxStatus.equals("PandoraBoxIsClosed")) {
            if (type.equals("організація") || type.equals("Організація")){
                System.out.println();
                System.out.println("Обираємо тип контрагента відправника - Організація");
                organisationPandoraIsClosed.click();
                if (organisationRadio.getAttribute("aria-checked").equals("true")) {
                    System.out.println("OK.");
                } else System.out.println("Failed!");
            }
            if (type.equals("приватна особа") || type.equals("Приватна особа")) {
                System.out.println();
                System.out.println("Обираємо тип контрагента відправника - Приватна особа");
                privatePersonPandoraIsClosed.click();
                if (privatePersonRadio.getAttribute("aria-checked").equals("true")) {
                    System.out.println("OK.");
                } else System.out.println("Failed!");
            } else if (!(type.equals("організація")) || !(type.equals("Організація")) || !(type.equals("приватна особа")) || !(type.equals("Приватна особа"))) {
                System.out.println("Не обрано тип контрагента!");
            }
        }
// Якщо друга форма (Контрагент - відправник, тому обираємо ті ж елементи, що й при єдиній формі!)
        if (boxStatus.equals("PandoraBoxIsOpened")) {
            if (type.equals("організація") || type.equals("Організація")){
                System.out.println();
                System.out.println("Обираємо тип контрагента відправника - Організація (2 форма)");
//                organisationPandoraIsOpened.click();
                organisationPandoraIsClosed.click();
                if (organisationRadio.getAttribute("aria-checked").equals("true")) {
                    System.out.println("OK.");
                } else System.out.println("Failed!");
            }
            if (type.equals("приватна особа") || type.equals("Приватна особа")) {
                System.out.println();
                System.out.println("Обираємо тип контрагента відправника - Приватна особа (2 форма)");
//                privatePersonPandoraIsOpened.click();
                privatePersonPandoraIsClosed.click();
                if (privatePersonRadio.getAttribute("aria-checked").equals("true")) {
                    System.out.println("OK.");

                } else System.out.println("Failed!");
            } else if (!(type.equals("організація")) || !(type.equals("Організація")) || !(type.equals("приватна особа")) || !(type.equals("Приватна особа"))) {
                System.out.println("Не обрано тип контрагента!");
            }
        }
    }
//======================================================================================================================
//======================================================================================================================

    @FindBy(xpath = "//input[@name = 'CounterpartySender']/../div/div[1]")
    private WebElement counterpartySenderChooser;

//    @FindBy(xpath = "//input[@name = 'CounterpartyRecipient']/../div/div[1]")
//    private WebElement counterpartyRecipientChooser;

    @FindBy(xpath = "(//div[contains(text(),'Оберіть вид контрагента!')])[1]")
    private WebElement selectTypeFramePandoraIsClosed;
    @FindBy(xpath = "(//div[contains(text(),'Оберіть вид контрагента!')])[2]")
    private WebElement selectTypeFramePandoraIsOpened;

    @FindBy(xpath = "(//span[contains(text(),'Організація')])[1]")
    private WebElement organisationPandoraIsClosed;
    @FindBy(xpath = "(//span[contains(text(),'Організація')])[2]")
    private WebElement organisationPandoraIsOpened;

    @FindBy(xpath = "(//span[contains(text(),'Приватна особа')])[1]")
    private WebElement privatePersonPandoraIsClosed;
    @FindBy(xpath = "(//span[contains(text(),'Приватна особа')])[2]")
    private WebElement privatePersonPandoraIsOpened;

    @FindBy(xpath = "//label[contains(text(),'Організація')]/../input[@role=\"radio\"]")
    private WebElement organisationRadio;

    @FindBy(xpath = "//label[contains(text(),'Приватна особа')]/../input[@role=\"radio\"]")
    private WebElement privatePersonRadio;
}