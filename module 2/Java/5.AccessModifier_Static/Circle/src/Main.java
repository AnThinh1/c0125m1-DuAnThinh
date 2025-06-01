//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(); // dùng constructor không tham số
        Circle c2 = new Circle(2.5, "blue"); // dùng constructor có tham số

        System.out.println("Circle 1 - Radius: " + c1.getRadius() + ", Area: " + c1.getArea()+" "+c1.getColor());
        System.out.println("Circle 2 - Radius: " + c2.getRadius() + ", Area: " + c2.getArea()+" "+c2.getColor());
    }
}