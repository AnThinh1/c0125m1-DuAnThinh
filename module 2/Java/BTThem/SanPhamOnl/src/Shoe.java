public class Shoe extends Product {
    public Shoe() {
        super("Giày thể thao", 800_000);
    }

    @Override
    public void displayInfo() {
        System.out.println("Sản phẩm: " + name);
        System.out.println("Giá: " + price + " " + AppConfig.getInstance().getCurrency());
    }
}
