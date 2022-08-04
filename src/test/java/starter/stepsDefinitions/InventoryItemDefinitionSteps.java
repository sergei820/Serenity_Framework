package starter.stepsDefinitions;

import io.cucumber.java.en.And;
import starter.pageObjects.InventoryItemPage;
import starter.testSteps.InventoryItemPageSteps;

public class InventoryItemDefinitionSteps {

    InventoryItemPageSteps inventoryItemPageSteps;

    @And("User opens inventory-item page")
    public void userOpensInventoryItemPage() {
        inventoryItemPageSteps.openInventoryItemPage();
    }
}
