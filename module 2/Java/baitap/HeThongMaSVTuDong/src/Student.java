public class Student {
    private String name;
    private int id;
    private static int nextId = 1000;

    public Student(String name) {
        this.name = name;
        this.id = nextId++;
    }

    public void display() {
        System.out.println("Tên: " + name + ", Mã sinh viên: " + id);
    }
}