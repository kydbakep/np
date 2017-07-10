package Awis.actions.createEN;

import Awis.Conditions;
import Awis.Initializer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 09.02.17.
 */

public class SetBackwardDelivery extends Conditions {

    Initializer init = new Initializer(driver);
    WebDriverWait wait = new WebDriverWait(driver, 8);

    public SetBackwardDelivery(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setBackwardDeliveryPayer(String backwardPayer){
        waitForElementPresent(bdPayerChooseForm);

        if (backwardPayer.equals("Відправник") || backwardPayer.equals("відправник")){
            Initializer init = new Initializer(driver);
            waitForElementPresent(bdPayerSender);
            init.getAct().doubleClick(bdPayerSender).perform();
        }
        if (backwardPayer.equals("Отримувач") || backwardPayer.equals("отримувач")){
            waitForElementPresent(bdPayerRecipient);
            init.getAct().doubleClick(bdPayerRecipient).perform();
        }
        else System.err.println("Не обрано або не вірно обрано платника зворотньої доставки!");
    }

    public void setBackwardDeliveryType(String cargoType) throws Exception {
        waitForElementPresent(bdCargoType);
        init.getAct().click(driver.findElement(By.xpath(".//div[contains(@id,'boundlist')]/ul/li[contains(text(),'"+cargoType+"')]"))).perform();
//----------------------------------------------------------------------------------------------------------------------

        if (cargoType.equals("Документи")){
            System.out.println();
            waitForElementPresent(bdDocumentsIsSet);
            if (bdDocumentsIsSet.isDisplayed()){
                System.out.println("Обрано: Документи");
            }
            else System.err.println("Не вдалося обрати Документи");

            System.out.println();
            System.out.println("Документики");
        }

//----------------------------------------------------------------------------------------------------------------------

        if (cargoType.equals("Гроші")){
            waitForElementPresent(bdMoneyValueFrame);
            System.out.println();
            System.out.println("Вводимо суму: 185");
            bdMoneyValueInput.clear(); bdMoneyValueInput.sendKeys("185");
            bdMoneyValueFrameOK.click();
            waitForElementPresent(bdMoneyIsSet);
            justWait(200);
            if (bdMoneyIsSet.isDisplayed()){
                System.out.println();
                System.out.println("Обрано: Гроші");
            }
            else {
                System.out.println();
                System.err.println("Не вдалося обрати суму грошей!");
            }
        }

//----------------------------------------------------------------------------------------------------------------------

        if (cargoType.equals("Піддони")) {
            waitForElementPresent(bdPalletsFrameSelect);
            init.getAct().doubleClick(bdPalletsEuropeanInputActivator).perform();
            bdPalletsInput.clear();
            bdPalletsInput.sendKeys("3" + Keys.ENTER);

            init.getAct().doubleClick(bdPalletsAmericanInputActivator).perform();
            bdPalletsInput.clear();
            bdPalletsInput.sendKeys("3" + Keys.ENTER);
            bdPalletsOKButton.click();

            justWait(200);
            System.out.println();

            for (int i = 0; i <20 ; i++) {
                if (bdDescriptionCell.getText().length()>0){
                    System.out.println("Опис заповнено: "+bdDescriptionCell.getText());
                    break;
                }
                else{
                    System.out.println("Опис не заповнено!");
                    justWait(200);
                }
            }
        }

//----------------------------------------------------------------------------------------------------------------------

        if (cargoType.equals("Інше")){
            waitForElementPresent(bdOther);
            System.out.println();
            init.getAct().doubleClick(bdDescriptionCell).perform();
            bdDescriptionCellInput.sendKeys("Сало в шоколаді"+Keys.ENTER);

            waitForTextPresent(bdDescriptionCell);

            System.out.println("Обрано: Інше - "+bdDescriptionCell.getText());
        }

//----------------------------------------------------------------------------------------------------------------------

        if (cargoType.equals("Кредитні документи")){
            waitForElementPresent(bdCreditDocuments);
            System.out.println();
            justWait(100);
            System.out.println("!!!"+bdDescriptionCell.getText());
            if (cargoType.equals(bdDescriptionCell.getText())){
                System.out.println("OK. Опис вірний.");
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    public void setBackwardDelivery(String backwardPayer, String cargoType) throws Exception {
        waitForElementPresent(bdCheckbox);

        init.clickJS(bdCheckbox);

        setBackwardDeliveryPayer(backwardPayer);
        setBackwardDeliveryType(cargoType);
    }

//======================================================================================================================

    @FindBy(xpath = "//label[.='Зворотня доставка:']/../div/input")
    private WebElement bdCheckbox;

    @FindBy(xpath = "//span[.='Оберіть платника звор. доставки']")
    private WebElement bdPayerChooseForm;

    @FindBy(xpath = "(//div[contains(text(),'Відправник')])[last()]")
    private WebElement bdPayerSender;

    @FindBy(xpath = "(//div[contains(text(),'Отримувач')])[last()]")
    private WebElement bdPayerRecipient;

    @FindBy(xpath = "(.//div[contains(@id,'boundlist')]/ul)[last()]")
    private WebElement bdCargoType;

    @FindBy(xpath = "//td[contains(@class,'x-grid-cell-selected')]/div[.='Документи']")
    private WebElement bdDocumentsIsSet;

    @FindBy(xpath = "//td[contains(@class,'x-grid-cell-selected')]/div[.='Гроші']")
    private WebElement bdMoney;

    @FindBy(xpath = "(.//span[contains(text(),'OK')])[last()]")
    private WebElement bdMoneyValueFrameOK;

    @FindBy(xpath = "(.//span[contains(text(),'Cancel')])")
    private WebElement bdMoneyValueFrameCancel;

    @FindBy(xpath = "//span[.='Введіть суму цінних паперів']")
    private WebElement bdMoneyValueFrame;

    @FindBy(xpath = ".//div[contains(text(),'Документи Ц1П')]")
    private WebElement bdMoneyIsSet;

    @FindBy(xpath = ".//*[@id='ext-gen1001']")
    private WebElement bdMoneyValueInput;

    @FindBy(xpath = "//td[contains(@class,'x-grid-cell-selected')]/div[.='Піддони']")
    private WebElement bdPallets;

    @FindBy(xpath = ".//span[.='Заповнення кількості піддонів']")
    private WebElement bdPalletsFrameSelect;

    @FindBy(xpath = ".//input[@name='Amount']")
    private WebElement bdPalletsInput;

    @FindBy(xpath = ".//div[contains(text(),'Європейський стандарт')]/../../td[contains(@class,'numbercolumn')]")
    private WebElement bdPalletsEuropeanInputActivator;

    @FindBy(xpath = ".//div[contains(text(),'Американський стандарт')]/../../td[contains(@class,'numbercolumn')]")
    private WebElement bdPalletsAmericanInputActivator;

    @FindBy(xpath = ".//button[@role='button']/span[.='Внести']")
    private WebElement bdPalletsOKButton;

    @FindBy(xpath = ".//button[@role='button']/span[.='Відміна']")
    private WebElement bdPalletsCancelButton;

    @FindBy(xpath = "(.//div[contains(@id,'GridBackwardDeliveryData-body')]/div[contains(@id,'gridview')]/table/tbody/tr[contains(@id,'ext-gen')]/td[3])")
    private WebElement bdDescriptionCell;


    @FindBy(xpath = ".//div[contains(@id,'GridBackwardDeliveryDataDescription-bodyEl')]/input")
    private WebElement bdDescriptionCellInput;

    @FindBy(xpath = "//td[contains(@class,'x-grid-cell-selected')]/div[.='Інше']")
    private WebElement bdOther;

    @FindBy(xpath = "//td[contains(@class,'x-grid-cell-selected')]/div[.='Кредитні документи']")
    private WebElement bdCreditDocuments;
}


//(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//public Boolean apply(WebDriver d) {
//        return d.findElement(...).getText().length() != 0;
//        }
//        });