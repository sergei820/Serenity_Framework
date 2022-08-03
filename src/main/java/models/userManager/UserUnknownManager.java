package models.userManager;

import lombok.extern.slf4j.Slf4j;
import models.user.User;
import models.user.UserUnknown;

@Slf4j
public class UserUnknownManager implements UserManager {

    public User createUser() {
        log.info("Loading credentials for user to log in");
        return new UserUnknown();
    }
}
