package net.serenitybdd.starter.fetests.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class SwitchCaseDemo extends PageObject {

    public static final String SAUCE_LABS_BACKPACK = "Sauce Labs Backpack";
    public static final String SAUCE_LABS_BIKE_LIGHT = "Sauce Labs Bike Light";
    public static final String SAUCE_LABS_BOLT_T_SHIRT = "Sauce Labs Bolt T-Shirt";
    public static final String SAUCE_LABS_FLEECE_JACKET = "Sauce Labs Fleece Jacket";
    public static final String SAUCE_LABS_ONESIE = "Sauce Labs Onesie";
    public static final String TEST_ALLTHETHINGS_T_SHIRT_RED = "Test.allTheThings() T-Shirt (Red)";

    public static final String ITEM_PRICE_BY_NAME_XPATH = "//div[text()='REPLACE']/parent::a/parent::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/div[@class='inventory_item_price']";
    public static final String ITEM_DESCRIPTION_BY_NAME_XPATH = "//div[text()='Sauce Labs Bolt T-Shirt']/parent::a/following-sibling::div[@class='inventory_item_desc']";

    @Managed
    WebDriver driver;

    @Test
    public void checkPrices() {
        startApp();
        logIn();
        checkItemPrice();
        stopApp();
    }

    @Test
    public void checkMaterials() {
        //isMadeFromCotton()
    }

    public void checkItemPrice() {
        assertThat(getPriceFromUI(SAUCE_LABS_BACKPACK)).isEqualTo(getPriceByName(SAUCE_LABS_BACKPACK));
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

    public Boolean isMadeFromCotton(String itemName) {
        Boolean containsCotton = null;
        switch(itemName) {
            case SAUCE_LABS_BACKPACK -> {containsCotton = false;}
            case SAUCE_LABS_BIKE_LIGHT -> {containsCotton = false;}
            case SAUCE_LABS_BOLT_T_SHIRT -> {containsCotton = true;}
            case SAUCE_LABS_FLEECE_JACKET -> {containsCotton = false;}
            case SAUCE_LABS_ONESIE -> {containsCotton = false;}
            case TEST_ALLTHETHINGS_T_SHIRT_RED -> {containsCotton = true;}
        }
        return containsCotton;
    }

    public String shouldContainCotton(String itemName) {
        String itemDescription = null;
        switch(itemName) {
            case SAUCE_LABS_BACKPACK -> {itemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";}
            case SAUCE_LABS_BIKE_LIGHT -> {itemDescription = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";}
            case SAUCE_LABS_BOLT_T_SHIRT -> {itemDescription = "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.";}
            case SAUCE_LABS_FLEECE_JACKET -> {itemDescription = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";}
            case SAUCE_LABS_ONESIE -> {itemDescription = "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.";}
            case TEST_ALLTHETHINGS_T_SHIRT_RED -> {itemDescription = "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.";}
        }
        return itemDescription;
    }

    public String compileLocator(String locator, String replacement) {
        return locator.replace("REPLACE", replacement);
    }

    public boolean containsCotton(String item) {
        String locator = compileLocator(ITEM_DESCRIPTION_BY_NAME_XPATH, SAUCE_LABS_BACKPACK);
        WebElement backpackDescriptionElement = driver.findElement(By.xpath(locator));
        String itemDescriptionFromUI = backpackDescriptionElement.getText();

        isMadeFromCotton(item);
        itemDescriptionFromUI = itemDescriptionFromUI.toLowerCase();
        return itemDescriptionFromUI.contains("cotton");
    }

    public String getPriceFromUI(String itemName) {
        String locator = compileLocator(ITEM_PRICE_BY_NAME_XPATH, itemName);
        WebElement backpackDescriptionElement = driver.findElement(By.xpath(locator));
        return backpackDescriptionElement.getText();
    }

    public void startApp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    public void stopApp() {
        driver.quit();
    }

    public void logIn() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        checkLoggingInSuccessfull();
    }

    public void checkLoggingInSuccessfull() {
        assertThat(driver.getCurrentUrl().contains("/inventory.html"))
                .as("inventory page hasn't been opened")
                .isTrue();
    }
}
