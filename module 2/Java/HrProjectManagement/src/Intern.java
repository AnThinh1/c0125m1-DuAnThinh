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