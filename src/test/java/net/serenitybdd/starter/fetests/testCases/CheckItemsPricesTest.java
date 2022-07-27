package net.serenitybdd.starter.fetests.testCases;

import net.serenitybdd.starter.annotations.UITest;
import org.testng.annotations.Test;

import static net.serenitybdd.starter.fetests.pageObjects.BasePage.SAUCE_LABS_BACKPACK;
import static net.serenitybdd.starter.model.User.createValidUser;

public class CheckItemsPricesTest extends BaseTest {

    @UITest
    @Test
    public void checkPrices() {
        startApp();
        logIn(createValidUser());
        basePageSteps.checkItemPrice(SAUCE_LABS_BACKPACK);
        stopApp();
    }
}
