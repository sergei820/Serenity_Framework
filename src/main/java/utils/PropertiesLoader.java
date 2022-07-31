package utils;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import static utils.Properties.PROPERTIES;
import static utils.Properties.PROPERTIES_FILE;

public class PropertiesLoader {

    InputStream input;

    {
        try {
            input = new FileInputStream(PROPERTIES_FILE);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String loadUser(String propertyName) {
        return PROPERTIES.getProperty(propertyName);
    }

    @SneakyThrows
    static java.util.Properties getPropertiesInstance() {
        java.util.Properties instance = new java.util.Properties();
        try (
                InputStream resourceStream = PropertiesLoader.class.getResourceAsStream(PROPERTIES_FILE);
                InputStreamReader inputStream = new InputStreamReader(resourceStream, Charset.forName("UTF-8"))
        ) {
            instance.load(inputStream);
        }
        return instance;
    }
}
