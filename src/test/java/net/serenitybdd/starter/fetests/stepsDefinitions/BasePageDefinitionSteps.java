package net.serenitybdd.starter.fetests.stepsDefinitions;

import io.cucumber.java.en.Given;
import model.model.UserList;
import net.serenitybdd.starter.fetests.testSteps.BasePageSteps;
import net.thucydides.core.annotations.Steps;

import static model.model.UserFactory.createValidUser;

public class BasePageDefinitionSteps {

    @Steps
    public BasePageSteps basePageSteps;

    @Given("^(.*) logs in to UI$")
    public void userLogsInToUi(UserList user) {
        basePageSteps.openBasePage();
        basePageSteps.logIn(createValidUser(user));
    }
}
