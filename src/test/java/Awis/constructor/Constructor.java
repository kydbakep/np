package Awis.constructor;

import Awis.Conditions;
import Awis.Initializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * ! Created by tober on 01.02.17.
 */

public class Constructor extends Executor {

    private Initializer init = new Initializer(driver);

    void fillSenderInputs(WebDriver driver) {

        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
//======================================================================================================================
//                                        FILL SENDER INPUTS TEST
//======================================================================================================================
/*
* Логіка тесту:
1. Обираємо місто відправника через еластік;
2. Обираємо відправника за номером телефону;
3. Обираємо адресу відділення відправника;
*/
//----------------------------------------------------------------------------------------------------------------------
        System.err.println("Заповнюю поля відправника");
//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================
        init.getOpenCreateENpage().openCreateENPage();

        init.getSetCounterpartyCity().setCitySender("Київ", "м. Київ, Київська область");
        init.getSetCounterparties().setConterpartySender("0111111111");
        init.getSetAddress().setWareHouseAddressSender("1");

//----------------------------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("Завершую тест.");
    }
//----------------------------------------------------------------------------------------------------------------------
//                                                    END
//======================================================================================================================


    void fillRecipientInputs(WebDriver driver) {

        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
//======================================================================================================================
//                                        FILL RECIPIENT INPUTS TEST
//======================================================================================================================
/*
* Логіка тесту:
1. Обираємо місто отримувача через еластік;
2. Обираємо отримувача за номером телефону;
3. Обираємо адресу відділення отримувача;
*/
//----------------------------------------------------------------------------------------------------------------------
        System.err.println("Заповнюю поля отримувача");
//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================
        init.getOpenCreateENpage().openCreateENPage();

        init.getSetCounterpartyCity().setCityRecipient("Київ", "м. Київ, Київська область");
        init.getSetCounterparties().setCounterpartyRecipient("0111111111");
        init.getSetAddress().setWareHouseAddressRecipient("1");

//----------------------------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("Завершую тест.");
    }
//----------------------------------------------------------------------------------------------------------------------
//                                                    END
//======================================================================================================================


    void CreateENFast(WebDriver driver) throws Exception {

/*
Логіка тесту:
01. Обираємо місто відправника через еластік;
02. Обираємо відправника за номером телефону;
03. Обираємо адресу відділення відправника;
04. Обираємо місто отримувача через еластік;
05. Обираємо отримувача за номером телефону;
06. Обираємо адресу відділення отримувача;
07. Перевіряємо відповідність міст у заголовках;
08. Перевіряємо коректність побудови маршруту;
09. Обираємо платника;
10. Обираємо форму розрахунку;
11. Обираємо вид вантажу;
12. Присвоюємо номер ЕН;
13. Встановлюємо оголошену вартість;
14. Записуємо ЕН;
15. Записуємо номер ЕН до файлу.
*/

        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
//======================================================================================================================
//                                          CREATE AND WRITE EN (FAST)
//======================================================================================================================
//----------------------------------------------------------------------------------------------------------------------
        System.err.println("Створюємо ЕН (Швидко)");
//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================
        init.getOpenCreateENpage().openCreateENPage();

        init.getSetCounterparties().getStatusOfBoxes();

        init.getSetCounterpartyCity().setCitySender("Київ","м. Київ, Київська область");
        init.getSetCounterparties().setConterpartySender("0111111111");
        init.getSetAddress().setWareHouseAddressSender("1");

        init.getSetCounterpartyCity().setCityRecipient("Харків", "м. Харків, Харківська область");
        init.getSetCounterparties().setCounterpartyRecipient("0333333333");
        init.getSetAddress().setWareHouseAddressRecipient("2");

        init.getCheckTitles().checkCounterPartySenderBoxTitle();
        init.getCheckTitles().checkCounterPartyRecipientBoxTitle();
        init.getSetCounterpartyCity().RouteCheck();

        init.getSetDeliveryPayer().selectPayerFromDropDown("отримувач");
        init.getSetPaymantMethod().selectPaymantMethodFromDropdown("готівка");

        init.getSetCargoType().selectCargoType("документи");

        init.getSetNumber().setNumber();
        init.getSetCost().setCost("250");

        init.getWriteEN().writeEN();
        init.getWriteEN().writeENnumberToFile("numbers.txt");
//----------------------------------------------------------------------------------------------------------------------
        System.out.println();
        System.err.println("Завершую тест.");
        init.getWriteEN().readENnumberFromFile("numbers.txt");
//        init.getPlayer().play("good.mp3");
    }
//----------------------------------------------------------------------------------------------------------------------
//                                                    END
//======================================================================================================================


