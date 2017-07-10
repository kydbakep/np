package Awis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *! Created by tober on 29.01.17.
 */

public class SelectionPage extends Conditions {

    Initializer init = new Initializer(driver);

    public SelectionPage(WebDriver driver){
        Conditions.driver = driver;

        PageFactory.initElements(driver, this);
        waitForElementPresent(documents);
    }

// Експрес-накладна
    public void openDocumentsEN() {

        System.out.println();
        System.out.print("Відкриваємо меню \"Документи\"");
        documents.click();
        quickWaitForElementPresent(documentsEN);
        if (documentsEN.isDisplayed()) {
            System.out.println();
            System.out.println(" OK.");
        } else System.out.println("Failed!");

        System.out.println();
        System.out.print("Обираємо 'Експрес-накладна'");
        documentsEN.click();
        waitForElementPresent(documentsENtab);
        if (documentsENtab.isDisplayed()){
            System.out.println();
            System.out.println(" OK.");
        }
        else {
            System.out.println();
            System.out.println("Failed!");
        }
    }

// Заявка на забір
    public void openRequestFence(){
        System.out.println();
        System.out.print("Відкриваємо меню \"Робочі місця\"");
        workplaces.click();
        quickWaitForElementPresent(tms);
        if (tms.isDisplayed()) {
            System.out.println();
            System.out.println("TMS OK.");
            init.getAct().moveToElement(tms).build().perform();
            waitForElementPresent(hostControllerWorkplace);
            hostControllerWorkplace.click();
        } else System.out.println("Failed!");

        System.out.println();
        System.out.println("Обираємо 'Робоче місце приймаючого диспетчера'");
    }

    public void openCatalugue(){
        waitForElementPresent(catalogue);
        catalogue.click();
    }
    public void openConglomerates(){
        waitForElementPresent(conglomerates);
        conglomerates.click();
    }

    public void openCounterParties(){
        waitForElementPresent(counterParties);
        counterParties.click();
    }

    public void openParcelStations(){
        waitForElementPresent(parcelStations);
        parcelStations.click();
    }

    public void openCashRegisters(){
        waitForElementPresent(cashRegisters);
        cashRegisters.click();
    }

    public void openFiscalRegistrars(){
        waitForElementPresent(fiscalRegistrars);
        fiscalRegistrars.click();
    }

    public void openCityAreas(){
        waitForElementPresent(cityAreas);
        cityAreas.click();
    }

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//SPAN[.='Довідники']")
    private WebElement catalogue;

//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = "//SPAN[.='Контрагенти']")
    private WebElement counterParties;

    @FindBy(xpath = "//SPAN[.='Конгломерати']")
    private WebElement conglomerates;

    @FindBy(xpath = "//SPAN[.='Реєстр комірок поштоматів']")
    private WebElement parcelStations;

    @FindBy(xpath = ".//a[span='Каси']")
    private WebElement cashRegisters;

    @FindBy(xpath = "//span[.='Фіскальні реєстратори']")
    private WebElement fiscalRegistrars;

    @FindBy(xpath = "//span[.='Райони міста']")
    private WebElement cityAreas;

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//button[span = 'Документи']")
    private WebElement documents;

    @FindBy(xpath = "//a[span = 'Експрес-накладна']")
    private WebElement documentsEN;

    @FindBy(xpath = "//button[span = 'Робочі місця']")
    private WebElement workplaces;

    @FindBy(xpath = "//a[span = 'TMS']")
    private WebElement tms;

    @FindBy(xpath = "//span[contains(text(),'Робоче місце приймаючого диспетчера')]")
    private WebElement hostControllerWorkplace;



// FOR COMPARES
    @FindBy(xpath = "//span[@class='x-tab-inner' and contains(text(),'Експрес-накладна')]")
    private WebElement documentsENtab;
}
