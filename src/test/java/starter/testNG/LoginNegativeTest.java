package starter.testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import starter.ReportSender;
import utils.PropertiesLoader;

public class LoginNegativeTest extends ReportSender {

    @Test
    public void loginNegativeTest() throws Throwable {

        testCaseId = "2";

        By userNameField = By.id("user-name");
        By passwordField = By.id("password");
        By loginButton = By.id("login-button");
        By elementOnInventoryPage = By.cssSelector(".inventory_list");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.findElement(userNameField).sendKeys(PropertiesLoader.loadProperty("lockedUserLogin"));
        driver.findElement(passwordField).sendKeys(PropertiesLoader.loadProperty("lockedUserPassword"));
        driver.findElement(loginButton).click();

        Assert.assertFalse(driver.findElement(elementOnInventoryPage).isDisplayed());

        driver.quit();
    }
}
