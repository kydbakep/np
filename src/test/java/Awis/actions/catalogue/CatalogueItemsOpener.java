package Awis.actions.catalogue;

import ClearTest.Conditions;
import ClearTest.Initializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

public class CatalogueItemsOpener extends Conditions {
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 5);

    public CatalogueItemsOpener(WebDriver driver) {
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

//----------------------------------------------------------------------------------------------------------------------

    private void loginAs(String login, String password){
        driver.get("http://wis14.np.ua/ULKTest/clients/extjs/index.php");
        init.getAuthPage().setLoginAndPassword(login, password);
    }

//----------------------------------------------------------------------------------------------------------------------

    private void setConglomeratesPage() {

        init.getSelectionPage().openCatalugue();
        init.getSelectionPage().openConglomerates();
        waitForElementPresent(conglomeratesTab);
        wait.until(ExpectedConditions.visibilityOf(resultTable));
        if (resultTable.isDisplayed()) {
            System.out.println();
            System.out.println("Сторінку 'Конгломерати' завантажено успішно!");
        } else {
            System.out.println();
            System.err.println("Не можу завантажити сторінку 'Конгломерати!'");
        }
    }

    public void openConglomeratsPage() {
        if (driver.getTitle().equals("ТОВ \"Нова Пошта\"")) {
            setConglomeratesPage();
        } else {
//            driver.get("http://wis14.np.ua/ULKTest/clients/extjs/index.php");
//            init.getAuthPage().setLoginAndPassword("homenko.a", "123");
            loginAs("homenko.a", "123");
            setConglomeratesPage();
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    private void setCounterPartiesPage(){
        init.getSelectionPage().openCatalugue();
        init.getSelectionPage().openCounterParties();
    }

    public void openCounterPartiesPage(){
//        if (driver.getTitle().equals("ТОВ \"Нова Пошта\"")) {
//            setCounterPartiesPage();
//        } else{
//            driver.get("http://wis14.np.ua/ULKTest/clients/extjs/index.php");
//            init.getAuthPage().setLoginAndPassword("homenko.a", "123");
        loginAs("homenko.a", "123");
        setCounterPartiesPage();
//        }
    }
//----------------------------------------------------------------------------------------------------------------------
    private void setParcelStationsPage(){
        init.getSelectionPage().openCatalugue();
        init.getSelectionPage().openParcelStations();
    }
    public void openParcelStationsPage(){
//        driver.get("http://wis14.np.ua/ULKTest/clients/extjs/index.php");
//        init.getAuthPage().setLoginAndPassword("homenko.a", "123");
        loginAs("homenko.a", "123");
        setParcelStationsPage();
    }
//----------------------------------------------------------------------------------------------------------------------
    private void setCashRegistersPage(){
        init.getSelectionPage().openCatalugue();
        init.getSelectionPage().openCashRegisters();
    }
    public void openCashRegistersPage(){
//        driver.get("http://wis14.np.ua/ULKTest/clients/extjs/index.php");
//        init.getAuthPage().setLoginAndPassword("homenko.a", "123");
        loginAs("homenko.a", "123");
        setCashRegistersPage();
    }
//----------------------------------------------------------------------------------------------------------------------
    private void setFiscalRegistrarsPage(){
        init.getSelectionPage().openCatalugue();
        init.getSelectionPage().openFiscalRegistrars();
    }

    public void openFiscalRegistrarsPage(){
//        driver.get("http://wis14.np.ua/ULKTest/clients/extjs/index.php");
//        init.getAuthPage().setLoginAndPassword("homenko.a", "123");
        loginAs("homenko.a", "123");
        setFiscalRegistrarsPage();
    }

//----------------------------------------------------------------------------------------------------------------------
    private void setCityAreasPage(){
        init.getSelectionPage().openCatalugue();
        init.getSelectionPage().openCityAreas();
    }
    public void openCityAreasPage(){
        loginAs("homenko.a", "123");
        setCityAreasPage();
    }
//======================================================================================================================
    @FindBy(xpath = ".//button[span='Конгломерати']")
    private WebElement conglomeratesTab;

    @FindBy(xpath = ".//div[contains(@id,'Grid-body')]//table/tbody")
    private WebElement resultTable;

    @FindBy(xpath = ".//button[span='Реєстр комірок поштоматів']")
    private WebElement parcelStationsTab;
}
