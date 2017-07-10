package Awis.actions.requestFence;

import ClearTest.Conditions;
import ClearTest.Initializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 15.02.17.
 */

public class WorkplaceOpener extends Conditions{
    private Initializer init = new Initializer(driver);

    public WorkplaceOpener(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openWorkplaceTMS(){
//        driver.get("http://wis14.np.ua/~ilchenko.as/RPZ-29557/clients/extjs/index.php");
        driver.get("http://wis14.np.ua/ULKTest/clients/extjs/index.php");
        init.getAuthPage().setLoginAndPassword("homenko.a","123");
        init.getSelectionPage().openRequestFence();
    }
}
