package integrations;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.Serenity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;

public class SlackIntegrationTest {

    public static void main(String[] args) {
        Eyes eyes = new Eyes();

        eyes.setApiKey(System.getenv("APPLITOOLS_API_KEY"));

        // set BatchInfo (just for the sake of the example)
        BatchInfo bi = new BatchInfo("Hello World");
        eyes.setBatch(bi);

        WebDriver driver = Serenity.getDriver();

        // Open eyes to get ready to grab screenshots
        eyes.open(driver, "My Slack Integration App", "Slack Integration Test", new RectangleSize(800, 600));

        // Navigate to the page under test
        driver.get("https://applitools.com/helloworld"); // Baseline
        //driver.get("https://applitools.com/helloworld?diff1"); // Checkpoint

        // Grab screenshot and upload to Applitools
        eyes.checkWindow();

        // Close web driver
        driver.quit();

        // Close eyes and get the TestResults Object with all the data we need
        TestResults testResults = eyes.close(false);

        // Post to results to Slack, passing the SLACK_WEBHOOK_URL we are getting from  an environment variable
        post(testResults , System.getenv("SLACK_WEBHOOK_URL"));
    }


    public static void post(TestResults testResults , String slackWebhookURL)
    {
        String messageColor = "";
        String fallback = "Applitools Test Results";

        // Check if test was aborted
        if(testResults.isAborted())
            messageColor = "A9A9A9"; // Dark Gray

        // Check the test results and set the color and Slack notification message
        switch(testResults.getStatus())
        {
            case Failed:
                messageColor = "FF0000"; // Red
                fallback = "Test Failed: " + testResults.getName();
                break;
            case Passed:
                messageColor = "36a64f"; // Green
                fallback = "Test Successfully Completed: " + testResults.getName();
                break;
            case Unresolved:
                messageColor = "FFA500"; // Orange
                fallback = "Test Mismatches Found: " + testResults.getName();
                break;
        }

        // build the httpClient object which will send our request to Slack Webhook
        HttpClient httpClient = HttpClientBuilder.create().build();

        try {

            // build the HttpPost request object
            HttpPost request = new HttpPost(slackWebhookURL);

            // build the HTTP request
            StringEntity params =new StringEntity("{\n" +
                    "\"attachments\": [\n" +
                    "{\n" +
                    "\"fallback\": \"" + fallback + ".\",\n" +
                    "\"color\": \"#" + messageColor + "\",\n" +
                    "\"pretext\": \"" + testResults.getStatus().toString() + "\",\n" +
                    "\"author_name\": \"Applitools.com\",\n" +
                    "\"author_link\": \"https://eyes.applitools.com\",\n" +
                    "\"author_icon\": \"https://applitools.com/images/favicon.ico\",\n" +
                    "\"title\": \"See Results\",\n" +
                    "\"title_link\": \"" + testResults.getAppUrls().getBatch() + "\",\n" +
                    "\"fields\": [\n" +
                    "{\n" +
                    "\"title\": \"App\",\n" +
                    "\"value\": \"" + testResults.getAppName() + "\",\n" +
                    "\"short\": true\n" +
                    "}\n," +
                    "{\n" +
                    "\"title\": \"Test\",\n" +
                    "\"value\": \"" + testResults.getName() + "\",\n" +
                    "\"short\": true\n" +
                    "}\n," +
                    "{\n" +
                    "\"title\": \"Batch\",\n" +
                    "\"value\": \"" + testResults.getBatchName() + "\",\n" +
                    "\"short\": true\n" +
                    "}\n," +
                    "{\n" +
                    "\"title\": \"Branch\",\n" +
                    "\"value\": \"" + testResults.getBranchName() + "\",\n" +
                    "\"short\": true\n" +
                    "}\n," +
                    "{\n" +
                    "\"title\": \"OS\",\n" +
                    "\"value\": \"" + testResults.getHostOS() + "\",\n" +
                    "\"short\": true\n" +
                    "}\n," +
                    "{\n" +
                    "\"title\": \"Browser\",\n" +
                    "\"value\": \"" + testResults.getHostApp() + "\",\n" +
                    "\"short\": true\n" +
                    "}\n," +
                    "{\n" +
                    "\"title\": \"Viewport\",\n" +
                    "\"value\": \"" + testResults.getHostDisplaySize() + "\",\n" +
                    "\"short\": true\n" +
                    "}\n," +
                    "{\n" +
                    "\"title\": \"Duration\",\n" +
                    "\"value\": \"" + testResults.getDuration() + " Seconds\",\n" +
                    "\"short\": true\n" +
                    "}\n," +
                    "{\n" +
                    "\"title\": \"Steps\",\n" +
                    "\"value\": \"" + testResults.getSteps() + " Steps\",\n" +
                    "\"short\": true\n" +
                    "}\n" +
                    "],\n" +
                    "\"footer\": \"Test Start Time\",\n" +
                    "\"footer_icon\": \"https://applitools.com/images/favicon.ico\",\n" +
                    "\"ts\": " + testResults.getStartedAt().getTimeInMillis()/1000 + "\n" +
                    "}\n" +
                    "]\n" +
                    "}");
            request.addHeader("content-type", "application/x-www-form-urlencoded");
            request.setEntity(params);

            // Executes the HTTP request
            HttpResponse response = httpClient.execute(request);

        }catch (Exception ex) {
            //handle exception here
        }
    }
}
