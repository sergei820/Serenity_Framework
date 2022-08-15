package models.user;

import lombok.Getter;
import utils.PropertiesLoader;

@Getter
public class UserValid extends User {

    public static final String VALID_USER = "validUser";
    private String userLogin;
    private String userPassword;

    public UserValid() {
        super(PropertiesLoader.loadProperty(VALID_USER + "Login"), PropertiesLoader.loadProperty(VALID_USER + "Password"));
        this.userLogin = PropertiesLoader.loadProperty(VALID_USER + "Login");
        this.userPassword = PropertiesLoader.loadProperty(VALID_USER + "Password");
    }
}
