import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- MENU QUẢN LÝ SẢN PHẨM ----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm theo ID");
            System.out.println("3. Xóa sản phẩm theo ID");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần");
            System.out.println("7. Sắp xếp sản phẩm theo giá giảm dần");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Clear bộ đệm

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập giá: ");
                    double price = sc.nextDouble();
                    manager.addProduct(new Product(id, name, price));
                    System.out.println("Thêm sản phẩm thành công.");
                    break;

                case 2:
                    System.out.print("Nhập ID cần sửa: ");
                    String editId = sc.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String newName = sc.nextLine();
                    System.out.print("Nhập giá mới: ");
                    double newPrice = sc.nextDouble();
                    manager.editProduct(editId, newName, newPrice);
                    break;

                case 3:
                    System.out.print("Nhập ID cần xóa: ");
                    String removeId = sc.nextLine();
                    manager.removeProduct(removeId);
                    break;

                case 4:
                    manager.displayProducts();
                    break;

                case 5:
                    System.out.print("Nhập tên cần tìm: ");
                    String searchName = sc.nextLine();
                    manager.searchProductByName(searchName);
                    break;

                case 6:
                    manager.sortByPriceAscending();
                    break;

                case 7:
                    manager.sortByPriceDescending();
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