    public void CreateENFastWithBackwardDelivery(WebDriver driver) throws Exception {

/*
Логіка тесту:
01. Обираємо місто відправника через еластік;
02. Обираємо відправника за номером телефону;
03. Обираємо адресу відділення відправника;
04. Обираємо місто отримувача через еластік;
05. Обираємо отримувача за номером телефону;
06. Обираємо адресу відділення отримувача;
07. Перевіряємо відповідність міст у заголовках;
08. Перевіряємо коректність побудови маршруту;
09. Обираємо платника;
10. Обираємо форму розрахунку;
11. Обираємо вид вантажу;
12. Обираємо опцію "Зворотня доставка";
13. Обираємо платника зворотньої доставки;
14. Обираємо тип вантажу зворотньої доставки;
14. Присвоюємо номер ЕН;
15. Встановлюємо оголошену вартість;
16. Записуємо ЕН;
17. Записуємо номер ЕН до файлу.
*/

        Conditions.driver = driver;
        PageFactory.initElements(driver, this);
//======================================================================================================================
//                             CREATE AND WRITE EN (FAST) WITH BACKWARD DELIVERY
//======================================================================================================================
//----------------------------------------------------------------------------------------------------------------------
        System.err.println("Створюємо ЕН (Швидко) зі зворотньою доставкою");
//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================
        init.getOpenCreateENpage().openCreateENPage();

        init.getSetCounterparties().getStatusOfBoxes();

        init.getSetCounterpartyCity().setCitySender("Київ","м. Київ, Київська область");
        init.getSetCounterparties().setConterpartySender("0111111111");
        init.getSetAddress().setWareHouseAddressSender("1");

        init.getSetCounterpartyCity().setCityRecipient("Харків", "м. Харків, Харківська область");
        init.getSetCounterparties().setCounterpartyRecipient("0333333333");
        init.getSetAddress().setWareHouseAddressRecipient("2");

        init.getCheckTitles().checkCounterPartySenderBoxTitle();
        init.getCheckTitles().checkCounterPartyRecipientBoxTitle();
        init.getSetCounterpartyCity().RouteCheck();

        init.getSetDeliveryPayer().selectPayerFromDropDown("отримувач");
        init.getSetPaymantMethod().selectPaymantMethodFromDropdown("готівка");

        init.getSetCargoType().selectCargoType("Шини-диски");
        init.getSetCargoType().selectCargoType("Документи");

        init.getSetNumber().setNumber();
        init.getSetCost().setCost("25750");


        init.getSetBackwardDelivery().setBackwardDelivery("отримувач", "Інше");

        init.getWriteEN().writeEN();
        init.getWriteEN().writeENnumberToFile("numbers.txt");
//----------------------------------------------------------------------------------------------------------------------
        System.out.println();
        System.err.println("Завершую тест.");
        init.getWriteEN().readENnumberFromFile("numbers.txt");

//        driver.quit();

//        init.getPlayer().play("good.mp3");
    }
//----------------------------------------------------------------------------------------------------------------------
//                                                    END
//======================================================================================================================


