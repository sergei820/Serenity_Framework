package net.serenitybdd.starter.fetests.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseTest {

    @Managed
    WebDriver driver;

    //UTILS
    public String compileLocator(String locator, String replacement) {
        return locator.replace("REPLACE", replacement);
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
