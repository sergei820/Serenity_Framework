package net.serenitybdd.starter.fetests.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.fetests.pageObjects.BasePage;
import net.serenitybdd.starter.fetests.pageObjects.InventoryPage;
import net.thucydides.core.annotations.DefaultUrl;
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
        System.out.println("Browser is opened");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        System.out.println("Login inserted");
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
}
