package net.serenitybdd.starter.fetests.testCasesDEPRECATED.specific;

import net.serenitybdd.starter.annotations.UITest;
import net.serenitybdd.starter.fetests.testSteps.InventoryPageSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class SwitchCaseDemoTest {

    @Steps
    InventoryPageSteps inventoryPageSteps;

    @UITest
    @Test
    public void checkPrices() {
        //startApp();
        //logIn(createValidUser());
        //inventoryPageSteps.checkItemPrice(SAUCE_LABS_BACKPACK);
        //stopApp();
    }

    @UITest
    @Test
    public void checkMaterials() {
        //startApp();
        //logIn(createValidUser());
        //inventoryPageSteps.checkDescriptionOnUI(SAUCE_LABS_BOLT_T_SHIRT);
        //stopApp();
    }
}
