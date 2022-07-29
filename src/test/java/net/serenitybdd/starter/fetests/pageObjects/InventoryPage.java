package net.serenitybdd.starter.fetests.pageObjects;

import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

@Getter
@NamedUrls({
        @NamedUrl(name = "inventory", url = "/inventory.html")
})
public class InventoryPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@class='header_secondary_container']/span[text()='Products']")
    private WebElementFacade inventoryPageHeader;

    @Step("Check if inventory page is loaded")
    public void checkIfInventoryPageIsLoaded() {
        assertThat(inventoryPageHeader.isVisible())
                .as("Logging in wasn't successful")
                .isTrue();
    }
}
