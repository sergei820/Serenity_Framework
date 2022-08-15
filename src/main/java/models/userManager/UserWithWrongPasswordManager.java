package models.userManager;

import lombok.extern.slf4j.Slf4j;
import models.user.User;
import models.user.UserWithWrongPassword;

@Slf4j
public class UserWithWrongPasswordManager implements UserManager{

    public User createUser() {
        return new UserWithWrongPassword();
    }
}
