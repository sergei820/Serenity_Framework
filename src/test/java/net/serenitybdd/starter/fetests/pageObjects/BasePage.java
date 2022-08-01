package net.serenitybdd.starter.fetests.pageObjects;

import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@Getter
//@DefaultUrl("")
public class BasePage extends PageObject {

    @FindBy(how = How.ID, using = "user-name")
    //private WebElementFacadeDecoratorInterface userNameField;
    private WebElementFacade userNameField;

    @FindBy(how = How.ID, using = "password")
    private WebElementFacade passwordField;

    @FindBy(how = How.ID, using = "login-button")
    private WebElementFacade loginButton;
}
