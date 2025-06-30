import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static final String FILE_PATH = "products1.txt";
    private List<Product> products = new ArrayList<>();

    public ProductManager() {
        readFromFile();
    }

    // Đọc danh sách sản phẩm từ file
    public void readFromFile() {
        products.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    products.add(new Product(id, name, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Không tìm thấy hoặc lỗi đọc file.");
        }
    }

    // Ghi toàn bộ danh sách sản phẩm vào file (ghi đè)
    public void writeToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Product p : products) {
                bw.write(p.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public void addProduct(Product p) {
        products.add(p);
        writeToFile();
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

    public void displayProductsPriceOver200() {
        boolean found = false;
        for (Product p : products) {
            if (p.getPrice() >= 200000) {
                p.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có sản phẩm nào giá từ 200.000 trở lên.");
        }
    }

    public void updatePriceById(String id, double newPrice) {
        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) {
                p.setPrice(newPrice);
                writeToFile();
                System.out.println("Cập nhật giá thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã: " + id);
    }
}
