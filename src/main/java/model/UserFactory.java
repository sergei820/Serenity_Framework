package model;

import lombok.extern.slf4j.Slf4j;

import static model.UserValid.VALID_USER;
import static model.UserWithWrongPassword.USER_WITH_WORNG_PASSWORD;

@Slf4j
public class UserFactory {

    public static User createUser(String userType) {
        User newUser;
        log.info("Loading credentials for user to log in");
        switch (userType) {
            case(VALID_USER) -> {newUser = new UserValid();}
            case(USER_WITH_WORNG_PASSWORD) -> {newUser = new UserWithWrongPassword();}
            default -> newUser = new UserUnknown();
        }
        return newUser;
    }
}
