package core.enums;

public enum UserType {
    VALID_USER("validUser"),
    USER_WITH_WORNG_PASSWORD("userWithWrongPassword"),
    USER_UNKNOWN("user unknown!");

    String userType;

    UserType(String userType) {
        this.userType = userType;
    }
}
