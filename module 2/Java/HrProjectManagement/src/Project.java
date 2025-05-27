import java.util.*;
class Project {
    private String projectId;
    private String projectName;
    private List<Employee> members;

    public Project(String projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.members = new ArrayList<>();
    }

    public String getProjectId() {
        return projectId;
    }

    public void addMember(Employee e) {
        members.add(e);
    }

    public String getProjectName() {
        return projectName;
    }

    public void printMembers() {
        System.out.println("Project: " + projectName);
        for (Employee e : members) {
            System.out.println(" - " + e.getDetails());
        }
    }
}
