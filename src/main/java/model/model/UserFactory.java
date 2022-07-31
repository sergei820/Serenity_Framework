package model.model;

import utils.Properties;
import utils.PropertiesLoader;

public class UserFactory {

    //public static User createValidUser() {
    //    return new User("standard_user","standard_user");
    //}

    public static User createValidUser(UserList user) {
        return new User(PropertiesLoader.loadUser(user.getValue() + "Login"), PropertiesLoader.loadUser(user.getValue() + "Password"));
    }

    public static User createUserWithoutUserName() {
        return new User(null, "secret_sauce");
    }

    public static User getNullUserObject() {
        return null;
    }
}
