package starter;

import integrations.APIException;
import integrations.TestRailManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SerenityListeners;
import net.serenitybdd.core.SerenityReports;
import utils.ContextKeeper;

import java.io.IOException;

import static integrations.SlackIntegration.sendMessageToSlack;

public class ReportSender {

    @Before
    public static void setPreconditions() {

    }

    @After
    public static void sendSerenityReportToSlack() {
        sendMessageToSlack("Serenity Report: file:///C:/Mentoring/project/Serenity_Framework/target/site/serenity/index.html");
    }

    @After
    public static void tearDownForTestRail() {
        String testId = String.valueOf(ContextKeeper.INSTANCE.getTestCaseId());
        try {
            TestRailManager.addResultForTestCase(testId, TestRailManager.TEST_CASE_PASSED_STATUS, "");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }
    }
}
