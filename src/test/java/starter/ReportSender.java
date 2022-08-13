package starter;

import integrations.TestRailManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static integrations.SlackIntegration.sendMessageToSlack;

public class ReportSender {

    @Before
    public static void setPreconditions() {

    }

    @After
    public static void sendSerenityReportToSlack() {
        sendMessageToSlack("Serenity Report: file:///C:/Mentoring/project/Serenity_Framework/target/site/serenity/index.html");
        TestRailManager.addResultForTestCase(testCaseId, TestRailManager.TEST_CASE_PASSED_STATUS, "");
    }
}
