package utils;

import static utils.PropertiesLoader.getPropertiesInstance;

public class Properties {

    static final String PROPERTIES_FILE = "/properties_DEV.properties";
    static final java.util.Properties PROPERTIES = getPropertiesInstance();

    private String property;

    public String getProperty() {
        return property;
    }
}
