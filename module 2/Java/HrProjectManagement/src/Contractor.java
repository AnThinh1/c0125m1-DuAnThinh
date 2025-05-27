class Contractor extends Employee {
    private int workingHours;
    private double hourlyRate;

    public Contractor(String id, String name, String email, int workingHours, double hourlyRate) {
        super(id, name, email, 0);
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
