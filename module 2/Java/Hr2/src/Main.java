import java.util.*;

// === Lớp trừu tượng Employee ===
abstract class Employee {
    private String id;
    private String name;
    private String email;
    protected double baseSalary;

    public Employee(String id, String name, String email, double baseSalary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.baseSalary = baseSalary;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public abstract double calculateSalary();
    public abstract String getDetails();
}

// === Các lớp con kế thừa Employee ===

class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(String id, String name, String email, double baseSalary, double bonus) {
        super(id, name, email, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    public String getDetails() {
        return "[Full-Time] " + getName() + ", Email: " + getEmail() + ", Salary: " + calculateSalary();
    }
}

class Intern extends Employee {
    private String mentor;

    public Intern(String id, String name, String email, double baseSalary, String mentor) {
        super(id, name, email, baseSalary);
        this.mentor = mentor;
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public String getDetails() {
        return "[Intern] " + getName() + ", Mentor: " + mentor + ", Email: " + getEmail() + ", Salary: " + calculateSalary();
    }
}

class Contractor extends Employee {
    private int workingHours;
    private double hourlyRate;

    public Contractor(String id, String name, String email, int workingHours, double hourlyRate) {
        super(id, name, email, 0); // baseSalary = 0
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }

    @Override
    public String getDetails() {
        return "[Contractor] " + getName() + ", Email: " + getEmail() + ", Salary: " + calculateSalary();
    }
}

// === Lớp Project ===

class Project {
    private String projectId;
    private String projectName;
    private List<Employee> members = new ArrayList<>();

    public Project(String projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void addMember(Employee e) {
        members.add(e);
    }

    public void printMembers() {
        System.out.println("Project ID: " + projectId + ", Name: " + projectName);
        if (members.isEmpty()) {
            System.out.println(" - (Không có thành viên)");
        } else {
            for (Employee e : members) {
                System.out.println(" - " + e.getDetails());
            }
        }
    }

}

// === Hệ thống quản lý công ty ===

class CompanySystem {
    private List<Employee> employees = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();

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
        } else {
            System.out.println("Không tìm thấy nhân viên hoặc dự án.");
        }
    }

    public void showAllEmployees() {
        System.out.println("\n=== Danh sách nhân viên ===");
        for (Employee e : employees) {
            System.out.println(e.getDetails());
        }
    }

    public void showAllProjects() {
        System.out.println("\n=== Danh sách dự án ===");
        for (Project p : projects) {
            p.printMembers();
        }
    }
}

// === Main (có nhập từ bàn phím) ===

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CompanySystem system = new CompanySystem();

        System.out.print("Nhập số lượng nhân viên: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhân viên thứ " + (i + 1) + " ---");
            System.out.print("Loại nhân viên (1: FullTime, 2: Intern, 3: Contractor): ");
            int type = Integer.parseInt(sc.nextLine());

            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Họ tên: ");
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();

            if (type == 1) {
                System.out.print("Lương cơ bản: ");
                double base = Double.parseDouble(sc.nextLine());
                System.out.print("Bonus: ");
                double bonus = Double.parseDouble(sc.nextLine());
                system.addEmployee(new FullTimeEmployee(id, name, email, base, bonus));
            } else if (type == 2) {
                System.out.print("Lương cơ bản: ");
                double base = Double.parseDouble(sc.nextLine());
                System.out.print("Mentor: ");
                String mentor = sc.nextLine();
                system.addEmployee(new Intern(id, name, email, base, mentor));
            } else if (type == 3) {
                System.out.print("Số giờ làm: ");
                int hours = Integer.parseInt(sc.nextLine());
                System.out.print("Lương mỗi giờ: ");
                double rate = Double.parseDouble(sc.nextLine());
                system.addEmployee(new Contractor(id, name, email, hours, rate));
            } else {
                System.out.println("Loại không hợp lệ.");
            }
        }

        System.out.print("\nNhập số lượng dự án: ");
        int m = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < m; i++) {
            System.out.println("\n--- Dự án thứ " + (i + 1) + " ---");
            System.out.print("ID dự án: ");
            String pid = sc.nextLine();
            System.out.print("Tên dự án: ");
            String pname = sc.nextLine();
            system.addProject(new Project(pid, pname));
        }

        System.out.print("\nNhập số lần gán nhân viên vào dự án: ");
        int k = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < k; i++) {
            System.out.print("ID nhân viên: ");
            String empId = sc.nextLine();
            System.out.print("ID dự án: ");
            String projId = sc.nextLine();
            system.assignEmployeeToProject(empId, projId);
        }

        system.showAllEmployees();
        system.showAllProjects();
    }
}
