package Awis;

import Awis.actions.createEN.*;
import Awis.actions.requestFence.*;
import Awis.audio.AudioFilePlayer;
import Awis.constructor.Constructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 09.02.17.
 */

public class Initializer extends Conditions {

    public Initializer(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AuthPage getAuthPage(){
        return new AuthPage(driver);
    }

    public SelectionPage getSelectionPage() {
        return new SelectionPage(driver);
    }

    public ClickCreateENbutton getCreateENbutton() {return new ClickCreateENbutton(driver);}

    public SetENnuber getSetENnuber() {
        return new SetENnuber(driver);
    }

    public SetCounterPartyCity getSetCounterpartyCity() {
        return new SetCounterPartyCity(driver);
    }

    public SetCounterParties getSetCounterparties() {
        return new SetCounterParties(driver);
    }

    public SetAddress getSetAddress() {
        return new SetAddress(driver);
    }

    public CheckTitles getCheckTitles() {
        return new CheckTitles(driver);
    }

    public CreateEN_Opener getOpenCreateENpage(){
        return new CreateEN_Opener(driver);
    }

    public SetPaymantMethod getSetPaymantMethod(){
        return new SetPaymantMethod(driver);
    }

    public SetCargoType getSetCargoType(){return new SetCargoType(driver);}

    public WriteENButton getWriteEN(){
        return new WriteENButton(driver);
    }

    public SetENnuber getSetNumber(){
        return new SetENnuber(driver);
    }

    public SetCost getSetCost(){
        return new SetCost(driver);
    }

    public SetDeliveryPayer getSetDeliveryPayer(){
        return new SetDeliveryPayer(driver);
    }

    public SetBackwardDelivery getSetBackwardDelivery(){
        return new SetBackwardDelivery(driver);
    }

    public AudioFilePlayer getPlayer(){
       return new AudioFilePlayer();
    }

    public Actions getAct(){
        return new Actions(driver);
    }

//----------------------------------------------------------------------------------------------------------------------

    public WorkplaceOpener tms(){return new WorkplaceOpener(driver);}
    public NewRequest newRequest(){return new NewRequest(driver);}
    public SetCity setCity(){return new SetCity(driver);}
    public SetCounterParty setCounterParty(){return new SetCounterParty(driver);}
    public SetHomeAddress setHomeAddress(){return new SetHomeAddress(driver);}

    public PaymentInfo information(){return new PaymentInfo(driver);}
    public Constructor constructor() {return new Constructor();}

    public TakeFromEN takeFromEN(){return new TakeFromEN(driver);}
    public CargoPreferences cargoPreferences(){return new CargoPreferences(driver);}

    public BackwardDelivery delivery(){return new BackwardDelivery(driver);}
    public SelectCargoType cargoType(){return new SelectCargoType(driver);}

//**********************************************************************************************************************
//**********************************************************************************************************************

    public DocumentPreferences preferences(){return new DocumentPreferences(driver);}
    public WriteRequestFence writeFence(){return new WriteRequestFence(driver);}

//**********************************************************************************************************************

    private JavascriptExecutor executor = (JavascriptExecutor)driver;

    public void clickJS(WebElement element){
        executor.executeScript("arguments[0].click()", element);
    }

}
