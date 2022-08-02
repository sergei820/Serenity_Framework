package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Users {

    VALID_USER("validUser"),
    USER_WITH_WORNG_PASSWORD("userWithWrongPassword");

    private final String userName;
}
