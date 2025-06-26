import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(5, "red", true);
        shapes[1] = new Rectangle(4, 6, "blue", false);

        for (Shape shape : shapes) {
            System.out.println("\nHình hiện tại: " + shape);

            double areaBefore = 0;
            double areaAfter = 0;
            double percent = random.nextInt(100) + 1;

            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                areaBefore = circle.getArea();
                circle.resize(percent);
                areaAfter = circle.getArea();
            } else if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                areaBefore = rectangle.getArea();
                rectangle.resize(percent);
                areaAfter = rectangle.getArea();
            }

            System.out.println("Diện tích trước khi tăng: " + areaBefore);
            System.out.println("Tăng kích thước thêm: " + percent + "%");
            System.out.println("Diện tích sau khi tăng: " + areaAfter);
        }
    }
}
