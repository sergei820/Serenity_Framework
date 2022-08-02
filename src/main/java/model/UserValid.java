package model;

import lombok.Getter;
import utils.PropertiesLoader;

import static org.apache.commons.lang3.SystemUtils.getUserName;

public class UserValid implements User {

    public static final String VALID_USER = "validUser";
    @Getter
    public String userLogin;
    @Getter
    public String userPassword;

    public UserValid() {
        this.userLogin = PropertiesLoader.loadUser(VALID_USER + "Login");
        this.userPassword = PropertiesLoader.loadUser(VALID_USER + "Password");
    }
}
