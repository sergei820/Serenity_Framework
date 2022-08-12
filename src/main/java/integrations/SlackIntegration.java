package integrations;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import utils.PropertiesLoader;

import java.io.IOException;

public class SlackIntegration {

    public static void sendMessageToSlack(String message) {
        try {
            StringBuilder msgBuilder = new StringBuilder();
            msgBuilder.append(message);

            Payload payload = Payload.builder().channel(PropertiesLoader.loadProperty("slackChannel")).text(msgBuilder.toString()).build();
            WebhookResponse webhookResponse = Slack.getInstance().send(PropertiesLoader.loadProperty("webHookUrl"), payload);
            webhookResponse.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
