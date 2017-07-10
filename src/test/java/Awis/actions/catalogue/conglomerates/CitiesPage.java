package Awis.actions.catalogue.conglomerates;

import ClearTest.Conditions;
import ClearTest.Initializer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ! Created by tober on 17.02.17.
 */

public class CitiesPage extends Conditions{
    private Initializer init = new Initializer(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 10);

    public CitiesPage(WebDriver driver){
        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
    }

//----------------------------------------------------------------------------------------------------------------------

    public void waitForCity(String name) throws Exception {
        System.out.println();
        waitForTextPresent(driver.findElement(By.xpath(".//td[div='"+name+"']")));
//        wait.until(ExpectedConditions.textToBe((By.xpath(".//td[div='"+name+"']")),name));
        System.out.println("Дочекались в таблиці місто: "+ driver.findElement(By.xpath(".//td[div='"+name+"']")).getText());
    }

    public void setCity(String cityName) throws Exception {

        waitForElementPresent(citiesTab);
        waitForElementPresent(filterCleaner);
        filterCleaner.click();
        wait.until(ExpectedConditions.elementToBeClickable(filterInput));

        filterInput.sendKeys(cityName + Keys.TAB);
        System.out.println();
        System.out.println("Застосували фільтр");
        wait.until(ExpectedConditions.attributeToBe(filterInput,"value", cityName));
        System.out.println("Переконались що фільтр заповнено вірно");

        System.out.println();
        System.out.println("Очікуємо текст в таблиці");

        for (int i = 0; i < 100; i++) {
            justWait(250);
            if (driver.findElement(By.xpath("(.//tr[td='"+cityName+"']/td[4])[last()]")).getText().equals(cityName)){
                break;
            }
            else {
                justWait(250);
                System.out.println("Очікую текст...");
            }
        }
        System.out.println("TEXT IS: "+driver.findElement(By.xpath(".//tr[td='"+cityName+"']/td[4]")).getText());
        init.getAct().moveToElement(driver.findElement(By.xpath(".//tr[td='"+cityName+"']"))).click().perform();
        waitForElementPresent(selectButton);
        System.out.println();
        System.out.println("Клікаємо 'Обрати'");
        selectButton.click();
    }

    public void removeCity(String cityName) throws Exception {
        System.out.println();
        System.out.println("Очікуємо таблицю міст");
        quickWaitForElementPresent(citiesTable);

        System.out.println();
        System.out.println("Місто в таблиці присутнє: "+driver.findElement(By.xpath(".//td[div='"+cityName+"']")).getText());
        System.out.println("Виділяємо місто в таблиці");
        init.getAct().moveToElement(driver.findElement(By.xpath(".//td[div='"+cityName+"']"))).click().perform();

        System.out.println("Тиснемо кнопку 'Вилучити'");
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        removeButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//td[div='"+cityName+"']")));
    }

//----------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = ".//button[span='Міста']")
    private WebElement citiesTab;

    @FindBy(xpath = "(.//button[span='Обрати'])[last()]")
    private WebElement selectButton;

    @FindBy(xpath = "(.//div[label='Фільтр:']//input)[last()]")
    private WebElement filterInput;

    @FindBy(xpath = "(.//div[label='Фільтр:']//div[contains(@id,'FilterField-triggerWrap')]/div[@role='button'])[last()]")
    private WebElement filterCleaner;

    @FindBy(xpath = ".//button[span='Вилучити']")
    private WebElement removeButton;

    @FindBy(xpath = ".//div[contains(@id,'Settlements-body')]/div[contains(@id,'gridview')]/table/tbody")
    private WebElement citiesTable;

    @FindBy(xpath = "")
    private WebElement g;

    @FindBy(xpath = "")
    private WebElement h;

    @FindBy(xpath = "")
    private WebElement i;

    @FindBy(xpath = "")
    private WebElement j;

    @FindBy(xpath = "")
    private WebElement k;
}
