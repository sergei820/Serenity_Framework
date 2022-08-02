package models.user;

import lombok.Getter;
import utils.PropertiesLoader;

public class UserWithWrongPassword extends User {

    public static final String USER_WITH_WORNG_PASSWORD = "userWithWrongPassword";
    @Getter
    private String userLogin;
    @Getter
    private String userPassword;

    public UserWithWrongPassword() {
        super(PropertiesLoader.loadUser(USER_WITH_WORNG_PASSWORD + "Login"), PropertiesLoader.loadUser(USER_WITH_WORNG_PASSWORD + "Password"));
        this.userLogin = PropertiesLoader.loadUser(USER_WITH_WORNG_PASSWORD + "Login");
        this.userPassword = PropertiesLoader.loadUser(USER_WITH_WORNG_PASSWORD + "Password");
    }
}
