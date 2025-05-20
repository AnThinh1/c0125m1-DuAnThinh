import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất: ");
        int a = sc.nextInt();
        System.out.print("Nhập số thứ hai: ");
        int b = sc.nextInt();

        System.out.println("Cộng: " + Calculator.add(a, b));
        System.out.println("Trừ: " + Calculator.subtract(a, b));
        System.out.println("Nhân: " + Calculator.multiply(a, b));
        System.out.println("Chia: " + Calculator.divide(a, b));
    }

}