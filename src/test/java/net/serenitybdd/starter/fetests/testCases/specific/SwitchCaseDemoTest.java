package net.serenitybdd.starter.fetests.testCases.specific;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.annotations.UITest;
import net.serenitybdd.starter.fetests.testCases.BaseTest;
import net.serenitybdd.starter.fetests.testSteps.BasePageSteps;
import net.thucydides.core.annotations.Steps;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.starter.fetests.pageObjects.BasePage.*;
import static net.serenitybdd.starter.model.User.createValidUser;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class SwitchCaseDemoTest extends BaseTest {

    @UITest
    @Test
    public void checkPrices() {
        startApp();
        logIn(createValidUser());
        basePageSteps.checkItemPrice(SAUCE_LABS_BACKPACK);
        stopApp();
    }

    @UITest
    @Test
    public void checkMaterials() {
        startApp();
        logIn(createValidUser());
        basePageSteps.checkDescriptionOnUI(SAUCE_LABS_BOLT_T_SHIRT);
        stopApp();
    }
}
