package integrations.testrail;

import com.codepine.api.testrail.TestRail;
import lombok.Getter;

public class TestRailIntegration {

    static TestRail testRail;
    private final static String endPoint = "http://testrail.company.com";
    private final static String username = "username";
    private final static String password = "password";

    public static TestRail  createTestRailInstance() {
        if (testRail == null) {
            testRail = TestRail.builder(endPoint, username, password).build();
        }
        return testRail;
    }
}
