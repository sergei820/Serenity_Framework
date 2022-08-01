package utils;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WebElementDecorator implements WebElementFacadeDecoratorInterface {

    private final WebElementFacade decorated;

    public WebElementDecorator(WebElementFacade decorated) {
        this.decorated = decorated;
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        decorated.waitUntilVisible();
        log.info("Sending keys: " + keysToSend + " to element: " + decorated.getElement());
        decorated.sendKeys(keysToSend);
    }

    @Override
    public void click() {
        decorated.waitUntilVisible();
        log.info("Clicking on element: " + decorated.getElement());
        decorated.click();
    }

    public static void clickOnElement(WebElementFacade element) {
        element.waitUntilVisible();
        log.info("Trying to click by visible element: " + element);
        element.click();
    }

    public static void enterText(WebElementFacade element, String textToBeEntered) {
        element.waitUntilVisible();
        element.getElement().clear();
        log.info("Trying to send text to visible element: " + element);
        element.sendKeys(textToBeEntered);
    }



    @Override
    public <T extends WebElementFacade> T then(String s) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T thenFind(String s) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T then(String s, Object... objects) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T thenFind(String s, Object... objects) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T findBy(String s) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T findBy(String s, Object... objects) {
        return null;
    }

    @Override
    public ListOfWebElementFacades thenFindAll(String s) {
        return null;
    }

    @Override
    public ListOfWebElementFacades thenFindAll(String s, Object... objects) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T findBy(By by) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T find(By by) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T then(By by) {
        return null;
    }

    @Override
    public String getAttribute(String s) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public WebElementState expect(String s) {
        return null;
    }

    @Override
    public boolean isClickable() {
        return false;
    }

    @Override
    public ListOfWebElementFacades thenFindAll(By... bies) {
        return null;
    }

    @Override
    public long getImplicitTimeoutInMilliseconds() {
        return 0;
    }

    @Override
    public <T extends WebElementFacade> T withTimeoutOf(int i, TimeUnit timeUnit) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T withTimeoutOf(int i, TemporalUnit temporalUnit) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T withTimeoutOf(Duration duration) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T and() {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T then() {
        return null;
    }

    @Override
    public List<String> getSelectOptions() {
        return null;
    }

    @Override
    public boolean isPresent() {
        return false;
    }

    @Override
    public WebElementState shouldBePresent() {
        return null;
    }

    @Override
    public WebElementState shouldNotBePresent() {
        return null;
    }

    @Override
    public WebElementState shouldBeSelected() {
        return null;
    }

    @Override
    public WebElementState shouldNotBeSelected() {
        return null;
    }

    @Override
    public String getTextValue() {
        return null;
    }

    @Override
    public List<String> getSelectOptionValues() {
        return null;
    }

    @Override
    public String getFirstSelectedOptionVisibleText() {
        return null;
    }

    @Override
    public List<String> getSelectedVisibleTexts() {
        return null;
    }

    @Override
    public String getSelectedValue() {
        return null;
    }

    @Override
    public String getFirstSelectedOptionValue() {
        return null;
    }

    @Override
    public List<String> getSelectedValues() {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T type(CharSequence... charSequences) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T typeAndEnter(String s) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T typeAndTab(String s) {
        return null;
    }

    @Override
    public void setWindowFocus() {

    }

    @Override
    public FluentDropdownSelect select() {
        return null;
    }

    @Override
    public FluentDropdownDeselect deselect() {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T deselectAll() {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T deselectByVisibleText(String s) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T deselectByValue(String s) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T deselectByIndex(int i) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T selectByVisibleText(String s) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T selectByValue(String s) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T selectByIndex(int i) {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T waitUntilVisible() {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T waitUntilPresent() {
        return null;
    }

    @Override
    public Wait<WebDriver> waitForCondition() {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T waitUntilNotVisible() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public String getTextContent() {
        return null;
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public boolean isCurrentlyVisible() {
        return false;
    }

    @Override
    public boolean isCurrentlyEnabled() {
        return false;
    }

    @Override
    public WebElementState shouldBeVisible() {
        return null;
    }

    @Override
    public WebElementState shouldBeCurrentlyVisible() {
        return null;
    }

    @Override
    public WebElementState shouldNotBeVisible() {
        return null;
    }

    @Override
    public WebElementState shouldNotBeCurrentlyVisible() {
        return null;
    }

    @Override
    public boolean hasFocus() {
        return false;
    }

    @Override
    public boolean containsText(String s) {
        return false;
    }

    @Override
    public boolean containsValue(String s) {
        return false;
    }

    @Override
    public boolean containsOnlyText(String s) {
        return false;
    }

    @Override
    public boolean containsSelectOption(String s) {
        return false;
    }

    @Override
    public WebElementState shouldContainText(String s) {
        return null;
    }

    @Override
    public WebElementState shouldContainOnlyText(String s) {
        return null;
    }

    @Override
    public WebElementState shouldContainSelectedOption(String s) {
        return null;
    }

    @Override
    public WebElementState shouldNotContainText(String s) {
        return null;
    }

    @Override
    public WebElementState shouldBeEnabled() {
        return null;
    }

    @Override
    public boolean isDisabled() {
        return false;
    }

    @Override
    public WebElementState shouldNotBeEnabled() {
        return null;
    }

    @Override
    public String getSelectedVisibleTextValue() {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T waitUntilEnabled() {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T waitUntilClickable() {
        return null;
    }

    @Override
    public <T extends WebElementFacade> T waitUntilDisabled() {
        return null;
    }

    @Override
    public void submit() {

    }

    @Override
    public void click(ClickStrategy clickStrategy) {

    }

    @Override
    public void doubleClick() {

    }

    @Override
    public void contextClick() {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public boolean containsElements(By by) {
        return false;
    }

    @Override
    public boolean containsElements(String s) {
        return false;
    }

    @Override
    public WebElementState shouldContainElements(By by) {
        return null;
    }

    @Override
    public WebElementState shouldContainElements(String s) {
        return null;
    }

    @Override
    public boolean hasClass(String s) {
        return false;
    }

    @Override
    public WebElement getElement() {
        return null;
    }

    @Override
    public ListOfWebElementFacades findNestedElementsMatching(ResolvableElement resolvableElement) {
        return null;
    }

    @Override
    public void setImplicitTimeout(Duration duration) {

    }

    @Override
    public Duration getCurrentImplicitTimeout() {
        return null;
    }

    @Override
    public Duration resetTimeouts() {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }

    @Override
    public WebElement getWrappedElement() {
        return null;
    }

    @Override
    public Coordinates getCoordinates() {
        return null;
    }
}
