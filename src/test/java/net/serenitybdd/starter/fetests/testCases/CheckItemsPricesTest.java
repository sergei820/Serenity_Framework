package net.serenitybdd.starter.fetests.testCases;

import net.serenitybdd.starter.annotations.UITest;
import org.junit.Test;

import static net.serenitybdd.starter.fetests.pageObjects.BasePage.SAUCE_LABS_BACKPACK;
import static net.serenitybdd.starter.model.UserFactory.createValidUser;

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
