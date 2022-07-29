package net.serenitybdd.starter.fetests.pageObjects;

import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

@Getter
@DefaultUrl("https://www.saucedemo.com/inventory.html")
@NamedUrls({
        @NamedUrl(name = "inventory", url = "/inventory.html")
})
public class InventoryPage extends BasePage {

    public static final String ITEM_PRICE_BY_NAME_XPATH = "//div[text()='REPLACE']/parent::a/parent::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/div[@class='inventory_item_price']";
    public static final String ITEM_DESCRIPTION_BY_NAME_XPATH = "//div[text()='REPLACE']/parent::a/following-sibling::div[@class='inventory_item_desc']";


    public static final String SAUCE_LABS_BACKPACK = "Sauce Labs Backpack";
    public static final String SAUCE_LABS_BIKE_LIGHT = "Sauce Labs Bike Light";
    public static final String SAUCE_LABS_BOLT_T_SHIRT = "Sauce Labs Bolt T-Shirt";
    public static final String SAUCE_LABS_FLEECE_JACKET = "Sauce Labs Fleece Jacket";
    public static final String SAUCE_LABS_ONESIE = "Sauce Labs Onesie";
    public static final String TEST_ALLTHETHINGS_T_SHIRT_RED = "Test.allTheThings() T-Shirt (Red)";

    @FindBy(how = How.XPATH, using = "//div[@class='header_secondary_container']/span[text()='Products']")
    private WebElementFacade inventoryPageHeader;

    @Step("Check if inventory page is loaded")
    public void checkIfInventoryPageIsLoaded() {
        assertThat(inventoryPageHeader.isVisible())
                .as("Logging in wasn't successful")
                .isTrue();
    }
}
