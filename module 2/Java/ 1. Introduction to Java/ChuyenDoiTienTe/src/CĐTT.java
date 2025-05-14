import java.util.Scanner;
public class CĐTT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double dollar;
        System.out.print("Nhập số tiền cần đổi (Dollar): ");
        dollar = sc.nextDouble();
        if (dollar < 0) {
            System.out.print("Nhập số tiền hợp lệ");
        } else {
            double vnd;
            vnd = dollar * 20000;
            System.out.print("Tiền Việt Nam: " + vnd);
        }
    }
}
