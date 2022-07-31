package utils;

import com.google.common.base.Strings;
import lombok.SneakyThrows;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Paths;

public class PropertiesLoader {

    private static final String PROPERTIES_FILE = "/properties.properties";
    private static final java.util.Properties PROPERTIES = getPropertiesInstance();

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
    private static java.util.Properties getPropertiesInstance() {
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
