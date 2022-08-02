package model;

import lombok.Getter;
import utils.PropertiesLoader;

public class UserUnknown implements User {

    public static final String USER_UNKNOWN = "user unknown!";
    @Getter
    public String userLogin;
    @Getter
    public String userPassword;

    public UserUnknown() {
        this.userLogin = null;
        this.userPassword = null;
    }
}
