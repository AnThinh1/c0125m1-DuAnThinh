public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Hiển thị ra màn hình dễ đọc
    public void display() {
        System.out.println("Mã: " + id + ", Tên: " + name + ", Giá: " + price);
    }

    // Định dạng dòng CSV để lưu file
    @Override
    public String toString() {
        return id + "," + name + "," + price;
    }
}
