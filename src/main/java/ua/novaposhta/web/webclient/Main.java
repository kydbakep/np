package ua.novaposhta.web.webclient;


import java.io.*;
import java.util.Properties;

/**
 * Created by tober on 13.07.17.
 * test
 */
public class Main {

    private static Properties property = new Properties();

    public static void main(String[] args) {
        getProperties("awis");
        getProperties("web");
        getProperties("api");
    }

    private static void getProperties(String claster) {
        FileInputStream fis;
        String url;
        String login;
        String password;
        String ref;

        System.out.println("**********************");

        try {
            fis = new FileInputStream("./src/test/resources/config.properties");
            property.load(fis);
        } catch (IOException ex) {
            System.err.println("No config file present!");
        }

        if (claster.equals("web")) {
            url = property.getProperty("webClient.url");
            login = property.getProperty("webClient.loyalUserName");
            password = property.getProperty("webClient.loyalUserPassword");

            System.out.println("URL: " + url + "\nLOGIN: " + login + "\nPASSWORD: " + password);
        }

        if (claster.equals("awis")) {
                url = property.getProperty("awis.url");
                login = property.getProperty("awis.login");
                password = property.getProperty("awis.password");

                System.out.println("URL: " + url + "\nLOGIN: " + login + "\nPASSWORD: " + password);
        }
        if (claster.equals("api")) {
                url = property.getProperty("api.url");
                login = property.getProperty("api.login");
                ref = property.getProperty("api.ref");

                System.out.println("URL: " + url + "\nLOGIN: " + login + "\nREF: " + ref);
        }
    }
}
