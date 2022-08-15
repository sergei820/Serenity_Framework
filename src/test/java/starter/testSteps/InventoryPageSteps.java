package starter.testSteps;

import core.enums.ItemsEnum;
import lombok.extern.log4j.Log4j;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import reporting.MyLogger;
import starter.pageObjects.InventoryPage;


import static org.assertj.core.api.Assertions.assertThat;

@Log4j
public class InventoryPageSteps extends BasePageSteps {

    InventoryPage inventoryPage;

    @Step
    public void openInventoryPage() {
        MyLogger.info("Opening inventory page");
        log.info("Opening inventory page");
        inventoryPage.open();
    }

    @Step
    public void verifyLoadedInventoryPage() {
        log.debug("Verifying inventory page");
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
