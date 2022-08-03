package models.user;

import lombok.Getter;
import utils.PropertiesLoader;

public class UserValid extends User {

    public static final String VALID_USER = "validUser";
    @Getter
    private String userLogin;
    @Getter
    private String userPassword;

    public UserValid() {
        super(PropertiesLoader.loadUser(VALID_USER + "Login"), PropertiesLoader.loadUser(VALID_USER + "Password"));
        this.userLogin = PropertiesLoader.loadUser(VALID_USER + "Login");
        this.userPassword = PropertiesLoader.loadUser(VALID_USER + "Password");
    }
}
