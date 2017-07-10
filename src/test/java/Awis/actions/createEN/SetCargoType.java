package Awis.actions.createEN;

import ClearTest.Conditions;
import ClearTest.Initializer;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 06.02.17.
 */

public class SetCargoType extends Conditions {

    WebDriverWait wait = new WebDriverWait(driver, 8);
    Initializer init = new Initializer(driver);

    public SetCargoType(WebDriver driver) {
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCargoTypeFromDropdown(String type) {
        waitForElementPresent(cargoTypeChooser);
        if (cargoTypeChooser.isDisplayed()) {
            System.out.println();
            System.out.println("Обираємо вид вантажу...");
            cargoTypeChooser.click();

            if (type.equals("Вантаж") || type.equals("вантаж")) {
                waitForElementPresent(cargo);
                cargo.click();
            }
            if (type.equals("Документи") || type.equals("документи")) {
                System.out.println();
                System.out.println("Обираємо 'Документи' ");
                waitForElementPresent(documents);
                documents.click();
                waitForElementPresent(quantity);
                System.out.println();
                System.out.println("OK.");

                System.out.print("Обираємо кількість...");
                quantity.click();
                justWait(200);
                quantity.sendKeys(Keys.BACK_SPACE);
                justWait(500);

                waitForElementPresent(customAlert);
                if (customAlert.isDisplayed()) {
                    System.out.println();
                    System.out.println("Алерт виден");
                } else {
                    System.out.println();
                    System.out.println("Алерт не виден");
                }

                customAlertAcceptDialog();

                quantity.sendKeys("2" + Keys.ENTER);
            }
            if (type.equals("Цінні папери") || type.equals("Цінні папери") || type.equals("папери")) {
                waitForElementPresent(valuablePapers);
                valuablePapers.click();
            }
            if (type.equals("Шини-диски") || type.equals("шини-диски") || type.equals("шини") || type.equals("диски")) {
                waitForElementPresent(tyresWheels);
                tyresWheels.click();
            }
            if (type.equals("Палети") || type.equals("палети")) {
                waitForElementPresent(palets);
                palets.click();
            }
        } else {
            System.err.println("Не можу обрати форму розрахунку!");
        }
    }

    public void selectCargoType(String type, String qty) {
        waitForElementPresent(cargoTypeChooser);
        if (cargoTypeChooser.isDisplayed()) {
            System.out.println();
            System.out.println("Обираємо вид вантажу... ");
            cargoTypeChooser.click();

//----------------------------------------------------------------------------------------------------------------------

            if (type.equals("Вантаж") || type.equals("вантаж")) {
                waitForElementPresent(cargo);
                cargo.click();
            }
//----------------------------------------------------------------------------------------------------------------------

            if (type.equals("Документи") || type.equals("документи")) {
                System.out.println();
                System.out.println("Обираємо 'Документи'");
                waitForElementPresent(documents);
                documents.click();
                System.out.println();
                System.out.println("OK.");

                System.out.print("Обираємо кількість...");
                quantity.click();
                justWait(200);
                quantity.sendKeys(Keys.BACK_SPACE);
                justWait(500);

                waitForElementPresent(customAlert);
                if (customAlert.isDisplayed()) {
                    System.out.println();
                    System.out.println("Бачимо вікно попередження");
                } else {
                    System.out.println();
                    System.err.println("Не бачимо вікна попередження");
                }
                customAlertAcceptDialog();

                System.out.println();
                System.out.println("Обираємо кількість: " + qty);
                quantity.sendKeys(qty + Keys.ENTER);

                justWait(200);
                System.out.println("Кількість встановлена в полі: " + quantity.getAttribute("value"));
                if (quantity.getAttribute("value").equals(qty)) {
                    System.out.println("OK.");
                } else {
                    System.err.println("Не вдадлся обрати кількість або кількість встановлено не вірно!");
                }

                System.out.print("Встановлюємо вагу: ");
                int qt = Integer.parseInt(quantity.getAttribute("value"));
                double summ = qt * 0.1;
                String value = String.valueOf(summ);

                System.out.println(value);
                waitForElementPresent(weight);
                weight.click();
                weight.clear();
                weight.sendKeys(value + Keys.ENTER);

                justWait(200);
                if (weight.getAttribute("value").length() > 2) {
                    System.out.println();
                    System.out.println("OK.");
                } else {
                    System.err.println("не вдалося встановити вагу!");
                }
            }

//----------------------------------------------------------------------------------------------------------------------

            if (type.equals("Цінні папери") || type.equals("Цінні папери") || type.equals("папери")) {
                waitForElementPresent(valuablePapers);
                valuablePapers.click();
            }

            if (type.equals("Шини-диски") || type.equals("шини-диски") || type.equals("шини") || type.equals("диски")) {
                waitForElementPresent(tyresWheels);
                tyresWheels.click();
            }

            if (type.equals("Палети") || type.equals("палети")) {
                waitForElementPresent(palets);
                palets.click();
            }

        } else {
            System.err.println("Не можу обрати форму розрахунку!");
        }
    }

    public void selectCargoType(String type) {
        waitForElementPresent(cargoTypeChooser);
        if (cargoTypeChooser.isDisplayed()) {
            System.out.println();
            System.out.println("Обираємо вид вантажу ... ");
            cargoTypeChooser.click();

//----------------------------------------------------------------------------------------------------------------------

            if (type.equals("Вантаж") || type.equals("вантаж")) {
                waitForElementPresent(cargo);
                cargo.click();
                waitForElementPresent(quantity);

                quantity.click();
                justWait(200);
                quantity.sendKeys(Keys.BACK_SPACE);
                justWait(500);
                customAlertAcceptDialog();

                System.out.println();
                System.out.print("Обираємо кількість: 1");
                quantity.sendKeys("1" + Keys.TAB);

                justWait(200);
                System.out.println();
                System.out.println("Кількість встановлена в полі: " + quantity.getAttribute("value"));
                if (quantity.getAttribute("value").equals("1")) {
                    System.out.println("OK.");
                } else {
                    System.err.println("Не вдадлся обрати кількість або кількість встановлено не вірно!");
                }

                System.out.println();
                System.out.print("Встановлюємо вагу: ");

                waitForElementPresent(weight);
                weight.click();
                weight.clear();
                weight.sendKeys("5" + Keys.ENTER);
                justWait(200);
                if (weight.getAttribute("value").length() > 0) {
                    System.out.println();
                    System.out.println("OK.");
                } else {
                    System.err.println("не вдалося встановити вагу!");
                }
            }

//----------------------------------------------------------------------------------------------------------------------

            if (type.equals("Документи") || type.equals("документи")) {
                System.out.println();
                System.out.println("Обираємо 'Документи'");
                waitForElementPresent(documents);
                documents.click();
                waitForElementPresent(quantity);
                System.out.println();
                System.out.println("OK.");

                quantity.click();
                justWait(200);
                quantity.sendKeys(Keys.BACK_SPACE);
                justWait(500);
                customAlertAcceptDialog();

                System.out.println();
                System.out.print("Обираємо кількість: 1");
                quantity.sendKeys("1" + Keys.TAB);

                justWait(200);
                System.out.println();
                System.out.println("Кількість встановлена в полі: " + quantity.getAttribute("value"));
                if (quantity.getAttribute("value").equals("1")) {
                    System.out.println("OK.");
                } else {
                    System.err.println("Не вдадлся обрати кількість або кількість встановлено не вірно!");
                }

                System.out.println();
                System.out.print("Встановлюємо вагу: ");
                int qt = Integer.parseInt(quantity.getAttribute("value"));
                double summ = qt * 0.1;
                String value = String.valueOf(summ);
                System.out.println(value);
                waitForElementPresent(weight);
                weight.click();
                weight.clear();
                weight.sendKeys(value + Keys.ENTER);
                justWait(200);
                if (weight.getAttribute("value").length() > 2) {
                    System.out.println();
                    System.out.println("OK.");
                } else {
                    System.err.println("не вдалося встановити вагу!");
                }
            }

//----------------------------------------------------------------------------------------------------------------------

            if (type.equals("Цінні папери") || type.equals("Цінні папери") || type.equals("папери")) {
                System.out.println();
                System.out.println("Обираємо 'Цінні папери'");
                waitForElementPresent(valuablePapers);
                valuablePapers.click();
                waitForElementPresent(moneyValueFrame);
                moneyValueInput.sendKeys("115");
                moneyValueButtonOK.click();

                if (cargoDescriptionInput.getAttribute("value").equals("Документи Ц1П")) {
                    System.out.println();
                    System.out.println("Опис вантажу вірний.");
                } else {
                    System.out.println();
                    System.err.println("Опис вантажу НЕ ВІРНИЙ!");
                }

                if (cargoPackTypeInput.getAttribute("value").equals("Цінний конверт") || cargoPackTypeInput.getAttribute("value").equals("Цінний пакет")) {
                    System.out.println("Вид пакування обрано вірно.");
                } else {
                    System.out.println();
                    System.err.println("Вид пакування обрано НЕ ВІРНО!");
                }
            }

//----------------------------------------------------------------------------------------------------------------------

            if (type.equals("Шини-диски") || type.equals("шини-диски") || type.equals("шини") || type.equals("диски")) {
                waitForElementPresent(tyresWheels);
                tyresWheels.click();
                wait.until(ExpectedConditions.visibilityOf(cargoCompositionPage));
//----------------------------------------------------------------------------------------------------------------------
//                                            ЛЕГКОВІ ШИНИ
//----------------------------------------------------------------------------------------------------------------------
                init.getAct().doubleClick(tyre_light_r13_14).perform();
                waitForElementPresent(tyresInput);
                tyresInput.clear(); tyresInput.sendKeys("1"+Keys.ENTER);

                init.getAct().doubleClick(tyre_light_r15_17).perform();
                waitForElementPresent(tyresInput);
                tyresInput.clear(); tyresInput.sendKeys("1"+Keys.ENTER);

                init.getAct().doubleClick(tyre_light_r18_19).perform();
                waitForElementPresent(tyresInput);
                tyresInput.clear(); tyresInput.sendKeys("1"+Keys.ENTER);

                init.getAct().doubleClick(tyre_light_r20_21).perform();
                waitForElementPresent(tyresInput);
                tyresInput.clear(); tyresInput.sendKeys("1"+Keys.ENTER);

                init.getAct().doubleClick(tyre_light_r23).perform();
                waitForElementPresent(tyresInput);
                tyresInput.clear(); tyresInput.sendKeys("1"+Keys.ENTER);
//----------------------------------------------------------------------------------------------------------------------
//                                          ЛЕГКОВІ ДИСКИ
//----------------------------------------------------------------------------------------------------------------------
                init.getAct().doubleClick(wheel_light_r13_14).perform();
                waitForElementPresent(wheelsInput);
                wheelsInput.clear(); wheelsInput.sendKeys("1"+Keys.ENTER);

                init.getAct().doubleClick(wheel_light_r15_17).perform();
                waitForElementPresent(wheelsInput);
                wheelsInput.clear(); wheelsInput.sendKeys("1"+Keys.ENTER);

                init.getAct().doubleClick(wheel_light_r18_19).perform();
                waitForElementPresent(wheelsInput);
                wheelsInput.clear(); wheelsInput.sendKeys("1"+Keys.ENTER);

                init.getAct().doubleClick(wheel_light_r20_21).perform();
                waitForElementPresent(wheelsInput);
                wheelsInput.clear(); wheelsInput.sendKeys("1"+Keys.ENTER);

                init.getAct().doubleClick(wheel_light_r23).perform();
                waitForElementPresent(wheelsInput);
                wheelsInput.clear(); wheelsInput.sendKeys("1"+Keys.ENTER);
//**********************************************************************************************************************
//----------------------------------------------------------------------------------------------------------------------
//                                          ВАНТАЖНІ ШИНИ
//----------------------------------------------------------------------------------------------------------------------
                init.getAct().doubleClick(tyre_cargo_r17_5).perform();
                waitForElementPresent(tyresInput);
                tyresInput.clear(); tyresInput.sendKeys("1"+Keys.ENTER);

                init.getAct().doubleClick(tyre_cargo_r19_5).perform();
                waitForElementPresent(tyresInput);
                tyresInput.clear(); tyresInput.sendKeys("1"+Keys.ENTER);

                init.getAct().doubleClick(tyre_cargo_r22_5).perform();
                waitForElementPresent(tyresInput);
                tyresInput.clear(); tyresInput.sendKeys("1"+Keys.ENTER);

                init.getAct().doubleClick(tyre_cargo_r20).perform();
                waitForElementPresent(tyresInput);
                tyresInput.clear(); tyresInput.sendKeys("1"+Keys.ENTER);

//----------------------------------------------------------------------------------------------------------------------
//                                          ВАНТАЖНІ ДИСКИ
//----------------------------------------------------------------------------------------------------------------------
                init.getAct().doubleClick(wheel_cargo_r17_5).perform();
                waitForElementPresent(wheelsInput);
                wheelsInput.clear(); wheelsInput.sendKeys("1"+Keys.ENTER);

                init.getAct().doubleClick(wheel_cargo_r19_5).perform();
                waitForElementPresent(wheelsInput);
                wheelsInput.clear(); wheelsInput.sendKeys("1"+Keys.ENTER);

                init.getAct().doubleClick(wheel_cargo_r22_5).perform();
                waitForElementPresent(wheelsInput);
                wheelsInput.clear(); wheelsInput.sendKeys("1"+Keys.ENTER);

                init.getAct().doubleClick(wheel_cargo_r20).perform();
                waitForElementPresent(wheelsInput);
                wheelsInput.clear(); wheelsInput.sendKeys("1"+Keys.ENTER);
//----------------------------------------------------------------------------------------------------------------------

                overallPage.click();
                waitForElementPresent(senderAddressChooser); //Очікуємо будь-який елемент на сторінці "Загальна"

            }

//----------------------------------------------------------------------------------------------------------------------

            if (type.equals("Палети") || type.equals("палети")) {
                waitForElementPresent(palets);
                palets.click();
            }

//----------------------------------------------------------------------------------------------------------------------
        } else {
            System.err.println("Не можу обрати форму розрахунку!");
        }
    }

//======================================================================================================================

    public void customAlertAcceptDialog() {
        if (customAlert.isDisplayed()) {
            System.out.println();
            System.out.println("Приймаємо попередження.");
            waitForElementPresent(customAlert);
            customAlertAccept.click();
        } else {
            System.out.println();
            System.err.println("Попередження не було ;)");
        }
    }
//======================================================================================================================
    public void setCargoType (String type){
        waitForElementPresent(cargoTypeChooser);
        if (cargoTypeChooser.isDisplayed()){
            System.out.println();
            System.out.println("Обираємо вид вантажу...");
            cargoTypeChooser.click();
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public void typeIsDocuments(String quantity){}
//----------------------------------------------------------------------------------------------------------------------
    public void typeIsCargo(String quantity, String weight){}
//----------------------------------------------------------------------------------------------------------------------
    public void typeIsValuablePapers(String quantity){}
//----------------------------------------------------------------------------------------------------------------------
    public void typeIsTyresWheels(String quantity){}
//----------------------------------------------------------------------------------------------------------------------
    public void typeIsPallets(String quantity){}
//======================================================================================================================

    @FindBy(xpath = "//input[@name='CargoType']/../../div[2]/div[1]")
    private WebElement cargoTypeChooser;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[contains(text(),'Вантаж')]")
    private WebElement cargo;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[contains(text(),'Документи')]")
    private WebElement documents;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[contains(text(),'Цінні папери')]")
    private WebElement valuablePapers;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[contains(text(),'Шини-диски')]")
    private WebElement tyresWheels;

    @FindBy(xpath = ".//div[contains(@id,'boundlist')]/ul/li[contains(text(),'Палети')]")
    private WebElement palets;

    @FindBy(xpath = ".//input[@name='SeatsAmount']")
    private WebElement quantity;

    @FindBy(xpath = ".//input[@name='DocumentWeight']")
    private WebElement weight;

    @FindBy(xpath = "//span[.='Введіть суму цінних паперів']")
    private WebElement moneyValueFrame;

    @FindBy(xpath = "//input[@name='ValuePaperField']")
    private WebElement moneyValueInput;

    @FindBy(xpath = "//button/span[contains(@id,'btnInnerEl') and contains(text(),'ОК')]")
    private WebElement moneyValueButtonOK;

    @FindBy(xpath = "//button/span[contains(@id,'btnInnerEl') and contains(text(),'Cancel')]")
    private WebElement moneyValueButtonCancel;

    @FindBy(xpath = "//input[@name='CargoDescriptionString']")
    private WebElement cargoDescriptionInput;

    @FindBy(xpath = "(.//div[contains(@id,'combobox')]/div[contains(@id,'bodyEl')]/input)[3]")
    private WebElement cargoPackTypeInput;

    @FindBy(xpath = ".//div[@role='alertdialog']")
    private WebElement customAlert;

    @FindBy(xpath = ".//div[@role='alertdialog']/div[contains(@id,'toolbar')]/div[@class='x-box-inner']/div[not(contains(@style,'display: none'))]")
    private WebElement customAlertAccept;

    @FindBy(xpath = ".//div[contains(@class,'x-window-header-body')]/div[@class='x-box-inner']/div[@role='button']")
    private WebElement customAlertClose;

    @FindBy(xpath = ".//div[contains(@class,'x-tab-top-active')]/em/button/span[.='Склад вантажу']")
    private WebElement cargoCompositionPage;

    @FindBy(xpath = "//button/span[.='Загальна']")
    private WebElement overallPage;

//======================================================================================================================
//                                                 TYRES-WHEELS
//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = ".//div[contains(text(),'Шина легкова R 13-14')]/../../td[2]")
    private WebElement tyre_light_r13_14;

    @FindBy(xpath = ".//div[contains(text(),'Шина легкова R 15-17')]/../../td[2]")
    private WebElement tyre_light_r15_17;

    @FindBy(xpath = ".//div[contains(text(),'Шина легкова R 18-19')]/../../td[2]")
    private WebElement tyre_light_r18_19;

    @FindBy(xpath = ".//div[contains(text(),'Шина легкова R 20-21')]/../../td[2]")
    private WebElement tyre_light_r20_21;

    @FindBy(xpath = ".//div[contains(text(),'Шина легкова R 23')]/../../td[2]")
    private WebElement tyre_light_r23;
//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = ".//div[contains(text(),'Диск легковий R 13-14')]/../../td[2]")
    private WebElement wheel_light_r13_14;

    @FindBy(xpath = ".//div[contains(text(),'Диск легковий R 15-17')]/../../td[2]")
    private WebElement wheel_light_r15_17;

    @FindBy(xpath = ".//div[contains(text(),'Диск легковий R 18-19')]/../../td[2]")
    private WebElement wheel_light_r18_19;

    @FindBy(xpath = ".//div[contains(text(),'Диск легковий R 20-21')]/../../td[2]")
    private WebElement wheel_light_r20_21;

    @FindBy(xpath = ".//div[contains(text(),'Диск легковий R 23')]/../../td[2]")
    private WebElement wheel_light_r23;
//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = ".//div[contains(text(),'Шина вантажна R 17,5')]/../../td[2]")
    private WebElement tyre_cargo_r17_5;

    @FindBy(xpath = ".//div[contains(text(),'Шина вантажна R 19,5')]/../../td[2]")
    private WebElement tyre_cargo_r19_5;

    @FindBy(xpath = ".//div[contains(text(),'Шина вантажна R 22,5')]/../../td[2]")
    private WebElement tyre_cargo_r22_5;

    @FindBy(xpath = ".//div[contains(text(),'Шина вантажна R 20')]/../../td[2]")
    private WebElement tyre_cargo_r20;
//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = ".//div[contains(text(),'Диск вантажний R 17,5')]/../../td[2]")
    private WebElement wheel_cargo_r17_5;

    @FindBy(xpath = ".//div[contains(text(),'Диск вантажний R 19,5')]/../../td[2]")
    private WebElement wheel_cargo_r19_5;

    @FindBy(xpath = ".//div[contains(text(),'Диск вантажний R 22,5')]/../../td[2]")
    private WebElement wheel_cargo_r22_5;

    @FindBy(xpath = ".//div[contains(text(),'Диск вантажний R 20')]/../../td[2]")
    private WebElement wheel_cargo_r20;
//**********************************************************************************************************************
//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = "//input[@name='Amount']")
    private WebElement tyresInput;

    @FindBy(xpath = ".//div[contains(@id,'GridWheelsAmount')]/input")
    private WebElement wheelsInput;

    @FindBy(xpath = "//label[.='Зворотня доставка:']/../div/input")
    private WebElement bdCheckbox;

    @FindBy(xpath = "//input[@name='SenderAddress']/../div/div[1]")
    private WebElement senderAddressChooser;
//======================================================================================================================
}
