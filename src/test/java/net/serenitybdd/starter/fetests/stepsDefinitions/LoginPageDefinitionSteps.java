package net.serenitybdd.starter.fetests.stepsDefinitions;

import io.cucumber.java.en.Given;
import model.User;
import net.serenitybdd.starter.fetests.testSteps.LoginPageSteps;
import net.thucydides.core.annotations.Steps;

import static model.UserFactory.createUser;

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
