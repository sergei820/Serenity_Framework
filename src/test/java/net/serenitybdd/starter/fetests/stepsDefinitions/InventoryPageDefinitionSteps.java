package net.serenitybdd.starter.fetests.stepsDefinitions;

import io.cucumber.java.en.When;
import net.serenitybdd.starter.fetests.testSteps.InventoryPageSteps;
import net.thucydides.core.annotations.Steps;

public class InventoryPageDefinitionSteps {

    @Steps
    public InventoryPageSteps inventoryPageSteps;

    @When("User is on the inventory page")
    public void userIsOnTheInventoryPage() {
        inventoryPageSteps.checkInventoryPageIsOpenedAfterSuccessfulLogin();
    }
}
