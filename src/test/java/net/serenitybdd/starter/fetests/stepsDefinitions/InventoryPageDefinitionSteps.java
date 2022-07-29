package net.serenitybdd.starter.fetests.stepsDefinitions;

import io.cucumber.java.en.Then;
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

    @Then("^User checks on the UI if (.*) contains cotton$")
    public void userChecksOnTheUiIfItemContainsCotton(String itemName) {
        inventoryPageSteps.checkDescriptionOnUI(itemName);
    }

    @Then("^User checks on the UI if (.*) price is equal to price-list$")
    public void userChecksOnTheUiIfItemPriceIsEqualToPricelist(String itemName) {
        inventoryPageSteps.checkItemPrice(itemName);
    }
}
