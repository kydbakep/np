package Awis.actions.catalogue.conglomerates;

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
    public void CatalogueConglomerates() throws Exception {
        CatalogueItemsOpener opener = new CatalogueItemsOpener(driver);

        for (int i = 0; i < 1; i++) {

            opener.openConglomeratsPage();
            ConglomeratesPage conglomeratesPage = new ConglomeratesPage(driver);
            conglomeratesPage.nextAndBack();
            conglomeratesPage.applyFilter("Київ", "button");

            DetailsPage detailsPage = new DetailsPage(driver);
            detailsPage.addNew();

            CitiesPage cities = new CitiesPage(driver);
            cities.setCity("Авіаторське");
            detailsPage.write();

            cities.removeCity("Авіаторське");
            detailsPage.write();
            detailsPage.pressOK();

            conglomeratesPage.closeTab();
        }
    }
}
