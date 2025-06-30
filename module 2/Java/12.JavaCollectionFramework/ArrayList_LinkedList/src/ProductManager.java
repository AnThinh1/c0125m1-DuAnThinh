import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public void editProduct(String id, String newName, double newPrice) {
        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) {
                p.setName(newName);
                p.setPrice(newPrice);
                System.out.println("Sửa sản phẩm thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có ID: " + id);
    }

    public void removeProduct(String id) {
        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) {
                products.remove(p);
                System.out.println("Xóa sản phẩm thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có ID: " + id);
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (Product p : products) {
                p.display();
            }
        }
    }

    public void searchProductByName(String name) {
        boolean found = false;
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                p.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào có tên chứa: " + name);
        }
    }

    public void sortByPriceAscending() {
        Collections.sort(products, Comparator.comparingDouble(Product::getPrice));
        System.out.println("Đã sắp xếp theo giá tăng dần.");
    }

    public void sortByPriceDescending() {
        Collections.sort(products, Comparator.comparingDouble(Product::getPrice).reversed());
        System.out.println("Đã sắp xếp theo giá giảm dần.");
    }
}
