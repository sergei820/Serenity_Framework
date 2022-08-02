package net.serenitybdd.starter.fetests.testSteps;

import lombok.extern.slf4j.Slf4j;
import model.User;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.starter.fetests.pageObjects.LoginPage;
import net.thucydides.core.annotations.Step;

@Slf4j
public class LoginPageSteps extends PageObject {

    LoginPage loginPage;

    @Step("Open base page")
    public void openBasePage() {
        log.info("Opening Login Page");
        loginPage.open();
    }

    public void logIn(User user) {
        loginPage.getUserNameField().sendKeys(user.getUserLogin());
        loginPage.getPasswordField().sendKeys(user.getUserPassword());
        loginPage.getLoginButton().click();
    }

    public String compileLocator(String locator, String replacement) {
        return locator.replace("REPLACE", replacement);
    }
}
