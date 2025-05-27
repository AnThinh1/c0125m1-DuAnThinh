public class Student {
    String name;
    int age;
    double grade;

    public Student (String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void displayInfo() {
        System.out.println("Tên: "+ this.name + "\n" + this.age + " tuổi\n" + this.grade + " điểm");
    }
}
