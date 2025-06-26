public class Hat extends Product {
    public Hat() {
        super("Mũ lưỡi trai", 150_000);
    }

    @Override
    public void displayInfo() {
        System.out.println("Sản phẩm: " + name);
        System.out.println("Giá: " + price + " " + AppConfig.getInstance().getCurrency());
    }
}
