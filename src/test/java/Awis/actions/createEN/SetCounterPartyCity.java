package Awis.actions.createEN;

import ClearTest.Conditions;
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
 * ! Created by tober on 30.01.17.
 */

public class SetCounterPartyCity extends Conditions {

    private String senderCity = "";
    private String recipientCity = "";

    public SetCounterPartyCity(WebDriver driver) {
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void setCitySenderBox(String city, String fullName, WebElement element) {
        element.sendKeys(city);
        justWait(200);
        element.sendKeys(Keys.BACK_SPACE);
        waitForElementPresent(citiesSenderBox);
        if (citiesSenderBox.isDisplayed()){
            waitForElementPresent(driver.findElement(By.xpath("//div[contains (@id, 'boundlist') and not (contains(@style, 'display'))]/div//li[.='" + fullName + "']")));
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains (@id, 'boundlist') and not (contains(@style, 'display'))]/div//li[.='" + fullName + "']"))).click();
        }
        else {
            System.out.println();
            System.out.println("Хуйня якась");
        }
    }

    private void setCityRecipientBox(String city, String fullName, WebElement element) {
        element.click();
        justWait(100);
        element.sendKeys(city + Keys.BACK_SPACE);
        waitForElementPresent(citiesRecipientBox);
        if (!(isElementPresent(driver.findElement(By.xpath("//div[contains (@id, 'boundlist') and not (contains(@style, 'display'))]/div//li[.='" + fullName + "']"))))) {
            element.sendKeys(Keys.BACK_SPACE);
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains (@id, 'boundlist') and not (contains(@style, 'display'))]/div//li[.='" + fullName + "']")));
        }
        driver.findElement(By.xpath("//div[contains (@id, 'boundlist') and not (contains(@style, 'display'))]/div//li[.='" + fullName + "']")).click();
    }

    //------------------------------------------------------------------------------------------------------------------
    public void setCitySender(String city, String fullName) {
        System.out.println();
        System.out.println("Обираємо місто відправника...");
        waitForElementPresent(citySenderInput);
        setCitySenderBox(city, fullName, citySenderInput);
        if (citySenderInput.getAttribute("value") != null || citySenderInput.getAttribute("value").length() > 0) {
            System.out.println();
            System.out.println("Місто відправника успішно обрано: " + citySenderInput.getAttribute("value"));

            senderCity = (citySenderInput.getAttribute("value").split(",")[0]);
            senderCity = (senderCity.split(". ")[1]);

        } else System.out.println("Failed! Місто відправника не обрано");
    }

    public void setCityRecipient(String city, String fullName) {
        System.out.println();
        System.out.println("Обираємо місто отримувача...");
        waitForElementPresent(cityRecipientInput);

        setCityRecipientBox(city, fullName, cityRecipientInput);
        justWait(100);
        if (cityRecipientInput.getAttribute("value") != null || cityRecipientInput.getAttribute("value").length() > 0) {
            System.out.println();
            System.out.println("Місто отримувача успішно обрано: " + cityRecipientInput.getAttribute("value"));

            recipientCity = (cityRecipientInput.getAttribute("value").split(",")[0]);
            recipientCity = (recipientCity.split(". ")[1]);

        } else System.out.println("Failed! Місто отримувача не обрано");
    }

    //------------------------------------------------------------------------------------------------------------------
