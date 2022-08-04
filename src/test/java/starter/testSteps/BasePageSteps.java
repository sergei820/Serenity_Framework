package starter.testSteps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import starter.pageObjects.BasePage;

public abstract class BasePageSteps extends PageObject {

    BasePage basePage;
    JavascriptExecutor javascriptExecutor;

    public final void pageLoadingVerify() {
        checkDocumentReadyState();
        verifyPage();
    }

    public void checkDocumentReadyState() {
        javascriptExecutor = (JavascriptExecutor) Serenity.getDriver();
        waitForCondition().until(d -> javascriptExecutor.executeScript("return document.readyState").equals("complete"));
    }

    public abstract void verifyPage();
}
