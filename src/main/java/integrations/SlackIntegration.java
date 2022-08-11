package integrations;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

import java.io.IOException;

public class SlackIntegration {

    private final static String WEB_HOOK_URL = "https://hooks.slack.com/services/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";
    private final static String SLACK_CHANNEL = "at-mentoring-intermediate";

    public static void sendMessageToSlack(String message) {
        try {
            StringBuilder msgBuilder = new StringBuilder();
            msgBuilder.append(message);

            Payload payload = Payload.builder().channel(SLACK_CHANNEL).text(msgBuilder.toString()).build();
            WebhookResponse webhookResponse = Slack.getInstance().send(WEB_HOOK_URL, payload);
            webhookResponse.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
