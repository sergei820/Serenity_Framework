package net.serenitybdd.starter.fetests.pageObjects;

import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@Getter
@DefaultUrl("https://www.saucedemo.com/")
public class BasePage extends PageObject {

    public static final String SAUCE_LABS_BACKPACK = "Sauce Labs Backpack";
    public static final String SAUCE_LABS_BIKE_LIGHT = "Sauce Labs Bike Light";
    public static final String SAUCE_LABS_BOLT_T_SHIRT = "Sauce Labs Bolt T-Shirt";
    public static final String SAUCE_LABS_FLEECE_JACKET = "Sauce Labs Fleece Jacket";
    public static final String SAUCE_LABS_ONESIE = "Sauce Labs Onesie";
    public static final String TEST_ALLTHETHINGS_T_SHIRT_RED = "Test.allTheThings() T-Shirt (Red)";

    public static final String ITEM_PRICE_BY_NAME_XPATH = "//div[text()='REPLACE']/parent::a/parent::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/div[@class='inventory_item_price']";
    public static final String ITEM_DESCRIPTION_BY_NAME_XPATH = "//div[text()='Sauce Labs Bolt T-Shirt']/parent::a/following-sibling::div[@class='inventory_item_desc']";


    @FindBy(how = How.ID, using = "user-name")
    private WebElementFacade userNameField;

    @FindBy(how = How.ID, using = "password")
    private WebElementFacade passwordField;

    @FindBy(how = How.ID, using = "login-button")
    private WebElementFacade loginButton;

    @Step
    public void logIn() {
        userNameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
    }

}
