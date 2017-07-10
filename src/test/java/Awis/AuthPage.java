package Awis;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

/**
 * ! Created by tober on 29.01.17.
 */

public class AuthPage extends Conditions {

    AuthPage(WebDriver driver) {

        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
        waitForElementPresent(authFrame);
    }

    @FindBy(xpath = "//span[.='Вхід в систему']")
    private WebElement authFrame;

    @FindBy(xpath = "//input[@id='ext-gen1035']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='ext-gen1037']")
    private WebElement passwordInput;

    public void setLoginInput(String login){
        waitForElementPresent(loginInput);
        loginInput.clear();
        loginInput.sendKeys(login);
    }

    public void setPasswordInput(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void setLoginAndPassword(String login, String password){
//-----------------------------------------------------------------------------
        quickWaitForElementPresent(loginInput);

        loginInput.clear();
        loginInput.sendKeys(login);
        System.out.println();
        System.out.print("Заповнюємо поле 'Логін' значенням '"+login+"' ... ");
        if (loginInput.getAttribute("value").equals(login)){
            System.out.println("OK.");
        }
        else {
            System.out.println("Failure!");
        }
//-----------------------------------------------------------------------------
        quickWaitForElementPresent(passwordInput);

        passwordInput.clear();
        passwordInput.sendKeys(password);
        System.out.println();
        System.out.print("Заповнюємо поле 'Пароль' значенням '"+password+"' ... ");
        if (passwordInput.getAttribute("value").equals(password)){
            passwordInput.sendKeys(Keys.ENTER);
            System.out.println("OK.");
        }
        else {
            System.out.println("Failure!");
        }
    }
//=============================================================================

}
