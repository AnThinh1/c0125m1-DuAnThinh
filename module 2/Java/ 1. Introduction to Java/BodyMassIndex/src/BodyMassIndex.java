import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight, height, bmi;


        System.out.print("Your weight (in kilogram): ");
        weight = sc.nextDouble();
        System.out.print("Your height (in meter): ");
        height = sc.nextDouble();


        bmi = weight / (height * height);
        System.out.println("Chỉ số bmi của bạn là: " + bmi);


        if (bmi >= 30.0) {
            System.out.println("Obese");
        } else if (bmi >= 25.0) {
            System.out.println("OverWeight");
        } else if (bmi >= 18.5) {
            System.out.println("Normal");
        } else {
            System.out.println("Underweight");
        }
    }
}
