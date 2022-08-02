package models;

import lombok.Getter;
import utils.PropertiesLoader;

public class UserWithWrongPassword implements User {

    public static final String USER_WITH_WORNG_PASSWORD = "userWithWrongPassword";
    @Getter
    public String userLogin;
    @Getter
    public String userPassword;

    public UserWithWrongPassword() {
        this.userLogin = PropertiesLoader.loadUser(USER_WITH_WORNG_PASSWORD + "Login");
        this.userPassword = PropertiesLoader.loadUser(USER_WITH_WORNG_PASSWORD + "Password");
    }
}
