import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Width: ");
        int width = sc.nextInt();
        System.out.print("Height: ");
        int height = sc.nextInt();
        Rectangle abc = new Rectangle(width, height);

        abc.getArea();
        abc.getPerimeter();
    }
}