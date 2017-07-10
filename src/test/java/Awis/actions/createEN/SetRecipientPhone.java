package Awis.actions.createEN;

import Awis.Conditions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 30.01.17.
 */

public class SetRecipientPhone extends Conditions {
    public SetRecipientPhone(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setRecipientPhone(String phoneNumber) {
        System.out.println("Очікую поле номеру отримувача...");
        quickWaitForElementPresent(phoneNumberInForm);
        if (phoneNumberInForm.isDisplayed()) {
            System.out.println();
            System.out.print("Вводимо номер телефону отримувача...");
            phoneNumberInForm.clear();
            justWait(200);
            phoneNumberInForm.sendKeys(phoneNumber);

            if (phoneNumberInForm.getAttribute("value").equals(phoneNumber)) {
                phoneNumberInForm.sendKeys(Keys.TAB);
                System.out.println();
                System.out.println(phoneNumberInForm.getAttribute("value"));
                justWait(200);
//Перевіяємо чи треба чекати таблицю контактів
                if (!listOfContactsIsPresent(counterpartyTypeChooseForm)) {
                    System.out.println();
                    System.out.println("Список контактних осіб отримувача ВІДСУТНІЙ... продовжую...");
                } else if (listOfContactsIsPresent(counterpartyTypeChooseForm)) {
                    System.out.println();
                    System.out.println("Список контактних осіб отримувача ПРИСУТНІЙ... обираю контактну особу...");
                    if (counterpartyTypeChooseForm.isDisplayed()) {
                        quickWaitForElementPresent(listOfContacts);
                        if (listOfContacts.isDisplayed()) {
                            System.out.println();
                            System.out.println("Присутній список вибору контактної особи отримувача...");
                        } else {
                            System.out.println();
                            System.out.println("Список контактних осіб отримувача ВІДСУТНІЙ... продовжую...");
                        }
                    } else {
                        System.out.println("Продовжую");
                    }
                }
            } else System.out.println("Failed");
        } else {
            System.out.println("FAILED! Не бачу поле \'Номер\'");
        }
    }


    private boolean listOfContactsIsPresent(WebElement element) {
        try {
            element.getAttribute("class");
            return true;
        } catch (ElementNotVisibleException notVisible) {
            System.out.println();
            System.out.print("Element is not visible: " + element);
            return false;
        } catch (NoSuchElementException noSuchElement) {
            System.out.println();
            System.out.print("No such element: " + element);
            return false;
        }
    }

    @FindBy(xpath = "//input[@name='PhoneNumber']")
    private WebElement phoneNumberInForm;

    @FindBy(xpath = "//input[@name='PhoneSender']")
    private WebElement phoneSenderInput;

    @FindBy(xpath = "//div[contains(@id, 'GridFoundCounterparties-body')]/div/table")
    private WebElement listOfContacts;

    @FindBy(xpath = "//span[.='Пошук за номером телефона/кодом ЄДРПОУ']")
    private WebElement counterpartyTypeChooseForm;
}
