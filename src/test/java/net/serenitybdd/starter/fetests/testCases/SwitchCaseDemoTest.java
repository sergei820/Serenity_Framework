package net.serenitybdd.starter.fetests.testCases;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.starter.model.User.createValidUser;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class SwitchCaseDemoTest extends BaseTest {

    public static final String SAUCE_LABS_BACKPACK = "Sauce Labs Backpack";
    public static final String SAUCE_LABS_BIKE_LIGHT = "Sauce Labs Bike Light";
    public static final String SAUCE_LABS_BOLT_T_SHIRT = "Sauce Labs Bolt T-Shirt";
    public static final String SAUCE_LABS_FLEECE_JACKET = "Sauce Labs Fleece Jacket";
    public static final String SAUCE_LABS_ONESIE = "Sauce Labs Onesie";
    public static final String TEST_ALLTHETHINGS_T_SHIRT_RED = "Test.allTheThings() T-Shirt (Red)";

    public static final String ITEM_PRICE_BY_NAME_XPATH = "//div[text()='REPLACE']/parent::a/parent::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/div[@class='inventory_item_price']";
    public static final String ITEM_DESCRIPTION_BY_NAME_XPATH = "//div[text()='Sauce Labs Bolt T-Shirt']/parent::a/following-sibling::div[@class='inventory_item_desc']";

    @Test
    public void checkPrices() {
        startApp();
        logIn(createValidUser());
        checkItemPrice(SAUCE_LABS_BACKPACK);
        stopApp();
    }

    @Test
    public void checkMaterials() {
        startApp();
        logIn(createValidUser());
        checkDescriptionOnUI(SAUCE_LABS_BOLT_T_SHIRT);
        stopApp();
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
        String locator = compileLocator(ITEM_PRICE_BY_NAME_XPATH, itemName);
        WebElement backpackDescriptionElement = driver.findElement(By.xpath(locator));
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
        String locator = compileLocator(ITEM_DESCRIPTION_BY_NAME_XPATH, itemName);
        WebElement backpackDescriptionElement = driver.findElement(By.xpath(locator));
        String itemDescriptionFromUI = backpackDescriptionElement.getText();

        isMadeFromCotton(itemName);
        itemDescriptionFromUI = itemDescriptionFromUI.toLowerCase();
        return itemDescriptionFromUI.contains("cotton");
    }
}
