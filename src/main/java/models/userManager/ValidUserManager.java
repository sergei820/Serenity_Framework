package models.userManager;

import lombok.extern.slf4j.Slf4j;
import models.user.User;
import models.user.UserValid;

@Slf4j
public class ValidUserManager implements UserManager {

    public User createUser() {
        return new UserValid();
    }
}
