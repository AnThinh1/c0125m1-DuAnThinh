import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập bán kính: ");
        int radius = scanner.nextInt();

        System.out.print("Nhập chiều cao: ");
        int height = scanner.nextInt();

        double volume = Cylinder.getVolume(radius, height);
        System.out.println("Thể tích hình trụ là: " + volume);

    }
}
