package net.serenitybdd.starter.fetests.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.fetests.pageObjects.BasePage;
import net.serenitybdd.starter.fetests.pageObjects.InventoryPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class TestToCheckFramework extends PageObject {

    public static final String ITEM_NAME = ".inventory_item_name";
    public static final String STANDARD_USER = "standard_user";
    public static final String LOCKED_OUT_USER = "locked_out_user";
    public static final String PROBLEM_USER = "problem_user";
    public static final String PERFORMANCE_GLITCH_USER = "performance_glitch_user";

    @Steps
    private BasePage basePage;
    @Steps
    private InventoryPage inventoryPage;

    @Managed
    WebDriver driver;

    @Test
    public void checkLoggingIn() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Local run with ChromeDriver
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assertThat(driver.getCurrentUrl().contains("/inventory.html"))
                .as("inventory page hasn't been opened")
                .isTrue();
        Thread.sleep(3000);
        System.out.println("Test passed");


        //$(By.id("user-name")).waitUntilVisible();
        //$(By.id("user-name")).sendKeys("standard_user");
        //$(By.id("password")).sendKeys("secret_sauce");
        //$(By.id("login-button")).click();


        //basePage.logIn();
        //inventoryPage.checkIfInventoryPageIsLoaded();

        driver.quit();
    }

    @Test
    public void switchExpressionsDemo() {
        showUserDescription(STANDARD_USER);
    }

    public void showUserDescription(String login) {
        switch(login) {
            case STANDARD_USER -> {System.out.println("User will be successfully logged in");}
            case LOCKED_OUT_USER -> {System.out.println("User won't be logged in");}
            case PROBLEM_USER -> {System.out.println("User will be logged in with wrong items pictures");}
            case PERFORMANCE_GLITCH_USER -> {System.out.println("User will be logged in with delay");}
        }
    }

    public void startApp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Local run with ChromeDriver
        driver.get("https://www.saucedemo.com");
    }


    public void logIn() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assertThat(driver.getCurrentUrl().contains("/inventory.html"))
                .as("inventory page hasn't been opened")
                .isTrue();
    }

    public boolean itemsPageIsOpened() {
        return driver.getCurrentUrl().contains("/inventory.html");
    }
}
