public class Main {
    public static void main(String[] args) {
        CompanySystem system = new CompanySystem();

        Employee e1 = new FullTimeEmployee("E001", "Nguyen Van A", "a@email.com", 1000, 300);
        Employee e2 = new Intern("E002", "Le Thi B", "b@email.com", 500, "Nguyen Van A");
        Employee e3 = new Contractor("E003", "Tran Van C", "c@email.com", 100, 10);

        system.addEmployee(e1);
        system.addEmployee(e2);
        system.addEmployee(e3);

        Project p1 = new Project("P001", "Project Alpha");
        Project p2 = new Project("P002", "Project Beta");

        system.addProject(p1);
        system.addProject(p2);

        system.assignEmployeeToProject("E001", "P001");
        system.assignEmployeeToProject("E002", "P001");
        system.assignEmployeeToProject("E003", "P002");

        System.out.println("=== All Employees ===");
        system.showAllEmployees();

        System.out.println("\n=== All Projects ===");
        system.showAllProjects();
    }
}
