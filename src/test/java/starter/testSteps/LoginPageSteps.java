package starter.testSteps;

import lombok.extern.log4j.Log4j;
import models.user.User;
import net.thucydides.core.annotations.Step;
import starter.pageObjects.LoginPage;

@Log4j
public class LoginPageSteps extends BasePageSteps {

    LoginPage loginPage;

    @Step("Open login page")
    public void openLoginPage() {
        log.info("Opening login page");
        loginPage.open();
    }

    @Step("Verify loaded page")
    public void verifyLoadedLoginPage() {
        log.debug("Verifying login page");
        loginPage.verifyPage();
    }

    public void logIn(User user) {
        log.info("Logging in");
        log.debug("Entering login");
        loginPage.getUserNameField().sendKeys(user.getUserLogin());
        log.debug("Entering password");
        loginPage.getPasswordField().sendKeys(user.getUserPassword());
        log.debug("Clicking login button");
        loginPage.getLoginButton().click();
    }
}
