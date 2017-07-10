package Awis.actions.catalogue.counterparties;

import Awis.Conditions;
import Awis.actions.catalogue.CatalogueItemsOpener;
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
    public void CatalogueCounterParties() throws Exception {
        CatalogueItemsOpener opener = new CatalogueItemsOpener(driver);
        CounterPartiesPage page = new CounterPartiesPage(driver);
        for (int i = 0; i < 1; i++) {

            opener.openCounterPartiesPage();

            page.fillEDRPOUinput();
            justWait(2000);
            page.clearEDRPOU();

            page.fillCodeInput();
            justWait(2000);
            page.clearCode();

            page.fillNameInput();
            justWait(2000);
            page.clearName();

            page.reload();

            page.editPageOpen();

            CounterPartyEditPage edit = new CounterPartyEditPage(driver);

            justWait(2000);
            edit.editPageClose();

            page.gotoTest();

        }
    }
}
