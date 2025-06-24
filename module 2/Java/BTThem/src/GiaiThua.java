import java.util.Scanner;

public class GiaiThua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;


        do {
            System.out.print("Nhập số nguyên không âm: ");
            n = sc.nextInt();
            if (n < 0) {
                System.out.println("Số phải ≥ 0. Nhập lại!");
            }
        } while (n < 0);

        long giaiThua = 1;
        for (int i = 1; i <= n; i++) {
            giaiThua *= i;
        }

        System.out.println(n + "! = " + giaiThua);
    }
}