    void CreateDispatcherRequest() throws Exception {
        PageFactory.initElements(driver, this);

//        init.takeFromEN().ENConstruct(driver);

        init.tms().openWorkplaceTMS();
        init.newRequest().createRequest();
//        init.takeFromEN().fillFieldsFromEN();

//        init.setCity().SetSenderCity("Варва", "смт. Варва, Чернігівська область, Варвинський р-н");

        init.setCity().SetSenderCity("Київ", "м. Київ, Київська область");
        init.setCounterParty().setSender("0111111111");
        init.setHomeAddress().setHomeAddressSender("м. Київ, вул. Велика Житомирська, 12");

        init.setCity().SetRecipientCity("Київ", "м. Київ, Київська область");
        init.setCounterParty().setRecipient("0333333333");
        init.setHomeAddress().setHomeAddressRecipient("м. Київ, вул. Велика Житомирська, 12");

//        init.information().setPaymentInfo("Відправник");
//        init.information().setPaymentInfo("Відправник","Готівка");
        init.information().setPaymentInfo("Третя особа", "Агротек ТОВ","Безготівковий");

        init.cargoPreferences().SetCargoType("Вантаж");
        init.cargoPreferences().SetSeatsAmount("1");
        init.cargoPreferences().SetWeight("1");
        init.cargoPreferences().SetVolumeWeight("20","20", "20");
        init.cargoPreferences().SetCost("1250");
        init.cargoPreferences().SetDescription("Трава з грибами");

        init.delivery().SetTypeAndDescription("Інше","Сало в шоколадному маслі","Отримувач");

        init.takeFromEN().remarksFill("Кохайтеся, чорнобриві, \n" +
                "Та не з москалями, \n" +
                "Бо москалі — чужі люде, \n" +
                "Роблять лихо з вами. \n" +
                "Москаль любить жартуючи, \n" +
                "Жартуючи кине; \n" +
                "Піде в свою Московщину, \n" +
                "А дівчина гине — \n" +
                "Якби сама, ще б нічого, \n" +
                "А то й стара мати, \n" +
                "Що привела на світ божий, \n" +
                "Мусить погибати.");

        justWait(1000);
        init.preferences().setInterval("9-21");
        System.out.println("1");
        justWait(1000);
        init.preferences().setInterval("9-18");
        System.out.println("2");
        justWait(1000);
        init.preferences().setInterval("9-17");
        System.out.println("3");
        justWait(1000);
        init.preferences().setInterval("without");
        System.out.println("4");
        justWait(1000);
        init.preferences().setInterval("18-21");
        System.out.println("5");
        justWait(1000);
        init.writeFence().writeRequest();
        init.preferences().getNumber();


//        justWait(5000);
//        driver.quit();
    }



//    void test(WebDriver driver) throws IOException {
//
//
//        URL url = new URL("http://wis14.np.ua/ULKTest/clients/extjs/index.php");
//        URLConnection con = url.openConnection();
//        InputStream in = con.getInputStream();
//        String encoding = con.getContentEncoding();
//        encoding = encoding == null ? "UTF-8" : encoding;
//        String body = IOUtils.toString(in, encoding);
//        System.out.println(body);
//    }


//    void test(WebDriver driver) throws IOException {
//
//
//        URL url = new URL("http://www.example.com/");
//        URLConnection con = url.openConnection();
//        InputStream in = con.getInputStream();
//        String encoding = con.getContentEncoding();
//        encoding = encoding == null ? "UTF-8" : encoding;
//        String body = IOUtils.toString(in, encoding);
//        System.out.println(body);
//    }


//    ======================================= ЗАГОТОВКИ
//            InitializeForms initialize = new InitializeForms(driver);
////        initialize.initializeForms();
//
//        setCounterpartyCity.setCitySender("Київ", "м. Київ, Київська область");
////        setCounterpartyCity.setCitySenderByButton("Запоріжжя", "Запорізька область");
////        setCounterpartyCity.setCitySenderByButton("Запоріжжя", "Запорізька");
////        justWait(5000);
////        setCounterpartyCity.changeCitySenderByButton("Харків");
////        justWait(5000);
////        setCounterpartyCity.changeCitySenderByInput("Харків", "м. Харків, Харківська область");
//
////        setCounterpartyCity.setCitySender("Одеса", "м. Одеса, Одеська область");
////        setCounterpartyCity.RouteCheck();
//
//        setCounterparties.setConterpartySender("0333333333");
////        setCounterparties.setConterpartySender("Приватна особа","0333333333");
////        setCounterparties.setConterpartySender("приватна особа", "+380505555555", "Фів Іван Іванович");
//
////
//        setAddress.setHomeAddressSender("м. Київ, вул. Велика Житомирська, 12");
//        checkTitles.checkCounterPartySenderBoxTitle();
//
//        setCounterpartyCity.changeCitySenderByButton("Харків");
//        setCounterparties.setConterpartySender("0333333333");
//        setAddress.setHomeAddressSender("м. Харків, просп. Гагаріна, 23");
//        checkTitles.checkCounterPartySenderBoxTitle();
////
//
//
////        setCounterpartyCity.setCityRecipient("Київ", "м. Київ, Київська область");
//        setCounterpartyCity.setCityRecipient("Дрогобич", "м. Дрогобич, Львівська область, Дрогобич");
////        justWait(5000);
//        setCounterpartyCity.RouteCheck();
////        setCounterpartyCity.changeCityRecipientByButton("Харків");
////        justWait(5000);
////        setCounterpartyCity.changeCityRecipientByInput("Київ", "м. Київ, Київська область");
//
//        setCounterparties.setCounterpartyRecipient("0111111111");
////        setCounterparties.setCounterpartyRecipient("організація","0666666666", "Мкмкем Абдельхак Абдельуахібович");
//
//        setAddress.setHomeAddressRecipient("м. Дрогобич, вул. Українки Лесі, 124");
//        checkTitles.checkCounterPartyRecipientBoxTitle();

//* 1. Обираємо місто відправника через еластік;
//* 2. Обираємо контрагента відправника (ввівши номер телефону в поле);
//* 3. Обираємо адресу відправника.
//* ОК! Форму відправника  заповнено!
//            * 4. Змінюємо місто відправника через форму пошуку. Тепер інші поля форми очищено
//* 5. Обираємо контрагента відправника;
//* 6. Обираємо адресу відправника.
//* 7. Перевіряємо, чи місто відправника в полі, відповідає місту відправника в тайтлі форми.

}