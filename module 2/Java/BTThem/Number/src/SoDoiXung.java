import java.util.Scanner;

public class SoDoiXung {
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

        int original = number;  // Lưu lại số gốc
        int reversed = 0;


        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }


        if (original == reversed) {
            System.out.println("Đây là số đối xứng.");
        } else {
            System.out.println("Đây không phải là số đối xứng.");
        }
    }
}
