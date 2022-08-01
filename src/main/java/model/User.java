package model;

import lombok.Getter;

public class User {

    @Getter
    private String userName;
    @Getter
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
