package net.serenitybdd.starter.fetests.testSteps;

import model.model.User;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.starter.fetests.pageObjects.BasePage;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class BasePageSteps extends PageObject {

    BasePage basePage;

    @Step("Open base page")
    public void openBasePage() {
        basePage.open();
    }

    public void startApp() {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();

        //driver = Serenity.getDriver();
        //driver.get(BASE_URL);
    }

    public void stopApp() {
        //driver.quit();
    }

    public void logIn(User user) {
        basePage.getUserNameField().sendKeys(user.getUserName());
        basePage.getPasswordField().sendKeys(user.getPassword());
        basePage.getLoginButton().click();
        //if(!driver.getCurrentUrl().equals("https://www.saucedemo.com")) driver.get("https://www.saucedemo.com");
        //driver.findElement(By.id("user-name")).sendKeys(user.getUserName());
        //driver.findElement(By.id("password")).sendKeys(user.getPassword());
        //driver.findElement(By.id("login-button")).click();
        //checkSuccessfulLogin();
    }



    public String compileLocator(String locator, String replacement) {
        return locator.replace("REPLACE", replacement);
    }
}
