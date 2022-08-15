package starter.stepsDefinitions;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.testSteps.BasePageSteps;
import utils.ContextKeeper;

public class BasePageDefinitionSteps {

    @Steps
    public BasePageSteps basePageSteps;

    @Given("^User sets testCaseId (.*)$")
    public void userSetsTestCaseId(int testId) {
        ContextKeeper.INSTANCE.setTestCaseId(testId);
    }
}
