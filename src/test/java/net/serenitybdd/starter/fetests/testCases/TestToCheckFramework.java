package net.serenitybdd.starter.fetests.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.fetests.pageObjects.BasePage;
import net.serenitybdd.starter.fetests.pageObjects.InventoryPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

@DefaultUrl("https://www.saucedemo.com")
@RunWith(SerenityRunner.class)
public class TestToCheckFramework extends PageObject {

    @Steps
    private BasePage basePage;
    @Steps
    private InventoryPage inventoryPage;

    WebDriver driver;

    @Test
    public void checkLoggingIn() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = Serenity.getDriver();

        driver.get("https://www.saucedemo.com");
        System.out.println("Browser is opened");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //$(By.id("user-name")).waitUntilVisible();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //$(By.id("user-name")).sendKeys("standard_user");
        System.out.println("Login inserted");
        //$(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //$(By.id("login-button")).click();
        assertThat(driver.getCurrentUrl().contains("/inventory.html")).isTrue();
        Thread.sleep(3000);
        System.out.println("Test passed");

        //basePage.logIn();
        //inventoryPage.checkIfInventoryPageIsLoaded();

        driver.quit();
    }
}
