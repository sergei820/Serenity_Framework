package starter.testSteps;

import net.serenitybdd.core.pages.PageObject;
import starter.pageObjects.BasePage;

public class BasePageSteps extends PageObject {

    BasePage basePage;

    public void checkIfPageSuccessfullyLaoded() {
        basePage.pageLoadingVerify();
    }
}
