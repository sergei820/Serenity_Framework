package starter.pageObjects;

import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static org.assertj.core.api.Assertions.assertThat;

@Getter
@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPage extends BasePage {


    @FindBy(how = How.CSS, using = "div[id='cart_contents_container']")
    private WebElementFacade inventoryPageGrid;

    @Override
    public void verifyPage() {
        inventoryPageGrid.waitUntilVisible();
        assertThat(inventoryPageGrid.isVisible()).isTrue();
    }
}
