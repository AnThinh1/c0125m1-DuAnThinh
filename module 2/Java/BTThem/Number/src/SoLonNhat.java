import java.util.Scanner;
public class SoLonNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;


        do {
            System.out.print("Nhập số nguyên dương: ");
            number = sc.nextInt();
            if (number <= 0) {
                System.out.println("Số phải lớn hơn 0. Nhập lại!");
            }
        } while (number <= 0);

        int maxDigit = 0;


        while (number > 0) {
            int digit = number % 10; // Lấy chữ số cuối
            if (digit > maxDigit) {
                maxDigit = digit;    // Cập nhật max nếu tìm thấy lớn hơn
            }
            number /= 10; // Bỏ chữ số cuối đi
        }

        System.out.println("Chữ số lớn nhất là: " + maxDigit);
    }
}
