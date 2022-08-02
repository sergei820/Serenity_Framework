package models.userManager;

import core.enums.UserType;
import lombok.extern.slf4j.Slf4j;
import models.user.User;
import models.user.UserUnknown;
import models.user.UserValid;
import models.user.UserWithWrongPassword;

@Slf4j
public class UserUnknownManager implements UserManager {

    public User createUser() {
        log.info("Loading credentials for user to log in");
        return new UserUnknown();
    }
}
