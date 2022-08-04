package starter.pageObjects;

import core.enums.ItemsEnum;
import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static org.assertj.core.api.Assertions.assertThat;

@Getter
@DefaultUrl("https://www.saucedemo.com/inventory.html")
public class InventoryPage extends BasePage {

    public static final String ITEM_PRICE_BY_NAME_XPATH = "//div[text()='REPLACE']/parent::a/parent::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/div[@class='inventory_item_price']";
    public static final String ITEM_DESCRIPTION_BY_NAME_XPATH = "//div[text()='REPLACE']/parent::a/following-sibling::div[@class='inventory_item_desc']";

    @FindBy(how = How.XPATH, using = "//div[@class='header_secondary_container']/span[text()='Products']")
    private WebElementFacade inventoryPageHeader;

    @FindBy(how = How.CSS, using = ".inventory_list")
    private WebElementFacade inventoryPageGrid;

    public String getPriceFromUI(ItemsEnum itemName) {
        WebElementFacade backpackDescriptionElement = $(compileLocator(ITEM_PRICE_BY_NAME_XPATH, itemName.getName()));
        return backpackDescriptionElement.getText();
    }

    public String getDescriptionFromUI(ItemsEnum itemName) {
        WebElementFacade backpackDescriptionElement = $(compileLocator(ITEM_DESCRIPTION_BY_NAME_XPATH, itemName.getName()));
        backpackDescriptionElement.waitUntilVisible();
        return backpackDescriptionElement.getText();
    }
}
