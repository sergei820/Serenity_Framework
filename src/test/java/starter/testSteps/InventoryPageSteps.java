package starter.testSteps;

import core.enums.ItemsEnum;
import net.serenitybdd.core.Serenity;
import starter.pageObjects.InventoryPage;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class InventoryPageSteps extends BasePageSteps {

    InventoryPage inventoryPage;

    @Step
    public void openInventoryPage() {
        inventoryPage.open();
    }

    @Step
    public void verifyLoadedInventoryPage() {
        inventoryPage.verifyPage();
    }

    @Step("Check that inventory page is opened after successful login")
    public void checkInventoryPageIsOpenedAfterSuccessfulLogin() {
        assertThat(Serenity.getDriver().getCurrentUrl().contains("/inventory.html"))
                .as("inventory page hasn't been opened")
                .isTrue();
    }

    @Step("Check item price")
    public void checkItemPrice(ItemsEnum itemName) {
        String itemPriceActual = inventoryPage.getItemPrice(itemName);
        String itemPriceExpected = itemName.getPrice();
        assertThat(itemPriceActual).isEqualTo(itemPriceExpected);
    }

    @Step("Check item description on UI")
    public void checkDescriptionOnUI(ItemsEnum itemName, String material) {
        assertThat(containsMaterialInDescriptionOnUI(itemName, material)).isEqualTo(itemName.getIsMadeFromCotton());
    }

    public boolean containsMaterialInDescriptionOnUI(ItemsEnum itemName, String material) {
        String itemDescriptionActual = inventoryPage.getItemDescription(itemName);
        itemDescriptionActual = itemDescriptionActual.toLowerCase();
        return itemDescriptionActual.contains(material);
    }
}
