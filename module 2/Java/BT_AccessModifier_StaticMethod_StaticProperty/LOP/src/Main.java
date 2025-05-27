public class Main {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("An", 15000000);
        Employee e2 = new PartTimeEmployee("Thinh", 100, 80000);
        Intern e3 = new Intern("Charlie", 3000000);

        System.out.println(e1.getName() + " (" + e1.getType() + ") - Salary: " + e1.calculateSalary());
        System.out.println(e2.getName() + " (" + e2.getType() + ") - Salary: " + e2.calculateSalary());
        System.out.println(e3.getName() + " (" + e3.getType() + ") - Salary: " + e3.calculateSalary());

        e3.attendTraining();
    }
}