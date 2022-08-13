package starter.stepsDefinitions;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.testSteps.BasePageSteps;

public class BasePageDefinitionSteps {

    @Steps
    public BasePageSteps basePageSteps;

    @Given("^User sets testCaseId (.*)$")
    public void userSetsTestCaseId(String testId) {
        String testCaseId = testId;
        ContextKeeper.
    }
}
