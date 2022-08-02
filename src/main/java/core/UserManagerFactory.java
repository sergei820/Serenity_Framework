package core;

import core.enums.UserType;
import lombok.extern.slf4j.Slf4j;
import models.user.User;
import models.user.UserUnknown;
import models.user.UserValid;
import models.user.UserWithWrongPassword;
import models.userManager.UserManager;
import models.userManager.UserUnknownManager;
import models.userManager.UserWithWrongPasswordManager;
import models.userManager.ValidUserManager;

import static models.user.UserValid.VALID_USER;
import static models.user.UserWithWrongPassword.USER_WITH_WORNG_PASSWORD;

@Slf4j
public class UserManagerFactory {

    public static UserManager getUserManager(UserType userType) {
        UserManager userManager;
        switch (userType) {
            case VALID_USER -> {userManager = new ValidUserManager();}
            case USER_WITH_WORNG_PASSWORD -> {userManager = new UserWithWrongPasswordManager();}
            default -> {userManager = new UserUnknownManager();}
        }
        return userManager;
    }
}
