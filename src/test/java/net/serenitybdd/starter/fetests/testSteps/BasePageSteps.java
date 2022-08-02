package net.serenitybdd.starter.fetests.testSteps;

import lombok.extern.slf4j.Slf4j;
import model.User;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.starter.fetests.pageObjects.LoginPage;
import net.thucydides.core.annotations.Step;

@Slf4j
public class BasePageSteps extends PageObject {

    LoginPage loginPage;

    @Step("Open base page")
    public void openBasePage() {
        log.info("Opening Login Page");
        loginPage.open();
    }

    public void logIn(User user) {
        //enterText(basePage.getUserNameField(), user.getUserName());
        //enterText(basePage.getUserNameField(), user.getPassword());
        loginPage.getUserNameField().sendKeys(user.getUserName());
        loginPage.getPasswordField().sendKeys(user.getPassword());
        loginPage.getLoginButton().click();
    }

    public String compileLocator(String locator, String replacement) {
        return locator.replace("REPLACE", replacement);
    }
}
