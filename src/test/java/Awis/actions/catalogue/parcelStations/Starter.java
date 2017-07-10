package Awis.actions.catalogue.parcelStations;

import Awis.Conditions;
import Awis.actions.catalogue.CatalogueItemsOpener;
import Awis.toolbars.ToolbarTypeTwo;
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
    public void CatalogueParcelStations() throws Exception {
        CatalogueItemsOpener opener = new CatalogueItemsOpener(driver);
        ParcelStationsPage page = new ParcelStationsPage(driver);
        ToolbarTypeTwo toolbar = new ToolbarTypeTwo(driver);
        ParcelStationDetailsPage details = new ParcelStationDetailsPage(driver);

        for (int i = 0; i < 1; i++) {

            opener.openParcelStationsPage();
            toolbar.checkForTableIsLoad();

            toolbar.clickNextPageButton();
            justWait(1000);
            toolbar.clickPreviousPageButton();
            justWait(1000);
            toolbar.clickLastPageButton();
            justWait(1000);
            toolbar.clickFirstPageButton();
            justWait(1000);


            toolbar.fillPageNumberInput("2");
            toolbar.fillFilterField("цуацу");

            page.editRecord();

            details.selectCellType("Small");

            toolbar.clickWriteButton();
            toolbar.clickOKButton();

        }
    }
}
