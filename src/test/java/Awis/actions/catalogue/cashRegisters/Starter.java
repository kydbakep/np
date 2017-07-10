package Awis.actions.catalogue.cashRegisters;

import ClearTest.Conditions;
import ClearTest.actions.catalogue.CatalogueItemsOpener;
import ClearTest.toolbars.ToolbarTypeTwo;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ! Created by tober on 24.02.17.
 */

public class Starter extends Conditions {

    @Before
    public void BeforeTest(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(250, TimeUnit.MILLISECONDS);
    }

//    @Test
    public void CatalogueCashRegisters() throws Exception {
        CatalogueItemsOpener opener = new CatalogueItemsOpener(driver);
        ToolbarTypeTwo toolbar = new ToolbarTypeTwo(driver);
        CashRegistersPage page = new CashRegistersPage(driver);
        CashRegistersDetailsPage details = new CashRegistersDetailsPage(driver);
//        TerminalsPage terminal = new TerminalsPage(driver);


        for (int i = 0; i < 1; i++) {

            opener.openCashRegistersPage();
            toolbar.checkForTableIsLoad();

            toolbar.clickNextPageButton();
            justWait(500);
            toolbar.clickPreviousPageButton();
            justWait(500);
            toolbar.clickLastPageButton();
            justWait(500);
            toolbar.clickFirstPageButton();
            justWait(500);

            toolbar.fillPageNumberInput("2");
//            toolbar.fillFilterField("1000"); // Не працює
            page.editRecord("Щаслива каса");

            details.setCode("7");
            details.setDescription("Щаслива каса");
            details.setNumber("2");

            details.setCity("Київ");

            details.setWarehouse("термінал", "1");

            page.addAffiliate("Бердичів");
            page.addAffiliate("Жмеринка");
            page.removeAffiliate("Жмеринка");

            toolbar.clickWriteButton();

//            toolbar.clickOKButton();
//            page.closeTab();




        }
    }

    @Test
    public void counter(){

        CatalogueItemsOpener opener = new CatalogueItemsOpener(driver);
        opener.openCashRegistersPage();

        WebElement WebElement = driver.findElement(By.xpath("//div"));
        // Create an IList and intialize it with all the elements of div under div with **class as facetContainerDiv**
        List<WebElement> AllCheckBoxes = WebElement.findElements(By.xpath("//span"));
        // Get the count of check boxes
        int RowCount = WebElement.findElements(By.xpath("//span")).size();
        for (int i = 0; i < RowCount; i++)
        {
            // Check the check boxes based on index
//            AllCheckBoxes.get(i).click();
            System.out.println(AllCheckBoxes.get(i));

        }

    }
}