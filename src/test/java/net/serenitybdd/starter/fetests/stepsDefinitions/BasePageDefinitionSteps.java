package net.serenitybdd.starter.fetests.stepsDefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.starter.fetests.testSteps.BasePageSteps;
import net.thucydides.core.annotations.Steps;

import static model.model.UserFactory.createValidUser;

public class BasePageDefinitionSteps {

    @Steps
    public BasePageSteps basePageSteps;

    @Given("User logs in to UI")
    public void userLogsInToUi() {
        basePageSteps.openBasePage();
        basePageSteps.logIn(createValidUser());
    }
}
