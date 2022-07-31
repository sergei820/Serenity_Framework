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
    private static final java.util.Properties PROFILE_PROPERTIES = getProfilePropertiesInstance();

    Properties properties = new Properties();
    InputStream input;

    {
        try {
            input = new FileInputStream(PROPERTIES_FILE);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String loadSystemPropertyOrDefault(String propertyName, String defaultValue) {
        String propValue = System.getProperty(propertyName);
        return propValue != null ? propValue : defaultValue;
    }

    public static String loadUser(String propertyName) {
        String value = null;
        if (!Strings.isNullOrEmpty(propertyName)) {
            String systemProperty = loadSystemPropertyOrDefault(propertyName, propertyName);
            if(!propertyName.equals(systemProperty)) return systemProperty;

            value = PROFILE_PROPERTIES.getProperty(propertyName);
            if (null == value) {
                value = PROPERTIES.getProperty(propertyName);
            }
        }
        return value;
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

    @SneakyThrows
    private static java.util.Properties getProfilePropertiesInstance() {
        java.util.Properties instance = new java.util.Properties();
        String profile = System.getProperty("profile", "");
        if (!Strings.isNullOrEmpty(profile)) {
            String path = Paths.get(profile).toString();
            URL url = PropertiesLoader.class.getClassLoader().getResource(path);
            try (
                    InputStream resourceStream = url.openStream();
                    InputStreamReader inputStream = new InputStreamReader(resourceStream, Charset.forName("UTF-8"))
            ) {
                instance.load(inputStream);
            }
        }
        return instance;
    }
}
