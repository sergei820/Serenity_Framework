package net.serenitybdd.starter.fetests.testSteps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.starter.fetests.pageObjects.BasePage.*;
import static net.serenitybdd.starter.fetests.pageObjects.BasePage.ITEM_DESCRIPTION_BY_NAME_XPATH;
import static org.assertj.core.api.Assertions.assertThat;

public class InventoryPageSteps extends BasePageSteps {



    @Step("Check that inventory page is opened after successful login")
    public void checkInventoryPageIsOpenedAfterSuccessfulLogin() {
        assertThat(Serenity.getDriver().getCurrentUrl().contains("/inventory.html"))
                .as("inventory page hasn't been opened")
                .isTrue();
    }

    //Methods for price check
    public void checkItemPrice(String itemName) {
        assertThat(getPriceFromUI(itemName)).isEqualTo(getPriceByName(itemName));
    }

    public String getPriceByName(String itemName) {
        String itemPrice = null;
        switch(itemName) {
            case SAUCE_LABS_BACKPACK -> {itemPrice = "$29.99";}
            case SAUCE_LABS_BIKE_LIGHT -> {itemPrice = "$9.99";}
            case SAUCE_LABS_BOLT_T_SHIRT, TEST_ALLTHETHINGS_T_SHIRT_RED -> {itemPrice = "$15.99";}
            case SAUCE_LABS_FLEECE_JACKET -> {itemPrice = "$49.99";}
            case SAUCE_LABS_ONESIE -> {itemPrice = "$7.99";}
        }
        return itemPrice;
    }

    public String getPriceFromUI(String itemName) {
        //String locator = compileLocator(ITEM_PRICE_BY_NAME_XPATH, itemName);
        WebElementFacade backpackDescriptionElement = $(compileLocator(ITEM_PRICE_BY_NAME_XPATH, itemName));
        //WebElement backpackDescriptionElement = driver.findElement(By.xpath(locator));
        return backpackDescriptionElement.getText();
    }

    //Methods for materials check
    public void checkDescriptionOnUI(String itemName) {
        assertThat(containsCottonInDescriptionOnUI(itemName)).isEqualTo(isMadeFromCotton(itemName));
    }

    public Boolean isMadeFromCotton(String itemName) {
        Boolean containsCotton = null;
        switch(itemName) {
            case SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT,
                    SAUCE_LABS_FLEECE_JACKET, SAUCE_LABS_ONESIE -> {containsCotton = false;}
            case SAUCE_LABS_BOLT_T_SHIRT, TEST_ALLTHETHINGS_T_SHIRT_RED -> {containsCotton = true;}
        }
        return containsCotton;
    }

    public boolean containsCottonInDescriptionOnUI(String itemName) {
        //String locator = compileLocator(ITEM_DESCRIPTION_BY_NAME_XPATH, itemName);
        //WebElement backpackDescriptionElement = driver.findElement(By.xpath(locator));
        WebElementFacade backpackDescriptionElement = $(compileLocator(ITEM_DESCRIPTION_BY_NAME_XPATH, itemName));
        String itemDescriptionFromUI = backpackDescriptionElement.getText();

        isMadeFromCotton(itemName);
        itemDescriptionFromUI = itemDescriptionFromUI.toLowerCase();
        return itemDescriptionFromUI.contains("cotton");
    }
}
