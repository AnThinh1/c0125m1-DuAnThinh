import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static final String FILE_PATH = "products.dat";

    public void addProduct(Product product) {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                products = (List<Product>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Lỗi đọc file: " + e.getMessage());
            }
        }
        return products;
    }

    public Product findProductById(String id) {
        List<Product> products = getAllProducts();
        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    private void saveProducts(List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(products);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }
}
