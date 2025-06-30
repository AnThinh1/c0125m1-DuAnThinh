import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập cạnh a: ");
            double a = sc.nextDouble();
            System.out.print("Nhập cạnh b: ");
            double b = sc.nextDouble();
            System.out.print("Nhập cạnh c: ");
            double c = sc.nextDouble();

            checkTriangle(a, b, c);
            System.out.println("Ba cạnh hợp lệ, tạo thành tam giác.");

        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public static void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Cạnh tam giác phải lớn hơn 0.");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh phải lớn hơn cạnh còn lại.");
        }
    }
}
