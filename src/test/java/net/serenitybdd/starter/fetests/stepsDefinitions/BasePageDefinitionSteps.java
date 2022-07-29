package net.serenitybdd.starter.fetests.stepsDefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.fetests.testSteps.BasePageSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;

import static model.model.UserFactory.createValidUser;

@RunWith(SerenityRunner.class)
public class BasePageDefinitionSteps {

    @Steps
    public BasePageSteps basePageSteps;

    @Given("User logs in to UI")
    public void userLogsInToUi() {
        basePageSteps.openBasePage();
        basePageSteps.logIn(createValidUser());
    }
}
