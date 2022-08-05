package starter.stepsDefinitions;

import core.enums.ItemsEnum;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.testSteps.InventoryPageSteps;
import net.thucydides.core.annotations.Steps;

public class InventoryPageDefinitionSteps {

    @Steps
    public InventoryPageSteps inventoryPageSteps;

    @When("User is on the inventory page")
    public void userIsOnTheInventoryPage() {
        inventoryPageSteps.checkInventoryPageIsOpenedAfterSuccessfulLogin();
    }

    @Then("^User checks on the UI if (.*) contains (.*)")
    public void userChecksOnTheUiIfItemContainsMaterial(ItemsEnum itemName, String material) {
        inventoryPageSteps.checkDescriptionOnUI(itemName, material);
    }

    @Then("^User checks on the UI if (.*) price is equal to price-list$")
    public void userChecksOnTheUiIfItemPriceIsEqualToPricelist(ItemsEnum itemName) {
        inventoryPageSteps.checkItemPrice(itemName);
    }

    @And("User is on the inventory page and page successfully loaded")
    public void userOpensInventoryPage() {
        inventoryPageSteps.openInventoryPage();
        inventoryPageSteps.verifyLoadedInventoryPage();
    }
}
