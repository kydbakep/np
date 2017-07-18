package Testing;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Testing {
    public Testing(){}

    @Test
    public void testParams(){
        Properties property = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream("./src/test/resources/testing.properties");
            property.load(fis);
        } catch (IOException ex) {
            System.err.println("No config file present!");
        }

        System.out.println(property.getProperty("test.param"));
    }
}
