package Awis.constructor;

import Awis.Conditions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 *! Created by tober on 30.01.17.
 */

public class Executor extends Conditions {


    private int CountOfTestRuns = 1;
    private int tries = 0;
    private double allTime = 0.0;

    @Before

    public void BeforeTest(){

//        server = new BrowserMobProxyServer();
//        server.start();
//        int port = server.getPort();
//        Proxy proxy = ClientUtil.createSeleniumProxy(server);
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(CapabilityType.PROXY, proxy);

//        driver = new ChromeDriver(capabilities);

//        File file = new File("/usr/bin/chromedriver");
//        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(250, TimeUnit.MILLISECONDS);
    }

//    @Test
    public void FillSenderInputs() throws Exception {

        for (int i = 0; i<CountOfTestRuns; i++) {

            Constructor constructor = new Constructor();

            System.out.println();
            System.out.println("***");
            System.out.println("СПРОБА: " + (i + 1));
            System.out.println("***");
            System.out.println();

            double start = System.currentTimeMillis();

            constructor.fillSenderInputs(driver);

            double work = System.currentTimeMillis();

            double time = work - start;
            tries++;
            allTime += time;
            System.out.println();
            System.out.println("Час виконання тесту: " + time / 1000 + " секунд.");
            System.out.println();

            if ((allTime / 1000 >= 60) && (tries >= 2)) {
                String average = String.format("%.2f", allTime / 1000 / 60);
                System.out.println("Час виконання усіх " + tries + " спроб: " + average + " хвилин.");
                System.out.println();
                String avg = String.format("%.2f", (allTime / 1000) / tries);
                System.out.println("Середній час виконання тестів: " + avg + " секунд.");
            }

            if ((allTime / 1000 < 60) && (tries >= 2)) {
                String average = String.format("%.2f", allTime / 1000);
                System.out.println("Час виконання усіх " + tries + " спроб: " + average + " секунд.");
                System.out.println();
                String avg = String.format("%.2f", (allTime / 1000) / tries);
                System.out.println("Середній час виконання тестів: " + avg + " секунд.");
            }

            if (tries < 2) {
                System.out.println();
                System.out.println("Виконано " + tries + " спробу. ");
            } else {
                System.out.println();
                System.out.println("Виконано " + tries + " спроб.");
            }
        }
    }

//    @Test
    public void FillRecipientInputs() throws Exception {

        for (int i = 0; i<CountOfTestRuns; i++) {

            Constructor constructor = new Constructor();

            System.out.println();
            System.out.println("***");
            System.out.println("СПРОБА: " + (i + 1));
            System.out.println("***");
            System.out.println();

            double start = System.currentTimeMillis();

            constructor.fillRecipientInputs(driver);

            double work = System.currentTimeMillis();

            double time = work - start;
            tries++;
            allTime += time;
            System.out.println();
            System.out.println("Час виконання тесту: " + time / 1000 + " секунд.");
            System.out.println();

            if ((allTime / 1000 >= 60) && (tries >= 2)) {
                String average = String.format("%.2f", allTime / 1000 / 60);
                System.out.println("Час виконання усіх " + tries + " спроб: " + average + " хвилин.");
                System.out.println();
                String avg = String.format("%.2f", (allTime / 1000) / tries);
                System.out.println("Середній час виконання тестів: " + avg + " секунд. ");
            }

            if ((allTime / 1000 < 60) && (tries >= 2)) {
                String average = String.format("%.2f", allTime / 1000);
                System.out.println("Час виконання усіх " + tries + " спроб: " + average + " секунд.");
                System.out.println();
                String avg = String.format("%.2f", (allTime / 1000) / tries);
                System.out.println("Середній час виконання тестів: " + avg + " секунд. ");
            }

            if (tries < 2) {
                System.out.println();
                System.out.println("Виконано " + tries + " спробу. ");
            } else {
                System.out.println();
                System.out.println("Виконано " + tries + " спроб. ");
            }
        }
    }

//    @Test
    public void CreateENFast() throws Exception {

        for (int i = 0; i<CountOfTestRuns; i++) {

            Constructor constructor = new Constructor();

            System.out.println();
            System.out.println("***");
            System.out.println("СПРОБА: " + (i + 1));
            System.out.println("***");
            System.out.println();

            double start = System.currentTimeMillis();

            constructor.CreateENFast(driver);
//            constructor.CreateENFastWithBackwardDelivery(driver);

            double work = System.currentTimeMillis();

            double time = work - start;
            tries++;
            allTime += time;
            System.out.println();
            System.out.println("Час виконання тесту: " + time / 1000 + " секунд.");
            System.out.println();

            if ((allTime / 1000 >= 60) && (tries >= 2)) {
                String average = String.format("%.2f", allTime / 1000 / 60);
                System.out.println("Час виконання всіх " + tries + " спроб: " + average + " хвилин.");
                System.out.println();
                String avg = String.format("%.2f", (allTime / 1000) / tries);
                System.out.println("Середній час виконання тестів: " + avg + " секунд.");
            }

            if ((allTime / 1000 < 60) && (tries >= 2)) {
                String average = String.format("%.2f", allTime / 1000);
                System.out.println("Час виконання всіх " + tries + " спроб: " + average + " секунд.");
                System.out.println();
                String avg = String.format("%.2f", (allTime / 1000) / tries);
                System.out.println("Середній час виконання тестів: " + avg + " секунд.");
            }

            if (tries < 2) {
                System.out.println();
                System.out.println("Виконано " + tries + " спробу.");
            } else {
                System.out.println();
                System.out.println("Виконано " + tries + " спроб.");
            }
        }
    }

    @Test
    public void CreateRequest() throws Exception {

        for (int i = 0; i<CountOfTestRuns; i++) {

            Constructor constructor = new Constructor();

            System.out.println();
            System.out.println("***");
            System.out.println("СПРОБА: " + (i + 1));
            System.out.println("***");
            System.out.println();

            double start = System.currentTimeMillis();

            constructor.CreateDispatcherRequest();

            double work = System.currentTimeMillis();

            double time = work - start;
            tries++;
            allTime += time;
            System.out.println();
            System.out.println("Час виконання тесту: " + time / 1000 + " секунд.");
            System.out.println();

            if ((allTime / 1000 >= 60) && (tries >= 2)) {
                String average = String.format("%.2f", allTime / 1000 / 60);
                System.out.println("Час виконання всіх " + tries + " спроб: " + average + " хвилин. ");
                System.out.println();
                String avg = String.format("%.2f", (allTime / 1000) / tries);
                System.out.println("Середній час виконання тестів: " + avg + " секунд.");
            }

            if ((allTime / 1000 < 60) && (tries >= 2)) {
                String average = String.format("%.2f", allTime / 1000);
                System.out.println("Час виконання всіх " + tries + " спроб: " + average + " секунд. ");
                System.out.println();
                String avg = String.format("%.2f", (allTime / 1000) / tries);
                System.out.println("Середній час виконання тестів: " + avg + " секунд.");
            }

            if (tries < 2) {
                System.out.println();
                System.out.println(" Виконано " + tries + " спробу.");
            } else {
                System.out.println();
                System.out.println(" Виконано " + tries + " спроб.");
            }
        }
    }
}
