import java.util.Scanner;

public class CV_DT {
    double width;
    double height;

    // Constructor
    public CV_DT(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Tính diện tích
    public double getArea() {
        return width * height;
    }

    // Tính chu vi
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Hiển thị thông tin
    public void displayInfo() {
        System.out.println("Chiều rộng: " + width);
        System.out.println("Chiều dài: " + height);
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi: " + getPerimeter());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chiều rộng: ");
        double width = sc.nextDouble();

        System.out.print("Nhập chiều dài: ");
        double height = sc.nextDouble();

        // Khởi tạo đối tượng
        CV_DT s = new CV_DT(width, height);
        s.displayInfo();
    }
}
