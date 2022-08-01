package net.serenitybdd.starter.fetests.pageObjects;

import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import utils.WebElementDecorator;
import utils.WebElementFacadeDecoratorInterface;

@Getter
@DefaultUrl("https://www.saucedemo.com/")
public class BasePage extends PageObject {

    @FindBy(how = How.ID, using = "user-name")
    private WebElementFacadeDecoratorInterface userNameField;

    @FindBy(how = How.ID, using = "password")
    private WebElementFacadeDecoratorInterface passwordField;

    @FindBy(how = How.ID, using = "login-button")
    private WebElementFacadeDecoratorInterface loginButton;
}
