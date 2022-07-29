package net.serenitybdd.starter.fetests.testCases;

import net.serenitybdd.starter.annotations.UITest;
import net.serenitybdd.starter.fetests.testSteps.InventoryPageSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

import static net.serenitybdd.starter.fetests.pageObjects.BasePage.SAUCE_LABS_BOLT_T_SHIRT;
import static model.model.UserFactory.createValidUser;

public class CheckItemsMaterialsTest {

    @Steps
    InventoryPageSteps inventoryPageSteps;

    @UITest
    @Test
    public void checkMaterials() {
        //startApp();
        //logIn(createValidUser());
        //inventoryPageSteps.checkDescriptionOnUI(SAUCE_LABS_BOLT_T_SHIRT);
        //stopApp();
    }
}
