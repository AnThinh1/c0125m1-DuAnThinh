public class FactoryDemo {
    public static void main(String[] args) {
        FactoryAnimal animalFactory = new FactoryAnimal();

        Animal a1 = animalFactory.getAnimal("dog");
        System.out.println("a1 sound: " + a1.makeSound());

        Animal a2 = animalFactory.getAnimal("meo");
        System.out.println("a2 sound: " + a2.makeSound());
    }
}