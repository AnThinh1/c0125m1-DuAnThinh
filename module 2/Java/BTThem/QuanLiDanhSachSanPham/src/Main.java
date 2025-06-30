import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm mới");
            System.out.println("3. Hiển thị sản phẩm có giá từ 200.000 trở lên");
            System.out.println("4. Cập nhật giá sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Clear bộ đệm

            switch (choice) {
                case 1:
                    manager.displayProducts();
                    break;

                case 2:
                    System.out.print("Nhập mã sản phẩm: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    double price = sc.nextDouble();
                    manager.addProduct(new Product(id, name, price));
                    System.out.println("Thêm sản phẩm thành công.");
                    break;

                case 3:
                    manager.displayProductsPriceOver200();
                    break;

                case 4:
                    System.out.print("Nhập mã sản phẩm cần cập nhật giá: ");
                    String updateId = sc.nextLine();
                    System.out.print("Nhập giá mới: ");
                    double newPrice = sc.nextDouble();
                    manager.updatePriceById(updateId, newPrice);
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
