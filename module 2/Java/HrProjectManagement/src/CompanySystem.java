import java.util.*;

class CompanySystem {
    private List<Employee> employees = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();

    public String getProjectId() {
        return projectId;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public void addProject(Project p) {
        projects.add(p);
    }

    public void assignEmployeeToProject(String empId, String projId) {
        Employee emp = employees.stream().filter(e -> e.getId().equals(empId)).findFirst().orElse(null);
        Project proj = projects.stream().filter(p -> p.getProjectId().equals(projId)).findFirst().orElse(null);

        if (emp != null && proj != null) {
            proj.addMember(emp);
        }
    }

    public void showAllEmployees() {
        for (Employee e : employees) {
            System.out.println(e.getDetails());
        }
    }

    public void showAllProjects() {
        for (Project p : projects) {
            p.printMembers();
        }
    }
}