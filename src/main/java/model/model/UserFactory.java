package model.model;

public class UserFactory {

    public static User createValidUser() {
        return new User("standard_user", "secret_sauce");
    }

    public static User createUserWithoutUserName() {
        return new User(null, "secret_sauce");
    }

    public static User getNullUserObject() {
        return null;
    }
}
