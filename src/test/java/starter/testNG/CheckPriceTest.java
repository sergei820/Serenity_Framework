package starter.testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import starter.ReportSender;

public class CheckPriceTest extends ReportSender {

    @Test
    public void checkPriceTest() throws Throwable {

        testCaseId = "T2";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userNameField = driver.findElement(By.id("user-name"));

        Assert.assertTrue(userNameField.isDisplayed());

        //TestRailManager.addResultForTestCase(testCaseId, TestRailManager.TEST_CASE_PASSED_STATUS, "");
    }
}
