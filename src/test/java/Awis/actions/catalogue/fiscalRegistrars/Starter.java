package Awis.actions.catalogue.fiscalRegistrars;

import ClearTest.Conditions;
import ClearTest.TerminalsPage;
import ClearTest.actions.catalogue.CatalogueItemsOpener;
import ClearTest.actions.catalogue.cashRegisters.CashRegistersDetailsPage;
import ClearTest.actions.catalogue.cashRegisters.CashRegistersPage;
import ClearTest.toolbars.ToolbarTypeTwo;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

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

    @Test
    public void CatalogueCashRegisters() throws Exception {
        CatalogueItemsOpener opener = new CatalogueItemsOpener(driver);
        FiscalRegistrarsPage page = new FiscalRegistrarsPage(driver);
        FiscalRegistrarsDetailsPage details = new FiscalRegistrarsDetailsPage(driver);

        for (int i = 0; i < 1; i++) {

            opener.openFiscalRegistrarsPage();
            page.fillFilter("asdas");
            page.editFirstRecord();
            details.setCity("Миколаїв");
            details.setWarehouse("1","Відділення");
            details.setCounterparty("ТОВ \"НОВА ПОШТА\"");
            details.pressOK();
        }
    }
}
