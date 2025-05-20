public class Car {
    private String name;
    private String engine;
    public static int numberOfCars;
    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }
    void display () {
        System.out.println("Name: " + name + " Number of Cars: " + numberOfCars++);
    }
}