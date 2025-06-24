import java.util.Scanner;

public class DaoNguoc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;

        // Nhập số nguyên dương
        do {
            System.out.print("Nhập số nguyên lớn hơn 0: ");
            number = sc.nextInt();
            if (number <= 0) {
                System.out.println("Số phải lớn hơn 0. Nhập lại!");
            }
        } while (number <= 0);

        // Đảo ngược số
        int reversed = 0;
        while (number > 0) {
            int digit = number % 10;         // Lấy chữ số cuối
            reversed = reversed * 10 + digit; // Thêm vào kết quả
            number /= 10;                    // Bỏ chữ số cuối đi
        }

        // In kết quả
        System.out.println("Số đảo ngược là: " + reversed);
    }
}
