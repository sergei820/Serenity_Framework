package models.user;

import lombok.Getter;

@Getter
public class UserUnknown extends User {

    public static final String USER_UNKNOWN = "user unknown!";
    private String userLogin;
    private String userPassword;

    public UserUnknown() {
        super(null, null);
    }
}
