package utils;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

@Slf4j
public class WebElementDecorator extends PageObject {

    private final WebElement decoratedWebElement;

    public WebElementDecorator(WebElement decoratedWebElement) {
        this.decoratedWebElement = decoratedWebElement;
    }

    public static void clickOnElement(WebElementFacade element) {
        element.waitUntilVisible();
        System.out.println("Trying to click by visible element: " + element);
        log.info("Trying to click by visible element: " + element);
        element.click();
    }

    public static void enterText(WebElementFacade element, String textToBeEntered) {
        element.waitUntilVisible();
        element.getElement().clear();
        log.info("Trying to send text to visible element: " + element);
        element.sendKeys(textToBeEntered);
    }
}
