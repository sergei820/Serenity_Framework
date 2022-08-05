package starter.testSteps;

import lombok.extern.slf4j.Slf4j;
import models.user.User;
import net.thucydides.core.annotations.Step;
import starter.pageObjects.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LoginPageSteps extends BasePageSteps {

    LoginPage loginPage;

    @Step("Open login page")
    public void openLoginPage() {
        log.info("Opening Login Page");
        loginPage.open();
    }

    @Step("Verify loaded page")
    public void verifyLoadedLoginPage() {
        loginPage.verifyPage();
    }

    public void logIn(User user) {
        loginPage.getUserNameField().sendKeys(user.getUserLogin());
        loginPage.getPasswordField().sendKeys(user.getUserPassword());
        loginPage.getLoginButton().click();
    }
}
