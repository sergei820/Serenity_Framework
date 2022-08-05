package models.user;

import lombok.Getter;
import utils.PropertiesLoader;

@Getter
public class UserValid extends User {

    public static final String VALID_USER = "validUser";
    private String userLogin;
    private String userPassword;

    public UserValid() {
        super(PropertiesLoader.loadUser(VALID_USER + "Login"), PropertiesLoader.loadUser(VALID_USER + "Password"));
        this.userLogin = PropertiesLoader.loadUser(VALID_USER + "Login");
        this.userPassword = PropertiesLoader.loadUser(VALID_USER + "Password");
    }
}
