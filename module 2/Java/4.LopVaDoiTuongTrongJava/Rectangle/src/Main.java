import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap Chieu Rong: ");
        double width = scanner.nextDouble();
        System.out.println("Nhap Chieu Dai: ");
        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println(rectangle.Display());
    }
}

