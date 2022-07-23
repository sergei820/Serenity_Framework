package net.serenitybdd.starter.fetests.testCases;

import org.junit.Test;

import static net.serenitybdd.starter.model.User.getNullUserObject;

public class NullPointerTest extends BaseTest {

    @Test
    public void checkPrices() {
        startApp();
        logIn(getNullUserObject());
        stopApp();
    }
}
