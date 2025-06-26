public class TShirt extends Product {
    public TShirt() {
        super("Áo thun", 200_000);
    }

    @Override
    public void displayInfo() {
        System.out.println("Sản phẩm: " + name);
        System.out.println("Giá: " + price + " " + AppConfig.getInstance().getCurrency());
    }
}
