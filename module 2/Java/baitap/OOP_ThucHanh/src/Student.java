import java.util.Scanner;
public class Student {
    String name;
    int age;
    double grade;

    public Student(String name, int age, double grade) {
        this.name=name;
        this.age=age;
        this.grade=grade;
    }
    public void displayStudent() {
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Điểm: " + grade);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = sc.nextInt();

        System.out.print("Nhập điểm: ");
        double grade = sc.nextDouble();
        Student s = new Student(name, age, grade);

        // In thông tin
        System.out.println("\nThông tin sinh viên:");
        s.displayStudent();
    }
}
