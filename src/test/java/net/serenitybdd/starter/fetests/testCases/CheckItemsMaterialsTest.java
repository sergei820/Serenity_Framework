package net.serenitybdd.starter.fetests.testCases;

import net.serenitybdd.starter.annotations.UITest;
import org.junit.Test;

import static net.serenitybdd.starter.fetests.pageObjects.BasePage.SAUCE_LABS_BOLT_T_SHIRT;
import static net.serenitybdd.starter.model.UserFactory.createValidUser;

public class CheckItemsMaterialsTest extends BaseTest {

    @UITest
    @Test
    public void checkMaterials() {
        startApp();
        logIn(createValidUser());
        basePageSteps.checkDescriptionOnUI(SAUCE_LABS_BOLT_T_SHIRT);
        stopApp();
    }
}
