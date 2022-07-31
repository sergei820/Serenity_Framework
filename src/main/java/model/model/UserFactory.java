package model.model;

import utils.Properties;
import utils.PropertiesLoader;

public class UserFactory {

    static Properties properties;

    public static User createValidUser() {
        return new User("standard_user","standard_user");
    }

    public static User createValidUserFromPropertiesFile() {
        return new User(PropertiesLoader.loadUser("validUserLogin"), PropertiesLoader.loadUser("validUserPassword"));
    }

    public static User createUserWithoutUserName() {
        return new User(null, "secret_sauce");
    }

    public static User getNullUserObject() {
        return null;
    }
}
