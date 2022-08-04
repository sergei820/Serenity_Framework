package starter.pageObjects;

import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static org.assertj.core.api.Assertions.assertThat;

@Getter
@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "user-name")
    private WebElementFacade userNameField;

    @FindBy(how = How.ID, using = "password")
    private WebElementFacade passwordField;

    @FindBy(how = How.ID, using = "login-button")
    private WebElementFacade loginButton;

    @FindBy(how = How.CSS, using = ".login_wrapper-inner")
    private WebElementFacade loginWrapper;
}
