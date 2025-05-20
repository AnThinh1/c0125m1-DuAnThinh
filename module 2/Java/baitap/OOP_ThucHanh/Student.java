public class Student {
    private String name;
    private int id;
    private static int nextId = 1000; // ID bắt đầu từ 1000

    public Student(String name) {
        this.name = name;
        this.id = nextId;
        nextId++; // Tăng id cho sinh viên kế tiếp
    }

    public void display() {
        System.out.println("Tên: " + name + ", Mã sinh viên: " + id);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");

        s1.display(); // Tên: Alice, Mã sinh viên: 1000
        s2.display(); // Tên: Bob, Mã sinh viên: 1001
        s3.display(); // Tên: Charlie, Mã sinh viên: 1002
    }
}
