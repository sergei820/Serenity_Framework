package integrations.testrail;

import com.codepine.api.testrail.model.Run;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static integrations.testrail.TestRailIntegration.testRail;
import static integrations.testrail.TestRailProject.getProjectId;
import static integrations.testrail.TestRailProject.getSuiteId;

public class TestRailRun {

    // ******* Getter and setter for Run object **************
    public static Run run;
    public static Run getRun() {
        return run;
    }
    public void setRun(Run run) {
        this.run = run;
    }

    // ***** Create Run Function *********
    public static void createRun() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyy kk mm s");
        Date date = new Date();
        String dateString = format.format(date);
        String runName = "Automation " + dateString;
        try{
            run = new Run();
            run = testRail.runs().add(getProjectId(), run.setSuiteId(getSuiteId()).setName(runName).setIncludeAll(false)).execute();
            //setRun(run);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // **** This will add case id into current run
    public static void updateRun(Object caseIdString){
        try{
            if(null != caseIdString){
                Integer caseId = Integer.parseInt(caseIdString.toString());
                caseIds.add(caseId);
                getRun().setCaseIds(caseIds);
                testRail().runs().update(getRun()).execute();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    // **** below function help to add result for a test case
// with comment pass in function *********
    public static void addResult(String comment, int caseId){
        try{
            if(null != testRail() ){
                List customResultFields = testRail.resultFields().list().execute();
                testRail.results().addForCase(getRun().getId(), caseId, new Result().setComment(comment),
                        customResultFields).execute();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // **** Function use to add final status with comment for a test case ***
    public static void addStatusForCase(int statusId){
        String comment = null;
        try{
            List customResultFields = testRail.resultFields().list().execute();
            testRail.results().addForCase(getRun().getId(), getCurrentCaseId(), new Result().setStatusId(statusId), customResultFields).execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // ***** Close the current run ********
    public static void closeRun(){
        try{
            testRail().runs().close(getRun().getId()).execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
