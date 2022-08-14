# Serenity BDD Starter project

Project contains:
Java 17
Maven
Serenity BDD framework
TestNG (for TestRail integration)

#Configuretion:
serenity.conf


## Running the tests under Maven
To run tests, perform:

    mvn clean verify

## Viewing the reports

Both of the commands provided above will produce a Serenity test report in the `target/site/serenity` directory. Go take a look!

## Slack channel

Check messages in Slack chat:
https://app.slack.com/client/T03SM3LDSG4/C03S43FGCK1/rimeto_profile/U03SC23V0T0

IMPORTANT!
Slack Webhook deletes sometimes, in this case create new:
https://api.slack.com/apps/A03SC3QHSUE/incoming-webhooks?success=1
and update variable value SlackIntegration.WEB_HOOK_URL

## Report portal

Start the application:
docker-compose -p reportportal up -d --force-recreate

UI can be opened if container runs:
http://localhost:8080/ui/#login?redirectPath=%2Fdefault_personal%2Fdashboard

Default User: default\1q2w3e
Administrator: superadmin\erebus1

## Testrail

https://serenityframework.testrail.io/
se25051990@gmail.com
asd123_QWE

Check test run results here:
https://serenityframework.testrail.io/index.php?/runs/view/1&group_by=cases:section_id&group_order=asc