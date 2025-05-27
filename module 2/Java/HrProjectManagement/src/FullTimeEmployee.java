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