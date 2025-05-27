public class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public double calculateSalary() {
        return 0;
    }

    public String getType() {
        return "General Employee";
    }

    public String getName() {
        return name;
    }
}
