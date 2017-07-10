package Awis.actions.createEN;

import Awis.Conditions;
import Awis.Initializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ! Created by tober on 06.02.17.
 */

public class WriteENButton extends Conditions {

    Initializer init = new Initializer(driver);

    public WriteENButton(WebDriver driver) {
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void writeEN() {
        System.out.println();
        System.out.println("ЗАПИСУЮ ЕН");
        waitForElementPresent(writeENButton);

        if (createENTabNonSet.isDisplayed()) {

            init.clickJS(writeENButton);
//            writeENButton.click();
//            alertHandler();


        } else {
            System.err.println("ЕН вже записано!");
        }
        waitForElementPresent(createENTabIsSet);
        System.err.println(driver.findElement(By.xpath("//div[contains(@id, 'tab') and contains(@class, 'active')]/a[@title='Close Tab']/..//span[1]")).getText());
    }

    public void writeENnumberToFile(String filename) throws Exception {

        // true - дописувати, false - перезаписувати
        try (FileWriter writer = new FileWriter("/home/tober/Projects/WebDriver/src/test/java/ClearTest/" + filename, true)) {

            waitForElementPresent(createENTabIsSet);
            System.out.println();
            System.out.println("Записую у файл: /home/tober/Projects/WebDriver/src/test/java/ClearTest/" + filename);
            System.out.println();

            String text = (driver.findElement(By.xpath("//div[contains(@id, 'tab') and contains(@class, 'active')]/a[@title='Close Tab']/..//span[1]")).getText());
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.flush();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public String readENnumberFromFile(String filename) {
        //...checks on filename are elided
        StringBuilder contents = new StringBuilder();
        try {
            //use buffering, reading one line at a time
            //FileReader always assumes default encoding is OK!
            BufferedReader input = new BufferedReader(new FileReader("/home/tober/Projects/WebDriver/src/test/java/ClearTest/" + filename));
            try {
                String line = null; //not declared within while loop
        /*
        * readLine is a bit quirky :
        * it returns the content of a line MINUS the newline.
        * it returns null only for the END of the stream.
        * it returns an empty String if two newlines appear in a row.
        */
                while ((line = input.readLine()) != null) {
                    contents.append(line);
                    contents.append(System.getProperty("line.separator"));
                    System.out.println(line.split(" ")[1]);
                }
            } finally {
                input.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return contents.toString();
    }

    @FindBy(xpath = "//span[.='Записати']/..")
    private WebElement writeENButton;

    @FindBy(xpath = "//div[contains(@id, 'tab') and contains(@class, 'active')]//span [contains(., 'ЕН: нова')]")
    private WebElement createENTabNonSet;

    @FindBy(xpath = "//div[contains(@id, 'tab') and contains(@class, 'active')]//span [contains(., 'від')]")
    private WebElement createENTabIsSet;
}









