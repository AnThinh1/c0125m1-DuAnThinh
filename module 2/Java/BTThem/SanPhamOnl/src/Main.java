public class Main {
    public static void main(String[] args) {
        Product product1 = ProductFactory.createProduct("tshirt");
        Product product2 = ProductFactory.createProduct("shoe");
        Product product3 = ProductFactory.createProduct("hat");

        System.out.println("--- Thông tin sản phẩm ---");
        product1.displayInfo();
        System.out.println();
        product2.displayInfo();
        System.out.println();
        product3.displayInfo();

        System.out.println("\n--- Thông tin cấu hình hệ thống ---");
        AppConfig config = AppConfig.getInstance();
        System.out.println("Tên cửa hàng: " + config.getStoreName());
        System.out.println("Ngôn ngữ: " + config.getLanguage());
        System.out.println("Đơn vị tiền tệ: " + config.getCurrency());
        System.out.println("Thuế mặc định: " + (config.getDefaultTaxRate() * 100) + "%");
    }
}