//    public void setCitySenderByButton(String cityName, String regionName, String districtName)
    public void setCitySenderByButton(String cityName, String regionName) {
        Actions action = new Actions(driver);
        System.out.println();
        System.out.println("Встановлюємо місто відправника...");
        justWait(200);
        waitForElementPresent(citySenderChooser);
        if (citySenderChooser.isDisplayed()) {
            System.out.println();
            System.out.println("Клікаємо кнопку вибору міста відправника...");
            citySenderChooser.click();

            waitForElementPresent(cityFilterBoxInput);
            if (cityFilterBoxInput.isDisplayed()) {
                System.out.println();
                System.out.println("Бачимо список областей.");
                cityFilterBoxCleaner.click();
                waitForElementPresent(cityFilterTableSet);
                cityFilterBoxInput.sendKeys(regionName + Keys.TAB);

                System.out.println("Обираємо область...");
                waitForElementPresent(focusedRegion);
                action.doubleClick(focusedRegion).perform();

                System.out.println("Обираємо місто... ");
                waitForElementPresent(cityFilterTableSet);
                if (cityFilterTableSet.isDisplayed()) {
                    System.out.println();
                    action.doubleClick(driver.findElement(By.xpath("//div[text()='" + cityName + "']"))).perform();
                } else {
                    System.out.println();
                    System.out.println("Списку немає!");
                }
            } else {
                System.out.println();
                System.out.println("Failed!");
            }
        } else {
            System.out.println();
            System.out.println("Не бачу кнопку вибору міста...");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //==================================================================================================================
    public void changeCitySenderByInput(String city, String fullName) {

        System.out.println();
        System.out.println("Змінюємо місто відправника через поле...");
        waitForElementPresent(citySenderInput);
        citySenderInputCleaner.click();
        justWait(200);
        setCitySenderBox(city, fullName, citySenderInput);
        if (citySenderInput.getAttribute("value") != null || citySenderInput.getAttribute("value").length() > 0) {
            System.out.println();
            System.out.println("Місто відправника успішно змінено: " + citySenderInput.getAttribute("value"));

            senderCity = (citySenderInput.getAttribute("value").split(",")[0]);
            senderCity = (senderCity.split(". ")[1]);

        } else System.out.println("Failed! Місто відправника не змінено");
    }

    public void changeCityRecipientByInput(String city, String fullName) {
        System.out.println();
        System.out.println("Змінюємо місто отримувача через поле...");
        waitForElementPresent(cityRecipientInputCleaner);
        cityRecipientInputCleaner.click();
        justWait(200);
        setCityRecipientBox(city, fullName, cityRecipientInput);
        justWait(100);
        if (cityRecipientInput.getAttribute("value") != null || cityRecipientInput.getAttribute("value").length() > 0) {
            System.out.println();
            System.out.println("Місто отримувача успішно змінено: " + cityRecipientInput.getAttribute("value"));

            recipientCity = (cityRecipientInput.getAttribute("value").split(",")[0]);
            recipientCity = (recipientCity.split(". ")[1]);

        } else System.out.println("Failed! Місто отримувача не змінено");
    }

    //==================================================================================================================
// SENDER
// Without region
    public void changeCitySenderByButton(String cityName) {
        System.out.println();
        System.out.println("Змінюю обране місто відправника...");
        justWait(200);
        waitForElementPresent(citySenderChooser);
        if (citySenderChooser.isDisplayed()) {
            System.out.println();
            System.out.println("Натискаю кнопку вибору міста відправника...");
            citySenderChooser.click();

            waitForElementPresent(cityFilterBoxInput);
            if (cityFilterBoxInput.isDisplayed()) {  // Обираємо місто
                System.out.println();
                System.out.println("OK.");
                cityFilterBoxCleaner.click();
                waitForElementPresent(cityFilterTableChange);
                cityFilterBoxInput.sendKeys(cityName + Keys.TAB);
                waitForElementPresent(cityFilterTableChange);

                if (cityFilterTableChange.isDisplayed()) {
                    System.out.println();
                    System.out.println("Список є! ");
                    Actions action = new Actions(driver);
                    action.doubleClick(targetCity).perform();
                } else {
                    System.out.println();
                    System.out.println("Списку немає!");
                }
            } else {
                System.out.println();
                System.out.println("Failed!");
            }
        } else {
            System.out.println();
            System.out.println("Не бачу кнопку вибору міста...");
        }
    }
// With region


    // RECIPIENT
// Without region
    public void changeCityRecipientByButton(String cityName) {
        System.out.println();
        System.out.println("Змінюю обране місто отримувача...");
        justWait(200);
        waitForElementPresent(cityRecipientChooser);
        if (cityRecipientChooser.isDisplayed()) {
            System.out.println();
            System.out.println("Натискаю кнопку вибору міста отримувача...");
            cityRecipientChooser.click();

            waitForElementPresent(cityFilterBoxInput);
            if (cityFilterBoxInput.isDisplayed()) {  // Обираємо місто
                System.out.println();
                System.out.println("OK!");
                cityFilterBoxCleaner.click();
                waitForElementPresent(cityFilterTableChange);
//            if (cityFilterTable.isDisplayed()) {
//                System.out.println();
//                System.out.println("УРА!");
//            } else {
//                System.out.println();
//                System.out.println("Фігня");
//            }
                cityFilterBoxInput.sendKeys(cityName + Keys.TAB);
                waitForElementPresent(cityFilterTableChange);

                if (cityFilterTableChange.isDisplayed()) {
                    System.out.println();
                    System.out.println("Список є!");
                    Actions action = new Actions(driver);
                    action.doubleClick(targetCity).perform();
                } else {
                    System.out.println();
                    System.out.println("Списку немає! ");
                }
            } else {
                System.out.println();
                System.out.println("Failed!");
            }
        } else {
            System.out.println();
            System.out.println("Не бачу кнопку вибору міста...");
        }
    }

// With region

    //------------------------------------------------------------------------------------------------------------------
    private boolean RouteFieldStatus() {
        return routeInputField.getAttribute("value").length() > 0;
    }

    private void RouteFieldStatusOK() {
        if (RouteFieldStatus()) {
            System.out.println("OK. Поле \"Маршрут\" заповнено. Продовжую...");
        } else {
            System.out.println("Failed! Поле \"Маршрут\" ПУСТЕ!");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public void RouteCheck() {

        System.out.println();
        System.out.println("Перевіряємо маршрут...");
        System.out.println();

        RouteFieldStatusOK();

        String routeFromRouteField = routeInputField.getAttribute("value");

        if (routeFromRouteField.length() > 0) {
            System.out.println("Маршрут з поля \"Маршрут\":  " + routeFromRouteField);
        }

        String routeFromForms = (senderCity + "-" + recipientCity);
        if ((citySenderInput.getAttribute("value").length() > 0) && (cityRecipientInput.getAttribute("value").length() > 0)) {
            System.out.println("Маршрут з полів вибору населених пунктів: " + routeFromForms);
        }

        String firstCityFromRouteField = (routeFromRouteField.split("-")[0]);
        String lastCityFromRouteField = routeFromRouteField.substring(routeFromRouteField.lastIndexOf("-") + 1);
        String trueRouteFromRouteField;
        if (firstCityFromRouteField.equals(lastCityFromRouteField)) {
            trueRouteFromRouteField = ("Доставка по місту " + senderCity);
        } else {
            trueRouteFromRouteField = (firstCityFromRouteField + "-" + lastCityFromRouteField);
        }

        if ((citySenderInput.getAttribute("value").length() > 0) && (cityRecipientInput.getAttribute("value").length() > 0)) {
            System.out.println("Фінальний маршрут з поля \"Маршрут\": " + trueRouteFromRouteField);
        }

        if (trueRouteFromRouteField.equals(routeFromForms) || routeFromRouteField.equals("Доставка по місту " + senderCity)) {
            System.out.println();
            System.out.println("Маршрут побудовано вірно!");
        } else System.out.println("Помилка побудови маршруту!");

        if (citySenderInput.getAttribute("value").length() == 0) {
            System.out.println("Не обрано місто Відправника! Не можливо побудувати маршрут!");
        }
        if (cityRecipientInput.getAttribute("value").length() == 0) {
            System.out.println("Не обрано місто Отримувача! Не можливо побудувати маршрут!");
        }
    }

//======================================================================================================================

    @FindBy(xpath = "//div[contains (@id, 'boundlist')]/ul")
    private WebElement citiesSenderBox;

    @FindBy(xpath = "//div[contains (@id, 'boundlist') and not (contains(@style, 'display'))]/div")
    private WebElement citiesRecipientBox;

    @FindBy(xpath = "//div[@id = '2CitySender-bodyEl']/input")
    private WebElement citySenderInput;

    @FindBy(xpath = "//div[contains (@id, 'CityRecipient-bodyEl')]/input")
    private WebElement cityRecipientInput;

    @FindBy(xpath = "//input[@name=\"Route\"]")
    private WebElement routeInputField;

    @FindBy(xpath = "//div[contains(@id, 'CitySender-bodyEl')]/div/div[1]")
    private WebElement citySenderChooser;

    @FindBy(xpath = "//div[contains(@id, 'CityRecipient-bodyEl')]/div/div[1]")
    private WebElement cityRecipientChooser;

    @FindBy(xpath = "//div[contains(@id, 'FilterField-bodyEl')]/input[@role='textbox']")
    private WebElement cityFilterBoxInput;

    @FindBy(xpath = "//div[contains(@id, 'FilterField-triggerWrap')]/div[contains(@class, 'x-form-clear-trigger')]")
    private WebElement cityFilterBoxCleaner;

    @FindBy(xpath = "(//div[contains(@id, 'gridview')]/table/tbody/tr[contains(@class, 'x-grid-row-selected')])")
    private WebElement cityFilterTableChange;

    @FindBy(xpath = "//div[contains(@id, 'gridview')]/table")
    private WebElement cityFilterTableSet;

    @FindBy(xpath = "//tr[contains(@class,'x-grid-row-selected')]/td/div[contains(text(),'місто')]")
    private WebElement targetCity;

    @FindBy(xpath = "//div[contains(@id,'CitySender-triggerWrap')]/div[contains(@class,'x-form-clear-trigger')]")
    private WebElement citySenderInputCleaner;

    @FindBy(xpath = "//div[contains(@id,'CityRecipient-triggerWrap')]/div[contains(@class,'x-form-clear-trigger')]")
    private WebElement cityRecipientInputCleaner;

    @FindBy(xpath = "//tr[contains(@class,'x-grid-row-focused')]")
    private WebElement focusedRegion;
}