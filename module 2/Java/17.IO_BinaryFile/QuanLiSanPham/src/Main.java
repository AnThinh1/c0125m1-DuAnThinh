import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị tất cả sản phẩm");
            System.out.println("3. Tìm kiếm theo mã");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear bộ đệm

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập giá: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Nhập hãng sản xuất: ");
                    String manufacturer = sc.nextLine();
                    System.out.print("Nhập mô tả: ");
                    String description = sc.nextLine();

                    Product p = new Product(id, name, price, manufacturer, description);
                    manager.addProduct(p);
                    System.out.println("Thêm sản phẩm thành công.");
                    break;

                case 2:
                    List<Product> products = manager.getAllProducts();
                    if (products.isEmpty()) {
                        System.out.println("Danh sách trống.");
                    } else {
                        for (Product prod : products) {
                            prod.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã cần tìm: ");
                    String searchId = sc.nextLine();
                    Product found = manager.findProductById(searchId);
                    if (found != null) {
                        found.display();
                    } else {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
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
