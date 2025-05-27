public class Rectangle {
    int width;
    int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        System.out.println("Area: "+ width*height);
        return width * height;
    }

    public int getPerimeter() {
        System.out.println("Perimeter: "+ 2*(width+height));
        return 2 * (width + height);

    }
}
