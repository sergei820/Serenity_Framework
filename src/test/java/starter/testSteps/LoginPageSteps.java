package starter.testSteps;

import lombok.extern.slf4j.Slf4j;
import models.user.User;
import net.serenitybdd.core.pages.PageObject;
import starter.pageObjects.LoginPage;
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
}
