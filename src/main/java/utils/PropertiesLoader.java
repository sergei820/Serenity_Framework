package utils;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import static utils.Properties.PROPERTIES;
//import static utils.Properties.propertiesFilePath;
import static utils.Properties.PROPERTIES_FILE;

public class PropertiesLoader {

    public static String loadUser(String propertyName) {
        return PROPERTIES.getProperty(propertyName);
    }

    @SneakyThrows
    static java.util.Properties getPropertiesInstance() {
        java.util.Properties instance = new java.util.Properties();
        try (
                InputStream resourceStream = PropertiesLoader.class.getResourceAsStream(PROPERTIES_FILE);
                //InputStream resourceStream = PropertiesLoader.class.getResourceAsStream(propertiesFilePath);
                InputStreamReader inputStream = new InputStreamReader(resourceStream, Charset.forName("UTF-8"))
        ) {
            instance.load(inputStream);
        }
        return instance;
    }
}
