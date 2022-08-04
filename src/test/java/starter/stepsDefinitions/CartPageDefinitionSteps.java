package starter.stepsDefinitions;

import io.cucumber.java.en.And;
import starter.testSteps.CartPageSteps;

public class CartPageDefinitionSteps {

    CartPageSteps cartPageSteps;

    @And("User opens cart page")
    public void userOpensCartPage() {
        cartPageSteps.openCartPage();
    }
}
