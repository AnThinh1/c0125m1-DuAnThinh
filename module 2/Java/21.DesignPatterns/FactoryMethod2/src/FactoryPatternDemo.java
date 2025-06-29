public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Tạo hình tròn
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        // Tạo hình vuông
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();

        // Tạo hình chữ nhật
        Shape shape3 = shapeFactory.getShape("RECTANGLE");
        shape3.draw();
    }
}
