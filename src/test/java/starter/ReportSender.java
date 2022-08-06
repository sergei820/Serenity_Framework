package starter;

import io.cucumber.java.After;

import static integrations.SlackIntegration.sendMessageToSlack;

public class ReportSender {

    @After
    public static void sendSerenityReportToSlack() {
        sendMessageToSlack("Serenity Report: file:///C:/Mentoring/project/Serenity_Framework/target/site/serenity/index.html");
    }
}
