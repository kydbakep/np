package Awis.actions.catalogue.counterparties;

import ClearTest.Conditions;
import ClearTest.Initializer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

class CounterPartiesPage extends Conditions{
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);

    CounterPartiesPage(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void getCellInfo() {
        waitForElementPresent(codeCellFirst);
        System.out.println(codeCellFirst.getText());
    }

    void getCellInfo(int cellNumber){
        waitForElementPresent(codeCellFirst);
        WebElement cell = (driver.findElement(By.xpath(".//div[contains(@id,'gridview')]//tr[" + (cellNumber+1) + "]/td[3]")));
        System.out.println(cell.getText());
    }

    void fillCodeInput() {
        waitForElementPresent(codeCellFirst);
        codeInput.sendKeys((codeCellFirst.getText()) + Keys.TAB);
    }
    void clearCode(){
        waitForElementPresent(codeCleaner);
        codeCleaner.click();
        justWait(200);
    }

    void fillNameInput(){
        waitForElementPresent(nameCellFirst);
        int i = 1;
        WebElement cell = (driver.findElement(By.xpath(".//div[contains(@id,'gridview')]//tr[" + (i+1) + "]/td[15]")));

        do {
            cell = (driver.findElement(By.xpath(".//div[contains(@id,'gridview')]//tr[" + (i+1) + "]/td[15]")));
            if (cell.getText().length()>1){
                System.out.println();
                System.out.println("value: '"+cell.getText()+"'");
                nameInput.sendKeys(cell.getText()+Keys.TAB);
            }
            else {
                System.out.println();
                System.out.println(i);
            }
            i++;
        } while (cell.getText().length()<=1);
    }
    void clearName(){
        waitForElementPresent(nameCleaner);
        nameCleaner.click();
        justWait(200);
    }

    void fillEDRPOUinput(){
        waitForElementPresent(EDRPOUcellFirst);
        int i = 1;
        WebElement cell = (driver.findElement(By.xpath(".//div[contains(@id,'gridview')]//tr[" + (i+1) + "]/td[16]")));

        do {
            cell = (driver.findElement(By.xpath(".//div[contains(@id,'gridview')]//tr[" + (i+1) + "]/td[16]")));
            if (cell.getText().length()>1){
                System.out.println();
                System.out.println("value: '"+cell.getText()+"'");
                EDRPOUinput.sendKeys(cell.getText()+Keys.TAB);
            }
            else {
                System.out.println();
                System.out.println(i);
            }
            i++;
        } while (cell.getText().length()<=1);
    }
    void clearEDRPOU(){
        waitForElementPresent(EDRPOUcleaner);
        EDRPOUcleaner.click();
        justWait(200);
    }

    void reload(){
        waitForElementPresent(reloadPageButton);
        reloadPageButton.click();
        justWait(200);
    }

    void editPageOpen(){
        waitForElementPresent(codeCellFirst);
        init.getAct().click(codeCellFirst).perform();
        editButton.click();
    }
//----------------------------------------------------------------------------------------------------------------------
    void gotoMenuOpen(){
        waitForElementPresent(codeCellFirst);
        init.getAct().click(codeCellFirst).perform();

        waitForElementPresent(gotoMenuButton);
        gotoMenuButton.click();
        justWait(200);
    }
    void gotoCounterParties(){
        waitForElementPresent(gotoCounterParties);
        init.getAct().click(gotoCounterParties).perform();
        justWait(200);
    }
    void gotoParameters(){
        waitForElementPresent(gotoParameters);
        init.getAct().click(gotoParameters).perform();
        justWait(200);
    }
    void gotoAddresses(){
        waitForElementPresent(gotoAddresses);
        init.getAct().click(gotoAddresses).perform();
        justWait(200);
    }

    void gotoTest(){
        gotoMenuOpen();
        gotoParameters();
        justWait(2000);
        parametersTabCloser.click();

        gotoMenuOpen();
        gotoAddresses();
        justWait(2000);
        addressesTabCloser.click();

        gotoMenuOpen();
        gotoCounterParties();
        justWait(2000);
        counterPartyTabCloser.click();
    }

    @FindBy(xpath = ".//button[span='Параметри нестандартних ЕН на підставі']/../../a")
    private WebElement parametersTabCloser;

    @FindBy(xpath = ".//button[span='Адреси']/../../a")
    private WebElement addressesTabCloser;

    @FindBy(xpath = ".//button[span='Контрагенти']/../../a")
    private WebElement counterPartyTabCloser;

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//div[contains(@id,'FilterFieldEDRPOU-bodyEl')]/input")
    private WebElement EDRPOUinput;

    @FindBy(xpath = ".//div[contains(@id,'FilterFieldEDRPOU-bodyEl')]/input/../div[div[@class='x-clear']]")
    private WebElement EDRPOUcleaner;

    @FindBy(xpath = ".//div[contains(@id,'gridview')]//tr[2]/td[16]")
    private WebElement EDRPOUcellFirst;

    @FindBy(xpath = ".//div[contains(@id,'FilterFieldCode-bodyEl')]/input")
    private WebElement codeInput;

    @FindBy(xpath = ".//div[contains(@id,'FilterFieldCode-bodyEl')]/input/../div[div[@class='x-clear']]")
    private WebElement codeCleaner;

    @FindBy(xpath = ".//div[contains(@id,'FilterField-bodyEl')]/input")
    private WebElement nameInput;

    @FindBy(xpath = ".//div[contains(@id,'FilterField-bodyEl')]/input/../div[div[@class='x-clear']]")
    private WebElement nameCleaner;

    @FindBy(xpath = ".//button[span='Редагувати']")
    private WebElement editButton;

    @FindBy(xpath = ".//button[@data-qtip='Перша сторінка']")
    private WebElement firstPageButton;

    @FindBy(xpath = ".//button[@data-qtip='Наступна сторінка']")
    private WebElement nextPageButton;

    @FindBy(xpath = ".//button[@data-qtip='Попередня сторінка']")
    private WebElement prevPageButton;

    @FindBy(xpath = ".//button[@data-qtip='Остання сторінка']")
    private WebElement lastPageButton;

    @FindBy(xpath = ".//button[@data-qtip='Освіжити']")
    private WebElement reloadPageButton;

//--------------------------------------------------------------------

    @FindBy(xpath = ".//button[span='Перейти']")
    private WebElement gotoMenuButton;
    @FindBy(xpath = ".//span[.='Контактні особи']")
    private WebElement gotoCounterParties;
    @FindBy(xpath = ".//span[.='Параметри нестандартних ЗД']")
    private WebElement gotoParameters;
    @FindBy(xpath = ".//span[.='Адреси']")
    private WebElement gotoAddresses;

//--------------------------------------------------------------------
    @FindBy(xpath = ".//div[contains(@id,'gridview')]//tr[2]/td[3]")
    private WebElement codeCellFirst;

    @FindBy(xpath = ".//div[contains(@id,'gridview')]//tr[2]/td[15]")
    private WebElement nameCellFirst;
}
