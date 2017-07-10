package Awis.actions.createEN;

import Awis.Conditions;
import Awis.Initializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 09.02.17.
 */

public class CreateEN_Opener extends Conditions {
    public CreateEN_Opener(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCreateENPage(){
        driver.get("http://wis14.np.ua/ULKTest/clients/extjs/index.php");
        Initializer init = new Initializer(driver);
        init.getAuthPage().setLoginAndPassword("homenko.a","123");
        init.getSelectionPage().openDocumentsEN();
        init.getCreateENbutton().clickCreateEN();
//        init.getSetENnuber().setNumber();
        init.getSetCounterparties().getStatusOfBoxes();
    }
}
