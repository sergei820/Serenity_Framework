package net.serenitybdd.starter.fetests.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.starter.model.User;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseTest {

    @Managed
    WebDriver driver;

    public void startApp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    public void stopApp() {
        driver.quit();
    }

    public void logIn(User user) {
        if(!driver.getCurrentUrl().equals("https://www.saucedemo.com")) driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys(user.getUserName());
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        driver.findElement(By.id("login-button")).click();
        checkSuccessfulLogin();
    }

    public void checkSuccessfulLogin() {
        assertThat(driver.getCurrentUrl().contains("/inventory.html"))
                .as("inventory page hasn't been opened")
                .isTrue();
    }

    public String compileLocator(String locator, String replacement) {
        return locator.replace("REPLACE", replacement);
    }
}
