package starter.pageObjects;

import net.serenitybdd.core.pages.PageObject;

public abstract class BasePage extends PageObject {

    public String compileLocator(String locator, String replacement) {
        return locator.replace("REPLACE", replacement);
    }
}
