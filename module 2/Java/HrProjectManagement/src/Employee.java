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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
    public abstract double calculateSalary();
    public abstract String getDetails();
}