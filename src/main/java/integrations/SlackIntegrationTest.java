package integrations;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.chrome.ChromeDriver;

public class SlackIntegrationTest {

    private static final String APPLITOOLS_API_KEY = "pGYnQUWlq0bTpyKD0HrstU104Ch7j87Lu3rdCdhfPFMMM110";
    private static final String SLACK_WEBHOOK_URL = "https://hooks.slack.com/services/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";

    public static void main(String[] args) {

        Eyes eyes = new Eyes();
        //eyes.setApiKey(System.getenv("APPLITOOLS_API_KEY"));
        eyes.setApiKey(APPLITOOLS_API_KEY);

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driverForSlack/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        // set BatchInfo (just for the sake of the example)
        BatchInfo bi = new BatchInfo("Hello World");
        eyes.setBatch(bi);

        // Open eyes to get ready to grab screenshots
        eyes.open(driver, "Demo App", "Slack Integration Test", new RectangleSize(800, 600));

        //driver.get("https://applitools.com/helloworld"); // Baseline
        driver.get("https://applitools.com/helloworld?diff1"); // Checkpoint

        // Grab screenshot and upload to Applitools
        eyes.checkWindow();
        driver.quit();

        // Close eyes and get the TestResults Object with all the data we need
        TestResults testResults = eyes.close(false);

        // Post to results to Slack, passing the SLACK_WEBHOOK_URL we are getting from  an environment variable
        //EyesSlack.post(testResults , System.getenv("SLACK_WEBHOOK_URL"));
        EyesSlack.post(testResults , SLACK_WEBHOOK_URL);
    }
}
