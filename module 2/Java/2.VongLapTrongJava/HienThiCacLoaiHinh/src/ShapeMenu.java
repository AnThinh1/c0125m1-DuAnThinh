import java.util.Scanner;
public class ShapeMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
    while (choice !=0) {
        System.out.println("Menu:");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle (4 corners)");
        System.out.println("3. Print isosceles triangle");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("\nRetangle:");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 6; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case 2: System.out.println("\nTriangle:");
                for (int i = 1; i <= 5; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                System.out.println("\nSquare triangle - top-left:");
                for (int i = 5; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }

                System.out.println("\nSquare triangle - bottom-right:");
                for (int i = 1; i <= 5; i++) {
                    for (int j = 1; j <= 5 - i; j++) {
                        System.out.print("  ");
                    }
                    for (int k = 1; k <= i; k++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }

                System.out.println("\nSquare triangle - top-right:");
                for (int i = 5; i >= 1; i--) {
                    for (int j = 1; j <= 5 - i; j++) {
                        System.out.print("  ");
                    }
                    for (int k = 1; k <= i; k++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case 3: System.out.println("\nIsosceles Triangle:");
                for (int i = 1; i <= 5; i++) {
                    for (int j = 1; j <= 5 - i; j++) {
                        System.out.print("  ");
                    }
                    for (int k = 1; k <= 2 * i - 1; k++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                System.exit(0);
        }
        System.out.println();
    }
    }
    }
