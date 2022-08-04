package starter.testSteps;

import net.thucydides.core.annotations.Step;
import starter.pageObjects.InventoryItemPage;

public class InventoryItemPageSteps {

    InventoryItemPage inventoryItemPage;

    @Step("Open inventory-item page")
    public void openInventoryItemPage() {
        inventoryItemPage.open();
    }
}
