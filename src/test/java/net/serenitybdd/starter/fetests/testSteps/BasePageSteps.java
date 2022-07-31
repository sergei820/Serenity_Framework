package net.serenitybdd.starter.fetests.testSteps;

import model.model.User;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.starter.fetests.pageObjects.BasePage;
import net.thucydides.core.annotations.Step;

import static utils.WebElementDecorator.clickOnElement;
import static utils.WebElementDecorator.enterText;

public class BasePageSteps extends PageObject {

    BasePage basePage;

    @Step("Open base page")
    public void openBasePage() {
        basePage.open();
    }

    public void logIn(User user) {
        //enterText(basePage.getUserNameField(), user.getUserName());
        //enterText(basePage.getUserNameField(), user.getPassword());
        basePage.getUserNameField().sendKeys(user.getUserName());
        basePage.getPasswordField().sendKeys(user.getPassword());
        clickOnElement(basePage.getLoginButton());
    }

    public String compileLocator(String locator, String replacement) {
        return locator.replace("REPLACE", replacement);
    }
}
