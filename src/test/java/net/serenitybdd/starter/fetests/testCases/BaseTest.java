package net.serenitybdd.starter.fetests.testCases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.fetests.testSteps.BasePageSteps;
import net.serenitybdd.starter.model.User;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class BaseTest {

    @Managed
    public WebDriver driver;

    @Steps
    public BasePageSteps basePageSteps;

    public void startApp() {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();

        //driver = Serenity.getDriver();
        driver.get("https://www.saucedemo.com");
        basePageSteps = new BasePageSteps();
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
}
