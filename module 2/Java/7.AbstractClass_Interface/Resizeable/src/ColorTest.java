public class ColorTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(5, "red", true);
        shapes[1] = new Rectangle(4, 6, "blue", false);
        shapes[2] = new Square(3, "yellow", true);
        shapes[3] = new Square(5, "green", true);

        for (Shape shape : shapes) {
            System.out.println("\nHình hiện tại: " + shape);

            double area = 0;
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                area = circle.getArea();
            } else if (shape instanceof Rectangle && !(shape instanceof Square)) {
                Rectangle rectangle = (Rectangle) shape;
                area = rectangle.getArea();
            } else if (shape instanceof Square) {
                Square square = (Square) shape;
                area = square.getArea();
            }

            System.out.println("Diện tích: " + area);

            if (shape instanceof Colorable) {
                Colorable colorable = (Colorable) shape;
                colorable.howToColor();
            }
        }
    }
}
