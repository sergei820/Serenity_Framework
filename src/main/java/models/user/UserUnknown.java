package models.user;

import lombok.Getter;

public class UserUnknown extends User {

    public static final String USER_UNKNOWN = "user unknown!";
    @Getter
    private String userLogin;
    @Getter
    private String userPassword;

    public UserUnknown() {
        super(null, null);
    }
}
