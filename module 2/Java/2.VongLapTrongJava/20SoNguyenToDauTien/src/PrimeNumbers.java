import java.util.Scanner;
public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bước 1: Nhập số lượng số nguyên tố cần in
        System.out.print("Nhập số lượng số nguyên tố cần in: ");
        int numbers = sc.nextInt();

        // Bước 2: Khai báo biến đếm
        int count = 0;

        // Bước 3: Biến N dùng để kiểm tra số nguyên tố, bắt đầu từ 2
        int N = 2;

        // Bước 4: Lặp cho đến khi in đủ numbers số nguyên tố
        while (count < numbers) {
            if (isPrime(N)) {
                System.out.print(N + " ");
                count++;
            }
            N++; // kiểm tra số tiếp theo
        }
    }

    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;

    }
}
