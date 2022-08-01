package model;

import lombok.extern.slf4j.Slf4j;
import utils.PropertiesLoader;

@Slf4j
public class UserFactory {

    //public static User createValidUser() {
    //    return new User("standard_user","standard_user");
    //}

    public static User createValidUser(UserList user) {
        log.info("Loading credentials for user to log in");
        return new User(PropertiesLoader.loadUser(user.getValue() + "Login"), PropertiesLoader.loadUser(user.getValue() + "Password"));
    }

    public static User createUserWithoutUserName() {
        return new User(null, "secret_sauce");
    }

    public static User getNullUserObject() {
        return null;
    }
}
