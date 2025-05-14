import java.util.Scanner;
public class Hello {
    public static void main(String[] args) {
    Scanner hl = new Scanner(System.in);
    System.out.println("Enter your name: ");
    String name = hl.nextLine();
    System.out.println("Hello: " + name);
    }
}
