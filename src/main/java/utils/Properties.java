package utils;

import lombok.Getter;

import static utils.PropertiesLoader.getPropertiesInstance;

@Getter
public class Properties {

    static final String PROPERTIES_FILE = "/properties_DEV.properties";
    //static final String PROPERTIES_FILE = "/properties_UAT.properties";
    static final java.util.Properties PROPERTIES = getPropertiesInstance();
    //static String propertiesFilePath = System.getProperty("propertiesFilePath", "/properties_DEV.properties");
}
