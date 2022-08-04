package starter.pageObjects;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public abstract class BasePage extends PageObject {

    JavascriptExecutor javascriptExecutor;

    public String compileLocator(String locator, String replacement) {
        return locator.replace("REPLACE", replacement);
    }

    public void pageLoadingVerify() {
        //Serenity.getDriver()
        checkAjax();
        verifyPage();
    }

    public void checkAjax() {
        javascriptExecutor = (JavascriptExecutor) getDriver();
        new WebDriverWait(getDriver(), ofSeconds(3))
                .until(d -> (Boolean) javascriptExecutor
                        .executeScript("return window.jQuery != undefined && jQuery.active == 0"));
    }

    public abstract void verifyPage();
}
