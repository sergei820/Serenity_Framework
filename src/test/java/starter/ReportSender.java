package starter;

import integrations.testrail.APIException;
import integrations.testrail.TestRailManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import utils.ContextKeeper;

import java.io.IOException;

import static integrations.SlackIntegration.sendMessageToSlack;

public class ReportSender {

    protected String testCaseId;

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

    @AfterMethod
    public void tearDownTestNG(ITestResult result) throws Throwable {
        if(result.getStatus() == ITestResult.SUCCESS) {
            TestRailManager.addResultForTestCase(testCaseId, TestRailManager.TEST_CASE_PASSED_STATUS, "");
        }
        else if (result.getStatus() == ITestResult.FAILURE) {
            TestRailManager.addResultForTestCase(testCaseId, TestRailManager.TEST_CASE_FAILED_STATUS, result.getThrowable().getMessage());
        }
    }
}
