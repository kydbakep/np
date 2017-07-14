package ua.novaposhta.web.webclient;


import java.io.*;
import java.util.Properties;

/**
 * Created by tober on 13.07.17.
 * test
 */
public class Main {
    public static void main(String[] args) {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("./src/main/resources/config.properties");
            property.load(fis);
            String host = property.getProperty("webClient.host");
            String login = property.getProperty("webClient.loyalUserName");
            String password = property.getProperty("webClient.loyalUserPassword");

            System.out.println("HOST: " + host + "\nLOGIN: " + login + "\nPASSWORD: " + password);

        } catch (IOException ex) {
            System.err.println("No config file present!");
        }
    }
}
