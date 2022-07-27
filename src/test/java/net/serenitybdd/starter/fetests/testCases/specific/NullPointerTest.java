package net.serenitybdd.starter.fetests.testCases.specific;

import net.serenitybdd.starter.fetests.testCases.BaseTest;
import org.testng.annotations.Test;

import static net.serenitybdd.starter.model.User.getNullUserObject;

public class NullPointerTest extends BaseTest {

    @Test
    public void checkPrices() {
        startApp();
        logIn(getNullUserObject());
        stopApp();
    }
}
