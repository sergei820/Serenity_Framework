package starter.pageObjects;

import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static org.assertj.core.api.Assertions.assertThat;

@Getter
@DefaultUrl("https://www.saucedemo.com/inventory-item.html?id=5")
public class InventoryItemPage extends BasePage {

    @FindBy(how = How.CSS, using = ".inventory_details_desc_container")
    private WebElementFacade itemDetailsContainer;

    @Override
    public void verifyPage() {
        itemDetailsContainer.waitUntilVisible();
        assertThat(itemDetailsContainer.isVisible()).isTrue();
    }
}
