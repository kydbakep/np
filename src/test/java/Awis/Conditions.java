package Awis;

import net.lightbody.bmp.BrowserMobProxyServer;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/**
 *  Created by tober on 29.01.17.
 */

public class Conditions {

    public static WebDriver driver;
    public static BrowserMobProxyServer server;
    public Proxy seleniumProxy;

    public void waitForJStoLoad(String event) {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<String> jQueryLoad = new ExpectedCondition<String>() {

            @Override
            public String apply(WebDriver driver) {

                String tmp = (String)((JavascriptExecutor) driver).executeScript("Ext.Ajax.on('requestcomplete', function(conn, req, opts){console.log(opts.params.event);  return opts.params.event;});").toString();

                System.out.println("!!!!!!!!!!!!" + tmp);
                return tmp;
            }
        };
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.getAttribute("class");
            return true;
        } catch (ElementNotVisibleException notVisible) {
            System.out.println();
            System.out.print("Element is not visible: " + element);
            return false;
        } catch (NoSuchElementException noSuchElement) {
            System.out.println();
            System.out.print("No such element. Waiting for: " + element);
            return false;
        }
    }

    public void justWait(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception ignored) {
        }
    }

    public void waitForElementPresent(WebElement element) {
        justWait(250);
        for (int i = 0; i < 50; i++) {
            try {
                if (isElementPresent(element)) {
                    System.out.println();
                    if (element.isDisplayed()) {
                        System.out.println();
                        System.out.print("Waiting DONE! Element is here! " + element);
                        break;
                    } else System.out.print("Waiting for: " + element + "...");
                }
                Thread.sleep(200);
            } catch (InterruptedException except) {
                System.out.println();
                System.out.println("Element " + element);
                System.out.println("WAITING FAILED!");
            }
        }
    }

    public void quickWaitForElementPresent(WebElement element) {
        justWait(250);
        for (int i = 0; i < 5; i++) {
            try {
                if (isElementPresent(element)) {
                    System.out.println();
                    if (element.isDisplayed()) {
                        System.out.println();
                        System.out.print("Quick waiting DONE! Element is here! " + element);
                        break;
                    } else System.out.print("Quick waiting for: " + element + "...");
                }
                Thread.sleep(100);
            } catch (InterruptedException except) {
                System.out.println();
                System.out.println("Element " + element);
                System.out.println("QUICK WAITING FAILED!");
            }
        }
    }

    public void waitForElementNotPresent(WebElement element) {
        for (int i = 0; i < 50; i++) {
            try {
                if (!(isElementPresent(element))) {
                    System.out.println();
                    System.out.println("ОК. Дочекались поки зникне " + element);
                    break;
                }
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("Очікуємо ЗНИКНЕННЯ елементу: " + element);
            }
        }
    }

    public void alertHandler(){
        try {
            new WebDriverWait(driver, 1).until(ExpectedConditions.alertIsPresent());
            Alert alert;
            alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            System.out.println("Alert ACCEPT");
            alert.accept();
        } catch (TimeoutException ignored) {
        }
    }

    public void waitForTextPresent(final WebElement element) throws Exception {
        new WebDriverWait(driver, 5).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver drv) {
                boolean result = false;
                int attempts = 0;
                while (attempts < 5) {
                    try {
                        element.getText().length();
                        if (element.getText().length() != 0) {
                            result = true;
                            break;
                        }
                    } catch (StaleElementReferenceException e) {
                    }
                    attempts++;
                }
                return result;
            }
        });
    }

    public void waitForAttributeText(final WebElement element, final String attribute, final String text) throws Exception {
        new WebDriverWait(driver, 5).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver drv) {
                boolean result = false;
                int attempts = 0;
                while (attempts < 5) {
                    try {
                        element.getAttribute(attribute);
                        if (element.getAttribute(attribute).equals(text)) {
                            result = true;
                            break;
                        }
                    } catch (StaleElementReferenceException e) {
                    }
                    attempts++;
                }
                return result;
            }
        });
    }
}

//wait.until(ExpectedConditions.textToBePresentInElement(addressInCellTwo, address));