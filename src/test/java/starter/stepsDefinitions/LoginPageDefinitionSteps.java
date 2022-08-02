package starter.stepsDefinitions;

import io.cucumber.java.en.Given;
import models.User;
import starter.testSteps.LoginPageSteps;
import net.thucydides.core.annotations.Steps;

import static core.UserFactory.createUser;

public class LoginPageDefinitionSteps {

    @Steps
    public LoginPageSteps loginPageSteps;

    @Given("^(.*) logs in to UI$")
    public void userLogsInToUi(String userType) {
        loginPageSteps.openBasePage();
        User user = createUser(userType);
        loginPageSteps.logIn(user);
    }
}
