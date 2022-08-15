package starter.pageObjects;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;

public abstract class BasePage extends PageObject {

    JavascriptExecutor javascriptExecutor;

    public String compileLocator(String locator, String replacement) {
        return locator.replace("REPLACE", replacement);
    }

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
