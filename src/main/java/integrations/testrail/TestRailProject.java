package integrations.testrail;

import com.codepine.api.testrail.TestRail.Projects;
import com.codepine.api.testrail.model.Project;
import com.codepine.api.testrail.model.Suite;

import static integrations.testrail.TestRailIntegration.testRail;

public class TestRailProject {

    // **** Create getter and setter for project id and suite id.
// so that can be use further *********
    private static int projectId;
    private static int suiteId;

    public static int getProjectId() {
        return projectId;
    }
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public static int getSuiteId() {
        return suiteId;
    }
    public void setSuiteId(int suiteId) {
        this.suiteId = suiteId;
    }

    // ********* Function to fetch Project id and suite Id ***********
    public static void setProjectSuiteId(String projectName, String suiteName){
        try{
            Projects projects = testRail.projects();
            java.util.List projectList = projects.list().execute();
            int pid = 0;
            int sid = 0;
            for(Project project : projectList){
                if(project.getName().equals(projectName)){
                    pid = project.getId();
                    setProjectId(pid);
                    System.out.println(pid);
                    break;
                }
            }
            if(pid !=0){
                java.util.List suiteList = testRail.suites().list(pid).execute();
                for(Suite s : suiteList){
                    String sName = s.getName();
                    if(sName.equals(suiteName))
                    {
                        sid = s.getId();
                        setSuiteId(sid);
                        System.out.println(sid);
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
