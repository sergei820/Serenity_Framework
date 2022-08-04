package starter.stepsDefinitions;

import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.testSteps.BasePageSteps;

public class BasePageDefinitionSteps {

    @Steps
    public BasePageSteps basePageSteps;

    @Then("Page successfully loaded")
    public void pageSuccessfullyLoaded() {
        basePageSteps.checkIfPageSuccessfullyLaoded();
    }
}
