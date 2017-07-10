package Awis.actions.catalogue.cityAreas;

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
    public void CityAreas() throws Exception {
        CatalogueItemsOpener opener = new CatalogueItemsOpener(driver);
        ToolbarTypeTwo toolbar = new ToolbarTypeTwo(driver);
        CashRegistersPage page = new CashRegistersPage(driver);
        CashRegistersDetailsPage details = new CashRegistersDetailsPage(driver);
        TerminalsPage terminal = new TerminalsPage(driver);

        for (int i = 0; i < 1; i++) {

            opener.openCityAreasPage();

        }
    }
}
