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

        String validElementId = "user-name";
        String notValidElementId = "user-name_wrong";
        testCaseId = "2";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userNameField = driver.findElement(By.id(notValidElementId));

        Assert.assertTrue(userNameField.isDisplayed());

        driver.quit();

        //TestRailManager.addResultForTestCase(testCaseId, TestRailManager.TEST_CASE_PASSED_STATUS, "");
    }
}
