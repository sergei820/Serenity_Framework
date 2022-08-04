package starter.stepsDefinitions;

import core.enums.UserType;
import io.cucumber.java.en.Given;
import models.user.User;
import models.userManager.UserManager;
import net.thucydides.core.annotations.Steps;
import starter.testSteps.LoginPageSteps;

import static core.UserManagerFactory.getUserManager;

public class LoginPageDefinitionSteps {

    @Steps
    public LoginPageSteps loginPageSteps;

    @Given("^User opens login page$")
    public void userOpensPage() {
        loginPageSteps.openLoginPage();
    }

    @Given("^(.*) logs in to UI$")
    public void userLogsInToUi(UserType userType) {
        UserManager userManager = getUserManager(userType);
        User user = userManager.createUser();
        loginPageSteps.logIn(user);
    }
}
