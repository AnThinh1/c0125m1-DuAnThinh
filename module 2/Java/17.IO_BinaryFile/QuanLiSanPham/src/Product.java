import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private double price;
    private String manufacturer;
    private String description;

    public Product(String id, String name, double price, String manufacturer, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void display() {
        System.out.println("Mã: " + id + ", Tên: " + name + ", Giá: " + price +
                ", Hãng: " + manufacturer + ", Mô tả: " + description);
    }
}
