public class ProductFactory {
    public static Product createProduct(String type) {
        switch (type.toLowerCase()) {
            case "tshirt":
                return new TShirt();
            case "shoe":
                return new Shoe();
            case "hat":
                return new Hat();
            default:
                throw new IllegalArgumentException("Loại sản phẩm không hợp lệ: " + type);
        }
    }
}
