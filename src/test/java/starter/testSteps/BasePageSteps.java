package starter.testSteps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.pageObjects.BasePage;

import static java.time.Duration.ofSeconds;

public abstract class BasePageSteps extends PageObject {

    BasePage basePage;
    JavascriptExecutor javascriptExecutor;

    public final void pageLoadingVerify() {
        checkDocumentReadyState();
        verifyPage();
    }

    public void checkDocumentReadyState() {
        javascriptExecutor = (JavascriptExecutor) Serenity.getDriver();
        new WebDriverWait(getDriver(), ofSeconds(3))
                .until(d -> javascriptExecutor.executeScript("return document.readyState").equals("complete"));
//                .until(d -> (Boolean) javascriptExecutor
//                        .executeScript("return window.jQuery != undefined && jQuery.active == 0"));
    }

    public abstract void verifyPage();
}
