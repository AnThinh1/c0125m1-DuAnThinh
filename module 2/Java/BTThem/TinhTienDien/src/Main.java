import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số kWh tiêu thụ trong tháng: ");
        int kwh = sc.nextInt();

        ElectricityBillCalculator a = new ElectricityBillCalculator();
        double totalAmount = a.calculate(kwh);
        System.out.println("Tổng số tiền phải trả: " + totalAmount + " VNĐ");

    }
}