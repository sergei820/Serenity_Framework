package net.serenitybdd.starter.fetests.testSteps;

import model.model.User;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.starter.fetests.pageObjects.BasePage;
import net.thucydides.core.annotations.Step;

public class BasePageSteps extends PageObject {

    BasePage basePage;// = new WebElementDecorator(basePage);

    @Step("Open base page")
    public void openBasePage() {
        basePage.open();
    }

    public void logIn(User user) {
        //enterText(basePage.getUserNameField(), user.getUserName());
        //enterText(basePage.getUserNameField(), user.getPassword());
        basePage.getUserNameField().sendKeys(user.getUserName());
        basePage.getPasswordField().sendKeys(user.getPassword());
        basePage.getLoginButton().click();
    }

    public String compileLocator(String locator, String replacement) {
        return locator.replace("REPLACE", replacement);
    }
}
