package starter.testSteps;

import net.thucydides.core.annotations.Step;
import starter.pageObjects.CartPage;

public class CartPageSteps {

    CartPage cartPage;

    @Step("Open cart page")
    public void openCartPage() {
        cartPage.open();
    }
}
