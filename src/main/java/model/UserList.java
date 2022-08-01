package model;

public enum UserList {

    VALID_USER("validUser"),
    USER_WITH_WORNG_PASSWORD("userWithWrongPassword");

    UserList(String userName) {
        this.userName = userName;
    }

    private final String userName;

    public String getValue() {
        return userName;
    }
}
